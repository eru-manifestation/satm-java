package com.erumf.cards.starter.deck;

import com.erumf.Player;
import com.erumf.elements.Resource;

public class StarterAllies {
    //TODO: Implementar todos los atributos de los aliados
    // ALIADOS DE GANDALF
    /**
     * G31 TW077 Aliado Ramaviva
     */
    public static class Quickbeam extends Resource {
        public Quickbeam(Player player) {
            super(player, 2, 0, 0, 0, 0, 0, Type.ALLY);
        }
    }

    // ALIADOS DE SARUMAN
    /**
     * S33 TW074 Aliado Gollum
     */
    public static class Gollum extends Resource {
        public Gollum(Player player) {
            super(player, 2, 0, 0, 0, 0, 0, Type.ALLY);
        }
    }
}
