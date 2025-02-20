package com.erumf.cards.starter.deck;

import com.erumf.Player;
import com.erumf.elements.Resource;

public class StarterEventResources {

    // RECURSOS DE GANDALF
    /**
     * G07 TW176 Recurso de Suceso Esquiva
     * G23 TW176 Recurso de Suceso Esquiva
     * G39 TW176 Recurso de Suceso Esquiva
     */
    public static class Dodge extends Resource {
        public Dodge(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G09 TW204 Recurso de Suceso Golpe Afortunado
     * G24 TW204 Recurso de Suceso Golpe Afortunado
     * G40 TW204 Recurso de Suceso Golpe Afortunado
     */
    public static class LuckyStrike extends Resource {
        public LuckyStrike(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G10 TW232 Recurso de Suceso Fiel Amistad
     * S45 TW232 Recurso de Suceso Fiel Amistad
     */
    public static class TemperingFriendship extends Resource {
        public TemperingFriendship(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G11 TW173 Recurso de Suceso Ocultamiento
     * G33 TW173 Recurso de Suceso Ocultamiento
     * S49 TW173 Recurso de Suceso Ocultamiento
     * S55 TW173 Recurso de Suceso Ocultamiento
     */
    public static class Concealment extends Resource {
        public Concealment(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G56 TW196 Recurso de Suceso Sigilo de los Medianos
     * S22 TW196 Recurso de Suceso Sigilo de los Medianos
     */
    public static class HalflingStealth extends Resource {
        public HalflingStealth(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G51 TW197 Recurso de Suceso Fuerza de los Medianos
     * G20 TW197 Recurso de Suceso Fuerza de los Medianos
     * S35 TW197 Recurso de Suceso Fuerza de los Medianos
     * S47 TW197 Recurso de Suceso Fuerza de los Medianos
     */
    public static class HalflingStrength extends Resource {
        public HalflingStrength(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G29 TW180 Recurso de Suceso Huida
     * G35 TW180 Recurso de Suceso Huida
     * S16 TW180 Recurso de Suceso Huida
     */
    public static class Escape extends Resource {
        public Escape(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G50 TW191 Recurso de Suceso Vado
     * S60 TW191 Recurso de Suceso Vado
     */
    public static class Ford extends Resource {
        public Ford(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G55 TW171 Recurso de Suceso Puente
     * S56 TW171 Recurso de Suceso Puente
     */
    public static class Bridge extends Resource {
        public Bridge(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * G59 TW210 Recurso de Suceso Acantonamiento
     * S58 TW210 Recurso de Suceso Acantonamiento
     */
    public static class Muster extends Resource {
        public Muster(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    // RECURSOS DE SARUMAN
    /**
     * S08 TW170 Recurso de Suceso Bloqueo
     * S17 TW170 Recurso de Suceso Bloqueo
     * S43 TW170 Recurso de Suceso Bloqueo
     */
    public static class Block extends Resource {
        public Block(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * S09 TW224 Recurso de Suceso Golpe Arriesgado
     * S25 TW224 Recurso de Suceso Golpe Arriesgado
     * S39 TW224 Recurso de Suceso Golpe Arriesgado
     */
    public static class RiskyBlow extends Resource {
        public RiskyBlow(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    /**
     * S18 TW175 Recurso de Suceso Discusiones Oscuras
     */
    public static class DarkQuarrels extends Resource {
        public DarkQuarrels(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }
}
