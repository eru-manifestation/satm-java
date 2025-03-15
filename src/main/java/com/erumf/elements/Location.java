package com.erumf.elements;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.erumf.Main;
import com.erumf.elements.Item.ItemType;
import com.erumf.elements.Region.RegionType;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Fellowship;

public abstract class Location extends Card {

    // Intrinsic properties
    private final Location closestHaven;
    private final int playerDraw;
    private final int enemyDraw;
    private final Map<RegionType, Integer> route;
    private final PlaceType place;
    private final List<String> automaticAttacks;
    private final Set<ItemType> playableItems;

    public List<Location> getDestinations() {
        return Main.pathsGraph.outgoingEdgesOf(this).stream()
                .map(Main.pathsGraph::getEdgeTarget)
                .toList();
    }

    public enum PlaceType {
        FREE_HOLD, BORDER_HOLD, RUINS, SHADOW_HOLD, DARK_HOLD, HAVEN
    }

    public Location(int playerDraw, int enemyDraw, Map<RegionType, Integer> route, PlaceType place, List<String> automaticAttacks, Set<ItemType> playableItems) {
        super(null, true);
        this.closestHaven = null;
        this.playerDraw = playerDraw;
        this.enemyDraw = enemyDraw;
        this.route = Map.copyOf(route);
        this.place = place;
        this.automaticAttacks = List.copyOf(automaticAttacks);
        this.playableItems = Set.copyOf(playableItems);
    }

    public Location getClosestHaven() {
        return closestHaven;
    }

    public int getPlayerDraw() {
        return playerDraw;
    }

    public int getEnemyDraw() {
        return enemyDraw;
    }

    public Map<RegionType, Integer> getRoute() {
        return route;
    }

    public PlaceType getPlace() {
        return place;
    }

    public List<String> getAutomaticAttacks() {
        return automaticAttacks;
    }

    public Set<ItemType> getPlayableItems() {
        return playableItems;
    }

    public List<Fellowship> getFellowships() {
        return this.getChildren().stream()
                .filter(Fellowship.class::isInstance)
                .map(Fellowship.class::cast)
                .toList();
    }

    public void addFellowship(Fellowship fellowship) {
        this.addChild(fellowship);
    }

    @Override
    public String toString() {
        return "Location: " + this.getClass().getSimpleName() + "\n" +
               "Closest Haven: " + (closestHaven != null ? closestHaven.getClass().getSimpleName() : "None") + "\n" +
               "Player Draw: " + playerDraw + "\n" +
               "Enemy Draw: " + enemyDraw + "\n" +
               "Route: " + route + "\n" +
               "Place: " + place + "\n" +
               "Automatic Attacks: " + automaticAttacks + "\n" +
               "Playable Items: " + playableItems + "\n";
    }
}
