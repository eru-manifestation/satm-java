package com.erumf.phases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jgrapht.alg.util.Pair;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Character;
import com.erumf.elements.Haven;
import com.erumf.elements.Item;
import com.erumf.elements.Location;
import com.erumf.utils.Combinations;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Fellowship;

/**
 * Organization Phase
 * <p>
 * The following actions may be taken in any order:
 * - Play a {@link Character} card or a {@link Character.Race#WIZARD} card (if
 * allowed).
 * - Reorganize your characters at the same Haven into any number of companies.
 * - Shift your characters between being controlled by general influence and
 * being controlled by direct influence.
 * - Transfer items between your characters at the same site. A corruption check
 * is required for the character giving up an item.
 * - Store items or other designated resources from your companies at a Haven
 * site or at sites specified on the item cards. A corruption check is required
 * for the character giving up an item.
 */
public class OrganizationPhase {
    public static void organizationPhase(Player player1) {
        // TODO: Make it so that each action could be taken in any order
        playCharacter(player1);
        boolean done;
        do {
            // TODO: Rewrite the stop condition
            done = organizeCompanies(player1);
            done |= exchangeItems(player1);
            done |= storeItems(player1);
        } while (done);
        // Set the destinations for the fellowships
        player1.setDestinations(player1.getCardsInPlay().stream()
                .filter(Fellowship.class::isInstance)
                .map(Fellowship.class::cast)
                .map(Fellowship::chooseDestination));

        discardExcessCharacters(player1);
    }

    /**
     * Plays a character from the player's hand.
     * The method first finds all the characters in the player's hand that can be
     * played.
     * It then prompts the user to choose a character to play and the position where
     * it can be played.
     * If a valid choice is made, the character is added to the chosen position.
     *
     * @param player the player who is playing the character
     */
    private static void playCharacter(Player player) {
        List<Character> handCharacters = player.getFromHand(Character.class);

        // Play characters with general influence
        List<Pair<Character, Card>> playableCharacters = handCharacters.stream()
                .filter(Character::isPlayable)
                .filter(character -> player.getGeneralInfluence() >= character.getMind())
                .flatMap(character -> playablePositions(character, player))
                .collect(Collectors.toList());

        // Play characters with direct influence
        playableCharacters.addAll(handCharacters.stream()
                .filter(Character::isPlayable)
                .flatMap(handCharacter -> Main.positionGraph.locations.stream()
                        .filter(loc -> loc.getPlace().equals(Location.PlaceType.HAVEN)
                                || loc.getClass().equals(handCharacter.getBirthplace()))
                        .flatMap(loc -> loc.getFellowships().stream())
                        .filter(fell -> fell.getPlayer().equals(player))
                        .filter(fell -> fell.getCompanions()
                                + handCharacter.companionSize() <= Fellowship.MAX_COMPANIONS)
                        .flatMap(fell -> fell.getChildren().stream())
                        .filter(Character.class::isInstance)
                        .map(Character.class::cast)
                        .filter(mapCharacter -> handCharacter.getMind() <= mapCharacter.getInfluence())
                        .map(mapCharacter -> new Pair<Character, Card>(handCharacter, mapCharacter)))
                .toList());

        Pair<Character, Card> choice = ConsoleUtils.chooseActionNoForced("Choose a character to play",
                playableCharacters);
        if (choice != null) {
            switch (choice.getSecond()) {
                case Location location -> {
                    Fellowship fellowship = new Fellowship(player);
                    location.addFellowship(fellowship);
                    player.getHand().remove(choice.getFirst());
                    fellowship.addCompanion(choice.getFirst());
                    break;
                }
                case Fellowship fellowship -> {
                    player.getHand().remove(choice.getFirst());
                    fellowship.addCompanion(choice.getFirst());
                    break;
                }
                case Character character -> {
                    player.getHand().remove(choice.getFirst());
                    character.addFollower(character);
                    break;
                }
                default -> {
                    throw new IllegalStateException("Unexpected value: " + choice.getSecond());
                }
            }
        }
    }

    /**
     * Returns the existing fellowships in which a character could be played inside
     * a location.
     *
     * @param character the character to be played
     * @param location  the location where the character could be played
     * @param player    the player who owns the character
     * @return a list of existing fellowships in which the character could be played
     */
    private static List<Card> fellToPlayCharacter(Character character, Location location, Player player) {
        return location.getChildren()
                .stream()
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                .filter(fell -> ((Fellowship) fell).getCompanions()
                        + character.companionSize() <= Fellowship.MAX_COMPANIONS)
                .toList();
    }

    /**
     * Indicates the different positions in which a character could be played
     * inside a certain location:
     * - In an empty fellowship to be created for himself in the location
     * - In an existing fellowship with the ability to add this companion
     *
     * @param character the character to be played
     * @param player    the player who owns the character
     * @return a stream of pairs representing the character and the positions where
     *         it can be played
     */
    private static Stream<Pair<Character, Card>> playablePositions(Character character, Player player) {
        Set<Card> playablePosition = new HashSet<>();
        Location loc = Main.positionGraph.findLocation(character.getBirthplace());
        Set<? extends Location> playableHavens = character.getRace().equals(Character.Race.WIZARD) ? Main.positionGraph.havens
                : Set.of(Main.positionGraph.rivendell);
        playablePosition.addAll(playableHavens);
        playablePosition.add(loc);
        playablePosition.addAll(fellToPlayCharacter(character, loc, player));
        playablePosition.addAll(playableHavens.stream()
                .flatMap(haven -> fellToPlayCharacter(character, haven, player).stream())
                .toList());
        return playablePosition.stream()
                .map(position -> new Pair<>(character, position));
    }

    private static boolean organizeCompanies(Player player) {
        // * - Reorganize your characters at the same Haven into any number of
        // companies. (select many at a time and choose a company to move them to
        // or create)
        // TODO: handle the condition that in a haven, any fellowship has no growth
        // limit
        List<Pair<List<Character>, Card>> possibleDivisions = Main.positionGraph.havens.stream()
                .flatMap(haven -> haven.getChildren().stream())
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                // Fellowships from this player in havens
                .flatMap(fell -> Combinations.getAllCombinationsExcludingAll(
                        fell.getChildren().stream()
                                .filter(Character.class::isInstance)
                                .map(Character.class::cast)
                                .toList())
                        .stream())
                .flatMap(characters -> allPossibleMovements(characters))
                .toList();

        // * - Shift your characters between being controlled by general influence and
        // * being controlled by direct influence.
        List<Pair<Character, Fellowship>> possibleUnfollowings = player.getCardsInPlay().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast)
                .filter(Character::isFollower)
                .map(foll -> new Pair<>(foll, (Fellowship) foll.getFather().getFather()))
                .filter(pair -> pair.getFirst().companionSize()
                        + pair.getSecond().getCompanions() <= Fellowship.MAX_COMPANIONS)
                .toList();

        List<Pair<Character, Character>> possibleFollowings = player.getCardsInPlay().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast)
                .flatMap(ch -> {
                    Fellowship sourceFell = (Fellowship) (ch.isFollower() ? ch.getFather().getFather()
                            : ch.getFather());
                    return sourceFell.getChildren().stream()
                            .filter(Character.class::isInstance)
                            .map(Character.class::cast)
                            .filter(newCh -> !newCh.isFollower() && newCh != ch && newCh.getInfluence() >= ch.getMind())
                            .map(newCh -> new Pair<>(ch, newCh));
                }).toList();

        // Offer the choices to the player
        Pair<List<Character>, Card> reorganize = ConsoleUtils.<List<Character>, Card>chooseActionNoForced(
                "Reorganize your characters in havens",
                possibleDivisions);
        Pair<Character, Fellowship> unfollowing = ConsoleUtils.<Character, Fellowship>chooseActionNoForced(
                "Shift your characters between being controlled by general influence and being controlled by direct influence",
                possibleUnfollowings);
        Pair<Character, Character> following = ConsoleUtils.<Character, Character>chooseActionNoForced(
                "Shift your characters between being controlled by general influence and being controlled by direct influence",
                possibleFollowings);

        // Apply the choices
        if (reorganize != null) {
            // Move the characters to the fellowship if the second argument is a fellowship
            // if the second argument is a location, create a new fellowship and then move
            // the characters there
            switch (reorganize.getSecond()) {
                case Fellowship fellowship -> {
                    // Move the characters to the fellowship
                    reorganize.getFirst().forEach(ch -> fellowship.addCompanion(ch));
                }
                case Location location -> {
                    // Create a new fellowship
                    Fellowship fellowship = new Fellowship(player);
                    location.addFellowship(fellowship);
                    // Move the characters to the fellowship
                    reorganize.getFirst().forEach(ch -> fellowship.addCompanion(ch));
                }
                default -> {
                    throw new IllegalStateException("Unexpected value: " + reorganize.getSecond());
                }
            }
        }
        if (unfollowing != null) {
            // Move the character to the fellowship
            unfollowing.getSecond().addCompanion(unfollowing.getFirst());
        }
        if (following != null) {
            // Move the character to the other character
            following.getSecond().addFollower(following.getFirst());
        }

        return unfollowing != null || following != null || reorganize != null;
    }

    private static List<Pair<List<Character>, Card>> posibleChoices(List<Fellowship> destinations,
            List<Character> characters) {
        double totalCompanionSize = characters.stream()
                .mapToDouble(Character::companionSize)
                .sum();
        Stream<Pair<List<Character>, Card>> choices = destinations.stream()
                .map(dest -> new Pair<>(characters, (Card) dest))
                .filter(pair -> {
                    if (pair.getSecond() instanceof Fellowship fellowship) {
                        return totalCompanionSize + fellowship.getCompanions() <= Fellowship.MAX_COMPANIONS;
                    } else {
                        return totalCompanionSize <= Fellowship.MAX_COMPANIONS;
                    }
                });
        return choices.toList();
    }

    /**
     * Returns all possible movements for a list of characters.
     * The method finds all possible destinations (fellowships or locations) where
     * the characters can be moved.
     * It ensures that the total companion size of the characters does not exceed
     * the maximum allowed in a fellowship.
     * If the location is chosen, a new fellowship must be created to put them into.
     *
     * @param characters the list of characters to be moved
     * @return a stream of pairs representing the list of characters and the
     *         possible destinations
     */
    private static Stream<Pair<List<Character>, Card>> allPossibleMovements(List<Character> characters) {
        // Get any character that is not a follower
        Character any = characters.stream()
                .filter(ch -> !ch.isFollower())
                .findAny()
                .orElse(null);

        // Fellowships in the same haven
        List<Fellowship> destinations = List.copyOf(any
                .getFather()
                .getFather()
                .getChildren()
                .stream()
                .filter(Fellowship.class::isInstance)
                .map(Fellowship.class::cast)
                .toList());
        // They do not move to their own fellowship
        destinations.remove((Fellowship) any.getFather());

        double totalCompanionSize = characters.stream()
                .mapToDouble(Character::companionSize)
                .sum();
        if (totalCompanionSize <= Fellowship.MAX_COMPANIONS) {
            // Return the possible combinations of groups of characters
            // and destinations in which they may fit
            List<Pair<List<Character>, Card>> choices = posibleChoices(destinations, characters);

            // Add the haven itself as a possible destination
            // to create a new fellowship
            choices.add(new Pair<>(characters, any.getFather().getFather()));
            return choices.stream();
        } else {
            return Stream.empty();
        }
    }

    /**
     * Exchange items between two characters of the same player that are in the same
     * location, after a corruption check if the transfered item has corruption
     * points.
     * 
     * @param player
     * @return false if the player whishes not to exchange any item, true otherwise
     */
    private static boolean exchangeItems(Player player) {
        /*
         * Puedes intercambiar objetos entre tus personajes si están en
         * el mismo lugar, pero antes, el portador de cada objeto deberá
         * hacer un chequeo de corrupción por cada objeto que confiera puntos de
         * corrupción que quiera intercambiar.
         */

        List<Pair<Item, Character>> exchangableItems = player.getCardsInPlay().stream()
                .filter(Item.class::isInstance)
                .map(Item.class::cast)
                .flatMap(item -> item.getOwner().getFellowship().getLocation().getFellowships().stream()
                        .filter(fell -> fell.getPlayer().equals(player))
                        .flatMap(fell -> fell.getCompanionList().stream()
                                .filter(companion -> companion != item.getOwner())
                                .map(companion -> new Pair<>(item, companion))))
                // .filter(item -> item.isExchangeable()) TODO: Implement that only one Armor
                // and one Weapon can be used at a time
                .toList();
        Pair<Item, Character> choice = ConsoleUtils.chooseActionNoForced("Exchange an item between your characters",
                exchangableItems);
        if (choice != null) {
            Item item = choice.getFirst();
            Character owner = item.getOwner();
            Character newOwner = choice.getSecond();
            if (item.getCorruption() > 0) {
                if (!ConsoleUtils.confirmAction("Do you want to make a corruption check to exchange the item?")) {
                    return true;
                } else {
                    if (owner.corruptionCheck()) {
                        // Transfer the item
                        newOwner.addItem(item);
                    }
                }
            }
            // Transfer the item
            newOwner.addItem(item);
            return true;
        }

        return false;
    }

    /**
     * Store items or other designated resources from your companies at a Haven
     * site.
     * A corruption check is required for the character giving up an item (if the
     * item
     * has corruption points). The One Ring cannot be stored.
     * 
     * @param player
     * @return false if the player whishes not to store any item, true otherwise
     */
    private static boolean storeItems(Player player) {
        /*
         * También puedes almacenar objetos si el portador está en un
         * ~ . No hace falta almacenar un objeto para ganar sus PV, pero
         * evitará que lo puedas perder debido a ciertas adversidades y el
         * portador se liberará de sus puntos de corrupción.
         * El personaje que lleva el objeto deberá hacer un chequeo de
         * corrupción antes de almacenarlo. Los objetos almacenados se
         * colocan en la pila de PV. El Anillo Único no puede ser almacenado.
         */
        List<Pair<Item, Haven>> storableItems = Main.positionGraph.havens.stream()
                .flatMap(haven -> haven.getChildren().stream()
                        .filter(Fellowship.class::isInstance)
                        .map(Fellowship.class::cast)
                        .filter(fell -> fell.getPlayer().equals(player))
                        .flatMap(fell -> fell.getCompanionList().stream())
                        .flatMap(ch -> ch.getChildren().stream())
                        .filter(Item.class::isInstance)
                        .map(Item.class::cast)
                        // .filter(isNotTheOneRing) TODO: Implement the One Ring condition to not be
                        // stored
                        .map(item -> new Pair<>(item, haven)))
                .toList();

        Pair<Item, Haven> choice = ConsoleUtils.chooseActionNoForced("Store an item at a Haven",
                storableItems);
        if (choice != null) {
            Item item = choice.getFirst();
            Character owner = item.getOwner();
            if (item.getCorruption() > 0) {
                if (!ConsoleUtils.confirmAction("Do you want to make a corruption check to store the item?")) {
                    return true;
                } else {
                    if (owner.corruptionCheck()) {
                        // Store the item
                        choice.getSecond().storeItem(item);
                    }
                }
            }
            // Store the item
            choice.getSecond().storeItem(item);
            return true;
        }

        return false;
    }

    /**
     * Discard excess characters if the player does not have enough general
     * influence
     * 
     * @param player1
     */
    private static void discardExcessCharacters(Player player) {
        List<Character> companions = player.getCardsInPlay().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast)
                .filter(ch -> !ch.isFollower())
                .toList();
        while (player.getGeneralInfluence() < 0) {
            String choice = ConsoleUtils.chooseFrom(
                    "You must discard a character, the used general influence exceeds the limit.", companions.stream()
                            .map(character -> character.getClass().getSimpleName()).toList());
            Character character = companions.stream()
                    .filter(ch -> ch.getClass().getSimpleName().equals(choice))
                    .findFirst()
                    .orElseThrow();
            // TODO: Implement the special condition of discarding a character
            character.discard();

        }
    }
}
