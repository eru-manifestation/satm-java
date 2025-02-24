package com.erumf.phases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.jgrapht.alg.util.Pair;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Character;
import com.erumf.elements.Fellowship;
import com.erumf.elements.Location;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Card;

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
            done = organizeCompanies(player1);
        } while (done);
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
                .filter(character -> player.isUniqueDisabled(character.getClass()))
                .filter(character -> player.getGeneralInfluence() >= character.getMind())
                .flatMap(character -> playablePositions(character, player))
                .toList();

        // Play characters with direct influence
        playableCharacters.addAll(handCharacters.stream()
                .filter(character -> player.isUniqueDisabled(character.getClass()))
                .flatMap(handCharacter -> Main.positionGraph.locations.stream()
                        .filter(loc -> loc.getPlace().equals(Location.PlaceType.HAVEN)
                                || loc.getClass().equals(handCharacter.getBirthplace()))
                        .flatMap(loc -> loc.getChildren().stream())
                        .filter(Fellowship.class::isInstance)
                        .filter(fell -> fell.getPlayer().equals(player))
                        .filter(fell -> ((Fellowship) fell).getCompanions()
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
                    location.addChild(fellowship);
                    fellowship.addChild(choice.getFirst());
                    break;
                }
                case Fellowship fellowship -> {
                    fellowship.addChild(choice.getFirst());
                    break;
                }
                case Character character -> {
                    character.addChild(choice.getFirst());
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
        Set<Location> playableHavens = character.getRace().equals(Character.Race.WIZARD) ? Main.positionGraph.havens
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

    // WORK IN PROGRESS
    private static boolean organizeCompanies(Player player) {
        // * - Reorganize your characters at the same Haven into any number of
        // companies. (select many at a time and choose a company to move them to
        // or create)

        // player.getCardsInPlay().stream()
        //         .filter(Character.class::isInstance)
        //         .map(Character.class::cast)
        //         .filter(Character::isInHaven)//NO
        //         ;
        Main.positionGraph.havens.stream()
                .flatMap(haven -> haven.getChildren().stream())
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                // Fellowships from this player in havens
                .flatMap(fell -> {
                    // Any combination of characters in this fellowship
                    return null;
                })
                // Transform it into a Pair<List<Character>>, Card> 
                // where card can be an existing fellowship or a Location,
                // meaning to create a new fellowship
                ;
        
        // * - Shift your characters between being controlled by general influence and
        // * being controlled by direct influence.
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
