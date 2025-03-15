package com.erumf.elements;

import com.erumf.Player;

public class Ally extends Resource {
    public Ally(Player player, int mp, int mind, int body, int prowess) {
        super(player, mp, 0, 0, mind, body, prowess, Resource.Type.ALLY, true);
    }
    
}
