package com.erumf.elements;

import com.erumf.Player;

public class Ally extends Resource {
    public Ally(Player player, int mp, int corruption, int influence, int mind, int body, int prowess) {
        super(player, mp, corruption, influence, mind, body, prowess, Resource.Type.ALLY, true);
    }
    
}
