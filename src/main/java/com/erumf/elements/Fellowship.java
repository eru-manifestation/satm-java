package com.erumf.elements;

import com.erumf.Player;
import com.erumf.utils.position.Card;

/**
 * The Fellowship class represents a group of character cards in the game.
 * The fellowship moves and faces threats together.
 */
public class Fellowship extends Card {
    public static final float MAX_COMPANIONS = 7f;
    private boolean empty = true;
    private float companions = 0.0f;

    public Fellowship(Player player) {
        super(player);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public float getCompanions() {
        return companions;
    }

    public void setCompanions(float companions) {
        this.companions = companions;
    }
}
