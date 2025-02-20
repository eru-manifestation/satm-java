package com.erumf;

import org.jgrapht.Graph;

import com.erumf.elements.Location;
import com.erumf.events.GameListener;
import com.erumf.events.GameListener.EventType;
import com.erumf.utils.GameProperty;
import com.erumf.utils.graph.DefaultPathEdge;

public class Main {
    static Graph<Location, DefaultPathEdge> pathsGraph;

    public static void main(String[] args) {
        // pathsGraph = Locations2.generateDefaultLocations();

        // System.out.println("Graph of locations: " + pathsGraph.edgeSet().size() + " edges");

        // System.out.println("Hello world!");

        GameProperty<String> property = new GameProperty<>("hello", "world", null);
        GameProperty<String> property2 = new GameProperty<>("goodbye", "world", null);
        GameListener.create(EventType.IN,
            (p, v) -> p.getName().equals("hello"), 
            (p, v) -> {
                System.out.println("Hello " + v + "!");
                return true;
            }
        );
        System.out.println(property.getValue());

        property.setValue("WORLD");
        System.out.println(property.getValue());
        
    }

}