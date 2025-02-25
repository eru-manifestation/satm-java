package com.erumf.phases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jgrapht.alg.util.Pair;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.cards.locations.Locations;
import com.erumf.elements.Fellowship;
import com.erumf.elements.Character;
import com.erumf.elements.Location;
import com.erumf.utils.log.Logger;
import com.erumf.utils.position.Card;

public class OrganizationPhase {
    public static void organizationPhase(Player player1) {
        playCharacter(player1);
    }

    /**
     * INPROGRESS: Play characters from hand
     * 
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

        Function<Character, Stream<Pair<Character, Card>>> playablePositions = (character) -> {
            Set<Card> playablePosition = new HashSet<>();
            Location loc = Main.positionGraph.findLocation(character.getBirthplace());
            Set<Location> playableHavens = character.getRace().equals(Character.Race.WIZARD) ? positionGraph.havens
                    : Set.of(Main.positionGraph.rivendell);
            playablePosition.addAll(playableHavens);
            playablePosition.add(loc);
            playablePosition.addAll(canPlayCharacter.apply(character, loc));
            playablePosition.addAll(playableHavens.stream()
                    .flatMap(haven -> canPlayCharacter.apply(character, haven).stream())
                    .toList());
            return playablePosition.stream()
                    .map(position -> new Pair<Character, Card>(character, position));
        };

        // Play characters with general influence
        List<Pair<Character, Card>> playableCharacters = handCharacters.stream()
                .filter(character -> player.getGeneralInfluence() >= character.getMind())
                .flatMap(playablePositions)
                .toList();

        // Play characters with direct influence
        playableCharacters.addAll(handCharacters.stream()
                .flatMap(handCharacter -> Main.positionGraph.locations.stream()
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
}
