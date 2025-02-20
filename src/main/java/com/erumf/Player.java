package com.erumf;

public class Player {
    public int generalInfluence = 20;
    public int hand = 0;
    public int mp = 0;

    public Player() {
    }

    public int getGeneralInfluence() {
        return generalInfluence;
    }

    public void setGeneralInfluence(int generalInfluence) {
        this.generalInfluence = generalInfluence;
    }

    public int getHand() {
        return hand;
    }

    public void setHand(int hand) {
        this.hand = hand;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}