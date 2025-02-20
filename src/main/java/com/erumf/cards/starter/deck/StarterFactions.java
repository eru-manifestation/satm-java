package com.erumf.cards.starter.deck;

import java.util.Map;
import java.util.Set;

import com.erumf.Player;
import com.erumf.cards.locations.Locations.Bree;
import com.erumf.cards.locations.Locations.DunnishClanHold;
import com.erumf.cards.locations.Locations.Edoras;
import com.erumf.cards.locations.Locations.MinasTirith;
import com.erumf.cards.locations.Locations.ThranduilsHalls;
import com.erumf.cards.locations.Locations.Wellinghall;
import com.erumf.elements.Character.Race;
import com.erumf.elements.Faction;

public class StarterFactions {

    // FACCIONES DE GANDALF
    /**
     * G08 TW102 Facción Montaraces del Norte
     */
    public static class RangersOfTheNorth extends Faction {
        public RangersOfTheNorth(Player player) {
            super(player, 3, 0, 0, 0, 0, 0, FactionType.DUNEDAIN, Set.of(Bree.class), 9, Map.of(Race.DUNEDAIN, 1));
        }
    }

    /**
     * G43 TW103 Facción Jinetes de Rohan
     */
    public static class RidersOfRohan extends Faction {
        public RidersOfRohan(Player player) {
            super(player, 3, 0, 0, 0, 0, 0, FactionType.MAN, Set.of(Edoras.class), 9,
                    Map.of(Race.HOBBIT, 1, Race.DUNEDAIN, 1));
        }
    }

    /**
     * G53 TW106 Facción Torre de Guardia de Minas Tirith
     */
    public static class TowerGuardOfMinasTirith extends Faction {
        public TowerGuardOfMinasTirith(Player player) {
            super(player, 2, 0, 0, 0, 0, 0, FactionType.DUNEDAIN, Set.of(MinasTirith.class), 7,
                    Map.of(Race.DUNEDAIN, 1));
        }
    }

    // FACCIONES DE SARUMAN
    /**
     * S15 TW086 Facción Dundelinos
     */
    public static class Dunlendings extends Faction {
        public Dunlendings(Player player) {
            super(player, 2, 0, 0, 0, 0, 0, FactionType.MAN, Set.of(DunnishClanHold.class), 9,
                    Map.of(Race.MAN, -1, Race.DUNEDAIN, -1, Race.DWARF, -1));
        }
    }

    /**
     * S27 TW108 Facción Elfos del Bosque
     */
    public static class WoodElves extends Faction {
        public WoodElves(Player player) {
            super(player, 3, 0, 0, 0, 0, 0, FactionType.ELF, Set.of(ThranduilsHalls.class), 8,
                    Map.of(Race.MAN, -1, Race.ELF, 1, Race.DWARF, -2));
        }
    }

    /**
     * S53 TW089 Facción Ents de Fangorn
     */
    public static class EntsOfFangorn extends Faction {
        public EntsOfFangorn(Player player) {
            super(player, 3, 0, 0, 0, 0, 0, FactionType.ENT, Set.of(Wellinghall.class), 9, Map.of(Race.HOBBIT, 4));
        }
    }
}
