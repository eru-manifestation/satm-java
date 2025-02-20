package com.erumf.cards.starter.deck;

import java.util.Set;

import com.erumf.Player;
import com.erumf.cards.locations.Locations;
import com.erumf.elements.Character;

public class StarterCharacters {

    // PERSONAJES GANDALF
    /**
     * G01 TW009 Personaje Aragorn II
     */
    public static class AragornII extends Character {
        public AragornII(Player player) {
            super(player, Race.DUNEDAIN, Locations.Bree.class, 3, 9,
                    Set.of(Skills.WARRIOR, Skills.SCOUT, Skills.RANGER), 0, 9, 6);
        }
    }

    /**
     * G02 TW023 Personaje Boromir II
     */
    public static class BoromirII extends Character {
        public BoromirII(Player player) {
            super(player, Race.DUNEDAIN, Locations.MinasTirith.class, 1, 4, Set.of(Skills.WARRIOR), 1, 7, 6);
        }
    }

    /**
     * G04 TW054 Personaje Kili
     */
    public static class Kili extends Character {
        public Kili(Player player) {
            super(player, Race.DWARF, Locations.BlueMountainDwarfHold.class, 0, 3, Set.of(Skills.WARRIOR, Skills.SCOUT),
                    1, 8, 3);
        }
    }

    /**
     * G05 TW057 Personaje Merry
     */
    public static class Merry extends Character {
        public Merry(Player player) {
            super(player, Race.HOBBIT, Locations.BagEnd.class, 1, 4, Set.of(Skills.SCOUT), -2, 9, 1);
        }
    }

    /**
     * G17 TW016 Personaje Beregond
     */
    public static class Beregond extends Character {
        public Beregond(Player player) {
            super(player, Race.DUNEDAIN, Locations.MinasTirith.class, 0, 2, Set.of(Skills.WARRIOR), 1, 8, 4);
        }
    }

    /**
     * G22 TW037 Personaje Faramir
     */
    public static class Faramir extends Character {
        public Faramir(Player player) {
            super(player, Race.DUNEDAIN, Locations.HennethAnnun.class, 1, 5, Set.of(Skills.WARRIOR, Skills.RANGER), 0,
                    8, 5);
        }
    }

    /**
     * G25 TW034 Personaje Éomer
     */
    public static class Eomer extends Character {
        public Eomer(Player player) {
            super(player, Race.MAN, Locations.Edoras.class, 0, 3, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 3);
        }
    }

    /**
     * G26 TW002 Personaje Gandalf
     * G38 TW002 Personaje Gandalf
     */
    public static class Gandalf extends Character {
        public Gandalf(Player player) {
            super(player, Race.WIZARD, Locations.Rivendell.class, 10, 0,
                    Set.of(Skills.WARRIOR, Skills.SCOUT, Skills.SAGE, Skills.DIPLOMAT), -1, 9, 6);
        }
    }

    /**
     * G44 TW036 Personaje Erkenbrand
     */
    public static class Erkenbrand extends Character {
        public Erkenbrand(Player player) {
            super(player, Race.MAN, Locations.Edoras.class, 2, 4, Set.of(Skills.WARRIOR), 0, 6, 5);
        }
    }

    // PERSONAJES SARUMAN
    /**
     * S01 TW046 Personaje Gimli
     */
    public static class Gimli extends Character {
        public Gimli(Player player) {
            super(player, Race.DWARF, Locations.IronHillDwarfHold.class, 2, 6, Set.of(Skills.WARRIOR, Skills.DIPLOMAT),
                    0, 8, 5);
        }
    }

    /**
     * S02 TW055 Personaje Legolas
     */
    public static class Legolas extends Character {
        public Legolas(Player player) {
            super(player, Race.ELF, Locations.ThranduilsHalls.class, 2, 6, Set.of(Skills.WARRIOR, Skills.DIPLOMAT), 0,
                    8, 5);
        }
    }

    /**
     * S04 TW031 Personaje Elladan
     */
    public static class Elladan extends Character {
        public Elladan(Player player) {
            super(player, Race.ELF, Locations.Rivendell.class, 0, 4, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 5);
        }
    }

    /**
     * S05 TW063 Personaje Pippin
     */
    public static class Pippin extends Character {
        public Pippin(Player player) {
            super(player, Race.HOBBIT, Locations.BagEnd.class, 1, 4, Set.of(Skills.SCOUT), -2, 9, 1);
        }
    }

    /**
     * S19 TW005 Personaje Saruman
     * S32 TW005 Personaje Saruman
     */
    public static class Saruman extends Character {
        public Saruman(Player player) {
            super(player, Race.WIZARD, Locations.Isengard.class, 10, 0,
                    Set.of(Skills.SCOUT, Skills.RANGER, Skills.SAGE, Skills.DIPLOMAT), 0, 9, 6);
        }
    }

    /**
     * S23 TW008 Personaje Annalena
     */
    public static class Annalena extends Character {
        public Annalena(Player player) {
            super(player, Race.ELF, Locations.Edhellond.class, 0, 3, Set.of(Skills.SCOUT, Skills.SAGE), 0, 8, 3);
        }
    }

    /**
     * S36 TW013 Personaje Bardo el Arquero
     */
    public static class BardBowman extends Character {
        public BardBowman(Player player) {
            super(player, Race.MAN, Locations.LakeTown.class, 0, 2, Set.of(Skills.SCOUT), 0, 6, 3);
        }
    }

    /**
     * S42 TW024 Personaje Celeborn
     */
    public static class Celeborn extends Character {
        public Celeborn(Player player) {
            super(player, Race.ELF, Locations.Lorien.class, 1, 6, Set.of(Skills.WARRIOR, Skills.SAGE), 0, 9, 6);
        }
    }

    /**
     * S51 TW032 Personaje Elrohir
     */
    public static class Elrohir extends Character {
        public Elrohir(Player player) {
            super(player, Race.ELF, Locations.Rivendell.class, 0, 4, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 5);
        }
    }
}