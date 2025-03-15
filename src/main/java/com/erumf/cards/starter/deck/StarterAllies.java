package com.erumf.cards.starter.deck;

import com.erumf.Player;
import com.erumf.elements.Ally;

public class StarterAllies {
    // ALIADOS DE GANDALF
    /**
     * G31 TW077 Aliado Ramaviva
     */
    public static class Quickbeam extends Ally {
        public Quickbeam(Player player) {
            super(player, 2, 3, 9, 6);
        }
    }

    // ALIADOS DE SARUMAN
    /**
     * S33 TW074 Aliado Gollum
     */
    public static class Gollum extends Ally {
        public Gollum(Player player) {
            super(player, 2, 4, 9, 2);
        }
    }
}
