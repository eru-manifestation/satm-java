package com.erumf;

import java.util.List;

import org.jgrapht.Graph;

import com.erumf.cards.locations.Locations;
import com.erumf.cards.locations.Locations2;
import com.erumf.cards.starter.deck.StarterCharacters;
import com.erumf.cards.starter.deck.StarterDeck;
import com.erumf.cards.starter.deck.StarterItems;
import com.erumf.cards.starter.deck.StarterItems.ElvenCloak;
import com.erumf.cards.starter.deck.StarterItems.ShieldOfIronBoundAsh;
import com.erumf.elements.Character;
import com.erumf.elements.Location;
import com.erumf.phases.FinalPhase;
import com.erumf.phases.LongEventPhase;
import com.erumf.phases.MovementPhase;
import com.erumf.phases.OrganizationPhase;
import com.erumf.phases.SitePhase;
import com.erumf.phases.UntapPhase;
import com.erumf.utils.graph.DefaultPathEdge;
import com.erumf.utils.graph.PositionGraph;
import com.erumf.utils.log.Logger;
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
        player1.setDrawDeck(StarterDeck.defaultGandalfDeck(player1));
        player2.setDrawDeck(StarterDeck.defaultSarumanDeck(player2));

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
        UntapPhase.untapPhase(player1);
        OrganizationPhase.organizationPhase(player1);
        LongEventPhase.longEventPhase(player1);
        MovementPhase.movementPhase(player1);
        SitePhase.sitePhase(player1);
        FinalPhase.finalPhase(player1);
    }

    public static Player enemy(Player player) {
        if (player.equals(player1)) {
            return player2;
        } else if (player.equals(player2)) {
            return player1;
        } else {
            throw new IllegalArgumentException("Invalid player");
        }
    }
}