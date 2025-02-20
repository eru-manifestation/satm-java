package com.erumf.cards.starter.deck;

import com.erumf.Player;
import com.erumf.elements.Item;

public class StarterItems {

    // OBJETOS GANDALF
    /**
     * G03 TW155 Objeto Escudo de Fresno y Hierro Forjado
     */
    public static class ShieldOfIronBoundAsh extends Item {
        public ShieldOfIronBoundAsh(Player player) {
            super(player, 1, 0, 0, 1, 8, 0, ItemType.MINOR_ITEM);
        }
    }

    /**
     * G06 TW126 Objeto Capa Élfica
     * S06 TW126 Objeto Capa Élfica
     */
    public static class ElvenCloak extends Item {
        public ElvenCloak(Player player) {
            super(player, 1, 0, 0, 0, 0, 0, ItemType.MINOR_ITEM);
        }
    }

    /**
     * G21 TW154 Objeto Pergamino de Isildur
     */
    public static class ScrollOfIsildur extends Item {
        public ScrollOfIsildur(Player player) {
            super(player, 3, 4, 0, 0, 0, 0, ItemType.GREATER_ITEM);
        }
    }

    /**
     * G27 TW130 Objeto Gran Escudo de Rohan
     */
    public static class GreatShieldOfRohan extends Item {
        public GreatShieldOfRohan(Player player) {
            super(player, 2, 2, 0, 0, 2, 9, ItemType.MAJOR_ITEM);
        }
    }

    /**
     * G41 TW129 Objeto Glamdring
     */
    public static class Glamdring extends Item {
        public Glamdring(Player player) {
            super(player, 1, 2, 0, 0, 0, 8, ItemType.MAJOR_ITEM);
        }
    }

    // OBJETOS SARUMAN
    /**
     * S03 TW115 Objeto Daga de Oesternese
     */
    public static class DaggerOfWesternesse extends Item {
        public DaggerOfWesternesse(Player player) {
            super(player, 1, 0, 0, 0, 1, 8, ItemType.MINOR_ITEM);
        }
    }

    /**
     * S07 TW131 Objeto Jubón de Mallas Brillantes
     */
    public static class HauberkOfBrightMail extends Item {
        public HauberkOfBrightMail(Player player) {
            super(player, 1, 2, 0, 0, 0, 0, ItemType.MAJOR_ITEM);
        }
    }

    /**
     * S20 TW142 Objeto Orcrist
     */
    public static class Orcrist extends Item {
        public Orcrist(Player player) {
            super(player, 2, 4, 0, 0, 3, 9, ItemType.GREATER_ITEM);
        }
    }

    /**
     * S44 TW158 Objeto Espada de Gondolin
     */
    public static class SwordOfGondolin extends Item {
        public SwordOfGondolin(Player player) {
            super(player, 2, 4, 0, 0, 0, 0, ItemType.MAJOR_ITEM);
        }
    }
}
