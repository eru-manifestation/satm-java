package com.erumf.elements;

import com.erumf.Player;
import com.erumf.utils.position.Card;

public abstract class Hazard extends Card {
    public enum Type {
        CREATURE, LONG_EVENT, SHORT_EVENT, PERMANENT_EVENT
    }

    private final Type type;

    public Hazard(Player player, Type type, boolean unique) {
        super(player, unique);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
