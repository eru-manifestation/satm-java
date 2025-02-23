package com.erumf;

import com.erumf.utils.Deck;
import com.erumf.utils.GameProperty;

public class Player {
    private Deck drawDeck = null;
    private final Deck hand = new Deck();
    private final String name;
    private final GameProperty<Integer> generalInfluence;
    private final GameProperty<Integer> mp;

    public Player(String name) {
        this.name = name;
        this.generalInfluence = new GameProperty<>("generalInfluence", 20, this);
        this.mp = new GameProperty<>("mp", 0, this);
    }

    public Deck getDrawDeck() {
        return drawDeck;
    }

    public void setDrawDeck(Deck drawDeck) {
        this.drawDeck = drawDeck;
    }

    public Deck getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getGeneralInfluence() {
        return generalInfluence.getValue();
    }

    public void setGeneralInfluence(int generalInfluence) {
        this.generalInfluence.setValue(generalInfluence);
    }

    public int getMp() {
        return mp.getValue();
    }

    public void setMp(int mp) {
        this.mp.setValue(mp);
    }

    public void standardizeHand() {
        // Implementation for standardizing the player's hand
    }
}