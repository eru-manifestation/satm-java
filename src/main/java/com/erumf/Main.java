package com.erumf;

import java.util.List;

import org.jgrapht.Graph;

import com.erumf.cards.locations.Locations2;
import com.erumf.cards.starter.deck.StarterDeck;
import com.erumf.elements.Location;
import com.erumf.log.Logger;
import com.erumf.utils.graph.DefaultPathEdge;

public class Main {
    static Graph<Location, DefaultPathEdge> pathsGraph = Locations2.generateDefaultLocations();
    public static Player player1 = new Player();
    public static Player player2 = new Player();

    public static void main(String[] args) {

        Logger.info("Starting game...");
        List<Basic> deck1 = StarterDeck.defaultDeck1(player1);
        List<Basic> deck2 = StarterDeck.defaultDeck2(player2);

        Logger.info("Deck 1: " + deck1.size());
        Logger.info("Deck 2: " + deck2.size());

        // GameProperty<String> property = new GameProperty<>("hello", "world", null);
        // GameProperty<String> property2 = new GameProperty<>("goodbye", "world", null);
        // GameListener.create(EventType.IN,
        //     (p, v) -> p.getName().equals("hello"), 
        //     (p, v) -> {
        //         System.out.println("Hello " + v + "!");
        //         return true;
        //     }
        // );
        // System.out.println(property.getValue());

        // property.setValue("WORLD");
        // System.out.println(property.getValue());
        
    }

}