package com.erumf;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jgrapht.Graph;
import org.jgrapht.alg.util.Pair;

import com.erumf.cards.locations.Locations;
import com.erumf.cards.locations.Locations2;
import com.erumf.cards.starter.deck.StarterCharacters;
import com.erumf.cards.starter.deck.StarterDeck;
import com.erumf.cards.starter.deck.StarterItems;
import com.erumf.cards.starter.deck.StarterItems.ElvenCloak;
import com.erumf.cards.starter.deck.StarterItems.ShieldOfIronBoundAsh;
import com.erumf.elements.Character;
import com.erumf.elements.Fellowship;
import com.erumf.elements.Item;
import com.erumf.elements.Location;
import com.erumf.utils.graph.DefaultPathEdge;
import com.erumf.utils.graph.PositionGraph;
import com.erumf.utils.log.Logger;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Deck;

public class Main {
    public static final Graph<Location, DefaultPathEdge> pathsGraph = Locations2.generateDefaultLocations();
    public static final PositionGraph positionGraph = PositionGraph.generatePositionGraph(pathsGraph);
    public static final Player player1 = new Player("Player 1");
    public static final Player player2 = new Player("Player 2");

    public static void main(String[] args) {

        Logger.info("Starting game...");
        defaultGameSetup();
        startGame(player1);
    }

    public static void instantiateCardInRivendell(Character card) {
        String playerName = card.getPlayer().getName();
        Deck drawDeck = card.getPlayer().getDrawDeck();
        if (!drawDeck.isEmpty()) {
            drawDeck.remove(drawDeck.indexOf(card));
            card.addCharacterToLocation(Locations.Rivendell.class);
            Logger.info("Card " + card.getClass().getSimpleName()
                    + " instantiated in Rivendell for player " + playerName);
        } else {
            Logger.warn("Draw deck is empty for player " + playerName);
        }
    }

    public static void defaultGameSetup() {
        // Set up the players' draw decks
        player1.setDrawDeck(StarterDeck.defaultDeckGandalf(player1));
        player2.setDrawDeck(StarterDeck.defaultDeckSaruman(player2));

        Character merry = player1.getDrawDeck().findFirstOf(StarterCharacters.Merry.class);
        Character boromirii = player1.getDrawDeck().findFirstOf(StarterCharacters.BoromirII.class);
        Character pippin = player2.getDrawDeck().findFirstOf(StarterCharacters.Pippin.class);
        Character legolas = player2.getDrawDeck().findFirstOf(StarterCharacters.Legolas.class);

        // Instantiate the initial character cards in Rivendell
        List<Character> characters1 = player1.getDrawDeck().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast)
                .limit(4).toList();
        characters1.forEach(Main::instantiateCardInRivendell);
        List<Character> characters2 = player2.getDrawDeck().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast)
                .limit(4).toList();
        characters2.forEach(Main::instantiateCardInRivendell);

        // Set up inital items
        player1.getDrawDeck().findFirstOf(ElvenCloak.class).playAsInitialItem(merry);
        player1.getDrawDeck().findFirstOf(ShieldOfIronBoundAsh.class).playAsInitialItem(boromirii);
        player2.getDrawDeck().findFirstOf(ElvenCloak.class).playAsInitialItem(pippin);
        player2.getDrawDeck().findFirstOf(StarterItems.DaggerOfWesternesse.class).playAsInitialItem(legolas);

        // Both players draw
        player1.standardizeHand();
        player2.standardizeHand();
    }

    private static void startGame(Player player1) {
        untapPhase(player1);
        organizationPhase(player1);
        movementPhase(player1);
        hazardPhase(player1);
        longEventPhase(player1);
    }

    private static void untapPhase(Player player) {
        positionGraph.locations.stream()
                .flatMap(loc -> loc.getChildren().stream())
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                .flatMap(fell -> fell.getChildren().stream())
                .forEach((Card card) -> {
                    switch (card) {
                        case Character character -> {
                            if (character.isTapped()) {
                                character.untap();
                            } else if (character.isWounded() && character.isInHaven()) {
                                character.heal();
                            }
                        }
                        case Item item -> {
                            if (item.isTapped()) {
                                item.untap();
                            }
                        }
                        // case Resource resource -> {
                        // if (resource.isTapped()) {
                        // resource.untap();
                        // }
                        // }
                        default -> {
                        }
                    }
                });
    }

    private static void organizationPhase(Player player1) {
        playCharacter(player1);
    }

    /**
     * INPROGRESS: Play characters from hand
     * @param player
     */
    private static void playCharacter(Player player) {
        List<Character> handCharacters = player.getFromHand(Character.class);

        List<Character> boardCharacters;

        BiFunction<Character, Location, List<Card>> canPlayCharacter = (character, location) -> location.getChildren()
                .stream()
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                .filter(fell -> ((Fellowship) fell).getCompanions()
                        + character.companionSize() <= Fellowship.MAX_COMPANIONS)
                .toList();
        
        Function<Character,Stream<Pair<Character,Card>>> playablePositions = (character) -> {
            Set<Card> playablePosition = new HashSet<>();
            Location loc = positionGraph.findLocation(character.getBirthplace());
            Set<Location> playableHavens = 
                character.getRace().equals(Character.Race.WIZARD)?
                positionGraph.havens : 
                Set.of(positionGraph.rivendell);
            playablePosition.addAll(playableHavens);
            playablePosition.add(loc);
            playablePosition.addAll(canPlayCharacter.apply(character, loc));
            playablePosition.addAll(playableHavens.stream()
                    .flatMap(haven -> canPlayCharacter.apply(character, haven).stream())
                    .toList());
            return playablePosition.stream()
                    .map(position -> new Pair<Character,Card>(character, position));
        };

        // Play characters with general influence
        List<Pair<Character, Card>> playableCharacters = handCharacters.stream()
                .filter(character -> player.getGeneralInfluence() >= character.getMind())
                .flatMap(playablePositions)
                .toList();

        // Play characters with direct influence
        playableCharacters.addAll(handCharacters.stream()
                .flatMap(handCharacter -> positionGraph.locations.stream()
                        .filter(loc -> loc.getPlace().equals(Location.PlaceType.HAVEN)
                                || loc.getClass().equals(handCharacter.getBirthplace()))
                        .flatMap(loc -> loc.getChildren().stream())
                        .filter(Fellowship.class::isInstance)
                        .filter(fell -> fell.getPlayer().equals(player))
                        .flatMap(fell -> fell.getChildren().stream())
                        .filter(Character.class::isInstance)
                        .map(Character.class::cast)
                        .filter(mapCharacter -> handCharacter.getMind() <= mapCharacter.getInfluence())
                        .map(mapCharacter -> new Pair<Character, Card>(handCharacter, mapCharacter)))
                .toList());

        // TODO: Condition wizards to be played in Rivendell or their birthplaceç
        handCharacters.stream()
                .filter(character -> character.getRace().equals(Character.Race.WIZARD))

                ;

        // copilot
        Character character = player.getHand().findFirstOf(Character.class);
        if (character != null) {
            if (character.getRace() == Character.Race.WIZARD) {
                if (character.getBirthplace().equals(Locations.Rivendell.class)
                        || character.getBirthplace().equals(character.getBirthplace())) {
                    character.addCharacterToLocation(character.getBirthplace());
                    player.getHand().remove(character);
                    Logger.info("Wizard " + character.getClass().getSimpleName() + " played in "
                            + character.getBirthplace().getSimpleName());
                } else {
                    Logger.warn("Wizard can only be played in their birthplace or Rivendell");
                }
            } else if (player.getGeneralInfluence() >= character.getInfluence()
                    || hasDirectInfluence(player, character)) {
                character.addCharacterToLocation(character.getBirthplace());
                player.getHand().remove(character);
                Logger.info("Character " + character.getClass().getSimpleName() + " played in "
                        + character.getBirthplace().getSimpleName());
            } else {
                Logger.warn("Not enough influence to play " + character.getClass().getSimpleName());
            }
        }
    }

    private static boolean hasDirectInfluence(Player player, Character character) {
        // Implement logic to check if any character controlled by the player has enough
        // direct influence
        return false;
    }

    private static void movementPhase(Player player) {
        // Implement movement phase logic
    }

    private static void hazardPhase(Player player) {
        // Implement hazard phase logic
    }

    private static void longEventPhase(Player player) {
        // Implement long event phase logic
    }
}