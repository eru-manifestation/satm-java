package com.erumf;

import com.erumf.utils.GameProperty;

public class Player {
    private final GameProperty<Integer> generalInfluence;
    private final GameProperty<Integer> hand;
    private final GameProperty<Integer> mp;

    public Player() {
        this.generalInfluence = new GameProperty<>("generalInfluence", 20, this);
        this.hand = new GameProperty<>("hand", 0, this);
        this.mp = new GameProperty<>("mp", 0, this);
    }

    public int getGeneralInfluence() {
        return generalInfluence.getValue();
    }

    public void setGeneralInfluence(int generalInfluence) {
        this.generalInfluence.setValue(generalInfluence);
    }

    public int getHand() {
        return hand.getValue();
    }

    public void setHand(int hand) {
        this.hand.setValue(hand);
    }

    public int getMp() {
        return mp.getValue();
    }

    public void setMp(int mp) {
        this.mp.setValue(mp);
    }
}