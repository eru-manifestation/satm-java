package com.erumf.elements;

import com.erumf.Basic;
import com.erumf.Player;

public abstract class Hazard extends Basic {
    public enum Type {
        CREATURE, LONG_EVENT, SHORT_EVENT, PERMANENT_EVENT
    }

    private final Type type;
    private final boolean unique;

    public Hazard(Player player, Type type, boolean unique) {
        super(player);
        this.type = type;
        this.unique = unique;
    }

    public Type getType() {
        return type;
    }

    public boolean isUnique() {
        return unique;
    }
}
