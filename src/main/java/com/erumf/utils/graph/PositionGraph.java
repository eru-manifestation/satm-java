package com.erumf.utils.graph;

import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import com.erumf.Main;
import com.erumf.cards.locations.Locations.Rivendell;
import com.erumf.elements.Haven;
import com.erumf.elements.Location;

public class PositionGraph extends SimpleDirectedGraph<Object, DefaultEdge> {

    private final String root;
    public final Set<Location> locations;
    public final Set<Haven> havens;
    public final Rivendell rivendell;

    private PositionGraph(Set<Location> locations) {
        super(org.jgrapht.graph.DefaultEdge.class);
        this.root="root";
        this.locations = locations;
        this.havens = locations.stream()
                .filter(Haven.class::isInstance)
                .map(Haven.class::cast)
                .collect(java.util.stream.Collectors.toSet());
        this.rivendell = this.havens.stream()
                .filter(Rivendell.class::isInstance)
                .map(Rivendell.class::cast)
                .findAny()
                .orElse(null);
    }

    public static PositionGraph generatePositionGraph(Graph<Location, DefaultPathEdge> pathsGraph) {
        PositionGraph positionGraph = new PositionGraph(pathsGraph.vertexSet());
        String root = positionGraph.getRoot();
        positionGraph.addVertex(root);
        pathsGraph.vertexSet().forEach(v->positionGraph.addVertex(v));
        pathsGraph.vertexSet().forEach(v->positionGraph.addEdge(root, v));
        return positionGraph;
    }

    public String getRoot() {
        return root;
    }

    public Location findLocation(Class<? extends Location> locationClass) {
        return locations.stream()
                .filter(location -> location.getClass().equals(locationClass))
                .findFirst()
                .orElse(null);
    }

    @Override
    public DefaultEdge addEdge(Object sourceVertex, Object targetVertex) {
        //TODO: Remove in future for better performance
        if(!this.vertexSet().contains(sourceVertex)) this.addVertex(sourceVertex);
        if(!this.vertexSet().contains(targetVertex)) this.addVertex(targetVertex);
        return super.addEdge(sourceVertex, targetVertex);
    }

    
    public void moveElement(Object target, Object newSuperior) {
        PositionGraph positionGraph = Main.positionGraph;
        DefaultEdge source = positionGraph.incomingEdgesOf(target).stream().findFirst().get();
        positionGraph.removeEdge(source);
        positionGraph.addEdge(newSuperior, target);
    }
}
