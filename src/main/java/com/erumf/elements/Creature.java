package com.erumf.elements;

import java.util.Map;
import java.util.Set;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Location.PlaceType;
import com.erumf.utils.GameProperty;

public abstract class Creature extends Hazard {
    private final GameProperty<Set<PlaceType>> places;
    private final GameProperty<Map<RegionType, Integer>> regions;
    private final GameProperty<Set<String>> regionNames;
    private final GameProperty<Set<String>> locationNames;
    private final GameProperty<Integer> prowess;
    private final GameProperty<Integer> body;

    public Creature(Player player, Set<PlaceType> places, Map<RegionType, Integer> regions, Set<String> regionNames, Set<String> locationNames, int prowess, int body, boolean unique) {
        super(player, Type.CREATURE, unique);
        this.places = new GameProperty<>("places", places, this);
        this.regions = new GameProperty<>("regions", regions, this);
        this.regionNames = new GameProperty<>("regionNames", regionNames, this);
        this.locationNames = new GameProperty<>("locationNames", locationNames, this);
        this.prowess = new GameProperty<>("prowess", prowess, this);
        this.body = new GameProperty<>("body", body, this);
    }

    public Set<PlaceType> getPlaces() {
        return places.getValue();
    }

    public Map<RegionType, Integer> getRegions() {
        return regions.getValue();
    }

    public Set<String> getRegionNames() {
        return regionNames.getValue();
    }

    public Set<String> getLocationNames() {
        return locationNames.getValue();
    }

    public int getProwess() {
        return Math.max(prowess.getValue(), 0);
    }

    public int getBody() {
        return Math.max(prowess.getValue(), 0);
    }

    public void setProwess(int prowess) {
        this.prowess.setValue(prowess);
    }

    public void setBody(int body) {
        this.body.setValue(body);
    }

    public void addPlace(PlaceType place) {
        places.getValue().add(place);
    }

    public void removePlace(PlaceType place) {
        places.getValue().remove(place);
    }

    public void addRegionName(String regionName) {
        regionNames.getValue().add(regionName);
    }

    public void removeRegionName(String regionName) {
        regionNames.getValue().remove(regionName);
    }

    public void addLocationName(String locationName) {
        locationNames.getValue().add(locationName);
    }

    public void removeLocationName(String locationName) {
        locationNames.getValue().remove(locationName);
    }

    public Set<PlaceType> getInitPlaces() {
        return places.getInitialValue();
    }

    public Map<RegionType, Integer> getInitRegions() {
        return regions.getInitialValue();
    }

    public Set<String> getInitRegionNames() {
        return regionNames.getInitialValue();
    }

    public Set<String> getInitLocationNames() {
        return locationNames.getInitialValue();
    }

    public int getInitProwess() {
        return prowess.getInitialValue();
    }

    public int getInitBody() {
        return body.getInitialValue();
    }

    public int getStrikes() {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Checks if the creature has resistance to a strike and if it has, makes a resistance
     * check. This does NOT discard nor remove the creature from the game.
     * 
     * @return true if the creature has resisted the check, false otherwise
     */
    public boolean resistanceCheck() {
        if (this.getInitBody() != 0) {
            // TODO pass this resistance check
        }else{
            // TODO return false
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Eliminates the creature from the game as if it had been defeated.
     * <p>It moves the creature from play to the enemy's MP deck.
     */
    public void eliminate() {
        this.getPlayer().getCardsInPlay().remove(this);
        Main.enemy(this.getPlayer()).getMpDeck().add(this);
    }
}
