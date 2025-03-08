package com.erumf.elements;

import java.util.Map;
import java.util.Set;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Location.PlaceType;
import com.erumf.utils.GameProperty;

public abstract class Creature extends Hazard {
    private final Set<PlaceType> places;
    private final Map<RegionType, Integer> regions;
    private final Set<String> regionNames;
    private final Set<String> locationNames;
    private final GameProperty<Integer> prowess;
    private final GameProperty<Integer> body;

    private final Set<PlaceType> _places;
    private final Map<RegionType, Integer> _regions;
    private final Set<String> _regionNames;
    private final Set<String> _locationNames;
    private final int _prowess;
    private final int _body;

    public Creature(Player player, Set<PlaceType> places, Map<RegionType, Integer> regions, Set<String> regionNames, Set<String> locationNames, int prowess, int body, boolean unique) {
        super(player, Type.CREATURE, unique);
        this.places = places;
        this.regions = regions;
        this.regionNames = regionNames;
        this.locationNames = locationNames;
        this.prowess = new GameProperty<>("prowess", prowess, this);
        this.body = new GameProperty<>("body", body, this);

        this._places = places;
        this._regions = regions;
        this._regionNames = regionNames;
        this._locationNames = locationNames;
        this._prowess = prowess;
        this._body = body;
    }

    public Set<PlaceType> getPlaces() {
        return places;
    }

    public Map<RegionType, Integer> getRegions() {
        return regions;
    }

    public Set<String> getRegionNames() {
        return regionNames;
    }

    public Set<String> getLocationNames() {
        return locationNames;
    }

    public int getProwess() {
        return prowess.getValue() < 0 ? 0 : prowess.getValue();
    }

    public int getBody() {
        return body.getValue() < 0 ? 0 : body.getValue();
    }

    public void setProwess(int prowess) {
        this.prowess.setValue(prowess);
    }

    public void setBody(int body) {
        this.body.setValue(body);
    }

    public void addPlace(PlaceType place) {
        places.add(place);
    }

    public void removePlace(PlaceType place) {
        places.remove(place);
    }

    public void addRegionName(String regionName) {
        regionNames.add(regionName);
    }

    public void removeRegionName(String regionName) {
        regionNames.remove(regionName);
    }

    public void addLocationName(String locationName) {
        locationNames.add(locationName);
    }

    public void removeLocationName(String locationName) {
        locationNames.remove(locationName);
    }

    public Set<PlaceType> getInitPlaces() {
        return _places;
    }

    public Map<RegionType, Integer> getInitRegions() {
        return _regions;
    }

    public Set<String> getInitRegionNames() {
        return _regionNames;
    }

    public Set<String> getInitLocationNames() {
        return _locationNames;
    }

    public int getInitProwess() {
        return _prowess < 0 ? 0 : _prowess;
    }

    public int getInitBody() {
        return _body < 0 ? 0 : _body;
    }

    public void addInitPlace(PlaceType place) {
        _places.add(place);
    }

    public void removeInitPlace(PlaceType place) {
        _places.remove(place);
    }

    public void addInitRegionName(String regionName) {
        _regionNames.add(regionName);
    }

    public void removeInitRegionName(String regionName) {
        _regionNames.remove(regionName);
    }

    public void addInitLocationName(String locationName) {
        _locationNames.add(locationName);
    }

    public void removeInitLocationName(String locationName) {
        _locationNames.remove(locationName);
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
