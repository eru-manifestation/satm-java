package com.erumf.elements;

import com.erumf.Player;
import com.erumf.elements.Character.Race;

import java.util.Map;
import java.util.Set;

public abstract class Faction extends Resource {
    public enum FactionType {
        DUNEDAIN, ELF, DWARF, HOBBIT, MAN, SPECIAL, ENT, EAGLE, WOSE
    }

    private final FactionType factionType;
    private final Set<Location> playablePlaces;
    private final int influenceCheck;
    private final Map<Race, Integer> influenceModifier;

    public Faction(Player player, int mp, int corruption, int influence, int mind, int body, int prowess, Type type, FactionType factionType, Set<Location> playablePlaces, int influenceCheck, Map<Race, Integer> influenceModifier) {
        super(player, mp, corruption, influence, mind, body, prowess, type);
        this.factionType = factionType;
        this.playablePlaces = playablePlaces;
        this.influenceCheck = influenceCheck;
        this.influenceModifier = influenceModifier;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public Set<Location> getPlayablePlaces() {
        return playablePlaces;
    }

    public int getInfluenceCheck() {
        return influenceCheck;
    }

    public Map<Race, Integer> getInfluenceModifier() {
        return influenceModifier;
    }
}
