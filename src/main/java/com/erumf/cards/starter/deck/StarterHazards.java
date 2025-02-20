package com.erumf.cards.starter.deck;

import com.erumf.Player;
import com.erumf.elements.Hazard;

public class StarterHazards {
    
    // ADVERSIDADES DE GANDALF
    /**
     * G12 TW258 Adversidad Criatura Berto (Bûrat)
     */
    public static class BertBurat extends Hazard {
        public BertBurat(Player player) {
            super(player, Type.CREATURE, true);
        }
    }

    /**
     * G13 TW284 Adversidad Criatura Incursores Orcos
     * G42 TW284 Adversidad Criatura Incursores Orcos
     * G52 TW284 Adversidad Criatura Incursores Orcos
     */
    public static class OrcRaiders extends Hazard {
        public OrcRaiders(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G14 TW281 Adversidad Criatura Guardia de Orcos
     * G30 TW281 Adversidad Criatura Guardia de Orcos
     * G45 TW281 Adversidad Criatura Guardia de Orcos
     */
    public static class OrcGuard extends Hazard {
        public OrcGuard(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G15 TW286 Adversidad Criatura Guerreros Orcos
     * G34 TW286 Adversidad Criatura Guerreros Orcos
     * G54 TW286 Adversidad Criatura Guerreros Orcos
     */
    public static class OrcWarriors extends Hazard {
        public OrcWarriors(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G18 TW259 Adversidad Criatura Forajidos
     * G32 TW259 Adversidad Criatura Forajidos
     * G49 TW259 Adversidad Criatura Forajidos
     */
    public static class Brigands extends Hazard {
        public Brigands(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G28 TW302 Adversidad Criatura Guille (Wûluag)
     */
    public static class WilliamWuluag extends Hazard {
        public WilliamWuluag(Player player) {
            super(player, Type.CREATURE, true);
        }
    }

    /**
     * G47 TW287 Adversidad Criatura Centinelas Orcos
     * G57 TW287 Adversidad Criatura Centinelas Orcos
     * G60 TW287 Adversidad Criatura Centinelas Orcos
     */
    public static class OrcWatch extends Hazard {
        public OrcWatch(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G16 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * G37 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * G58 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S14 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S37 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S59 TW306 Adversidad de Suceso Perturbar a los Lacayos
     */
    public static class ArouseMinions extends Hazard {
        public ArouseMinions(Player player) {
            super(player, Type.SHORT_EVENT, false);
        }
    }

    /**
     * G19 TW346 Adversidad de Suceso Río
     * G48 TW346 Adversidad de Suceso Río
     * S41 TW346 Adversidad de Suceso Río
     * S48 TW346 Adversidad de Suceso Río
     */
    public static class River extends Hazard {
        public River(Player player) {
            super(player, Type.SHORT_EVENT, false);
        }
    }

    /**
     * G36 TW338 Adversidad de Suceso Los Sirvientes se Agitan
     * G46 TW338 Adversidad de Suceso Los Sirvientes se Agitan
     */
    public static class MinionsStir extends Hazard {
        public MinionsStir(Player player) {
            super(player, Type.LONG_EVENT, false);
        }
    }

    // ADVERSIDADES DE SARUMAN
    /**
     * S10 TW300 Adversidad Criatura Huargos
     * S12 TW300 Adversidad Criatura Huargos
     * S30 TW300 Adversidad Criatura Huargos
     */
    public static class Wargs extends Hazard {
        public Wargs(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S11 TW304 Adversidad Criatura Lobos
     * S26 TW304 Adversidad Criatura Lobos
     * S28 TW304 Adversidad Criatura Lobos
     */
    public static class Wolves extends Hazard {
        public Wolves(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S13 TW267 Adversidad Criatura Fantasmas
     * S50 TW267 Adversidad Criatura Fantasmas
     */
    public static class Ghosts extends Hazard {
        public Ghosts(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S20 TD095 Adversidad Criatura Arañas Menores
     * S31 TD095 Adversidad Criatura Arañas Menores
     * S46 TD095 Adversidad Criatura Arañas Menores
     */
    public static class LesserSpiders extends Hazard {
        public LesserSpiders(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S21 TW268 Adversidad Criatura Necrófagos
     * S57 TW268 Adversidad Criatura Necrófagos
     */
    public static class Ghouls extends Hazard {
        public Ghouls(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S24 TW273 Adversidad Criatura Ucorno
     * S38 TW273 Adversidad Criatura Ucorno
     */
    public static class Huorn extends Hazard {
        public Huorn(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S34 TW257 Adversidad Criatura Tumulario
     * S52 TW257 Adversidad Criatura Tumulario
     */
    public static class BarrowWights extends Hazard {
        public BarrowWights(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S29 TW361 Adversidad de Suceso Alba de Guerra
     * S54 TW361 Adversidad de Suceso Alba de Guerra
     */
    public static class WakeOfWar extends Hazard {
        public WakeOfWar(Player player) {
            super(player, Type.LONG_EVENT, false);
        }
    }
}
