package com.erumf.elements;

import java.util.Collections;
import java.util.Map;

import com.erumf.Player;

public abstract class Haven extends Location {

    // Intrinsic properties
    private final Location closestHaven2;
    private final Map<RegionType, Integer> route2;

    public Haven(Map<RegionType, Integer> route, Map<RegionType, Integer> route2) {
        super(2, 2, route, PlaceType.HAVEN, Collections.emptyList(), Collections.emptySet());
        this.closestHaven2 = null;
        this.route2 = Map.copyOf(route2);
    }

    public Location getClosestHaven2() {
        return closestHaven2;
    }

    public Map<RegionType, Integer> getRoute2() {
        return route2;
    }

    public void storeItem(Item item) {
        // TODO: Throw if item is The One Ring
        Player player = item.getPlayer();
        player.setMp(player.getMp() + item.getMp());
        player.getMpDeck().add(item);
    }
}
