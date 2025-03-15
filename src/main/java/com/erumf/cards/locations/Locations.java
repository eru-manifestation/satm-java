package com.erumf.cards.locations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.erumf.elements.Haven;
import com.erumf.elements.Item.ItemType;
import com.erumf.elements.Location;
import com.erumf.elements.Region.RegionType;

public class Locations {

    public static class Rivendell extends Haven {
        public Rivendell() {
            super(Map.of(RegionType.WILDERNESS, 3, RegionType.BORDER_LAND, 1), 
                Map.of(RegionType.WILDERNESS, 2, RegionType.FREE_LAND, 1));
        }
    }

    public static class Lorien extends Haven {
        public Lorien() {
            super(Map.of(RegionType.WILDERNESS, 3, RegionType.BORDER_LAND, 1), 
                Map.of(RegionType.WILDERNESS, 2, RegionType.FREE_LAND, 2, RegionType.BORDER_LAND,2));
        }
    }

    public static class Edhellond extends Haven {
        public Edhellond() {
            super(Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 3, RegionType.FREE_LAND, 1), 
                Map.of(RegionType.WILDERNESS, 2, RegionType.FREE_LAND, 2, RegionType.BORDER_LAND,2));
        }
    }
    
    public static class GreyHavens extends Haven {
        public GreyHavens() {
            super(Map.of(RegionType.WILDERNESS,2,RegionType.FREE_LAND, 1), 
                Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 3, RegionType.FREE_LAND, 1));
        }
    }

    public static class BarrowDowns extends Location {
        public BarrowDowns() {
            super(1, 2, Map.of(RegionType.WILDERNESS, 2), PlaceType.RUINS,
                    List.of("Undead — 1 strike with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class DunnishClanHold extends Location {
        public DunnishClanHold() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 3), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class Bree extends Location {
        public Bree() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 2), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class GoblinGate extends Location {
        public GoblinGate() {
            super(1, 2, Map.of(RegionType.WILDERNESS, 2), PlaceType.SHADOW_HOLD,
                    List.of("Orcs — 3 strikes with 6 prowess"), Set.of(ItemType.MINOR_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class Isengard extends Location {
        public Isengard() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 2), PlaceType.RUINS,
                    List.of("Wolves — 3 strikes with 7 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class Wellinghall extends Location {
        public Wellinghall() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 2), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class Edoras extends Location {
        public Edoras() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.FREE_HOLD,
                    List.of(), Set.of());
        }
    }

    public static class MinasTirith extends Location {
        public MinasTirith() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1, RegionType.FREE_LAND, 1),
                    PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class DeadMarshes extends Location {
        public DeadMarshes() {
            super(2, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 2), PlaceType.SHADOW_HOLD,
                    List.of("Undead — 2 strikes with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class ThranduilsHalls extends Location {
        public ThranduilsHalls() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 2), PlaceType.FREE_HOLD,
                    List.of(), Set.of());
        }
    }

    public static class MountGundabad extends Location {
        public MountGundabad() {
            super(2, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1, RegionType.DARK_LAND, 1),
                    PlaceType.SHADOW_HOLD, List.of("Orcs — 2 strikes with 8 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class Moria extends Location {
        public Moria() {
            super(2, 3, Map.of(RegionType.WILDERNESS, 2), PlaceType.SHADOW_HOLD,
                    List.of("Orcs — 4 strikes with 7 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class DimrillDale extends Location {
        public DimrillDale() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 1 strike with 6 prowess"), Set.of(ItemType.INFORMATION));
        }
    }

    public static class DolAmroth extends Location {
        public DolAmroth() {
            super(1, 1, Map.of(RegionType.COAST, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class DancingSpire extends Location {
        public DancingSpire() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Dragon — 2 strikes with 11 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class CavesOfUlund extends Location {
        public CavesOfUlund() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Dragon — 1 strike with 13 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class CirithUngol extends Location {
        public CirithUngol() {
            super(3, 4, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 4 strikes with 7 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class CarnDum extends Location {
        public CarnDum() {
            super(2, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 4 strikes with 7 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class DolGuldur extends Location {
        public DolGuldur() {
            super(2, 4, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 3 strikes with 7 prowess", "Trolls — 2 strikes with 8 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class BaradDur extends Location {
        public BaradDur() {
            super(3, 6, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 4 strikes with 7 prowess", "Trolls — 3 strikes with 9 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class BagEnd extends Location {
        public BagEnd() {
            super(2, 2, Map.of(RegionType.FREE_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class BeornsHouse extends Location {
        public BeornsHouse() {
            super(1, 1, Map.of(RegionType.FREE_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class BlueMountainDwarfHold extends Location {
        public BlueMountainDwarfHold() {
            super(1, 1, Map.of(RegionType.FREE_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class EasterlingCamp extends Location {
        public EasterlingCamp() {
            super(4, 4, Map.of(RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class Ettenmoors extends Location {
        public Ettenmoors() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1), PlaceType.RUINS,
                    List.of("Trolls — 1 strike with 9 prowess"), Set.of(ItemType.MINOR_ITEM));
        }
    }

    public static class GlitteringCaves extends Location {
        public GlitteringCaves() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1), PlaceType.RUINS,
                    List.of("Pûkel-creature — 1 strike with 9 prowess"), Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class GladdenFields extends Location {
        public GladdenFields() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1), PlaceType.RUINS,
                    List.of("Undead — 1 strike with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.GOLD_RING_ITEM));
        }
    }

    public static class CamethBrin extends Location {
        public CamethBrin() {
            super(1, 1, Map.of(RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class AmonHen extends Location {
        public AmonHen() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1), PlaceType.RUINS,
                    List.of("Undead — 1 strike with 6 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.INFORMATION, ItemType.MINOR_ITEM));
        }
    }

    public static class BanditLair extends Location {
        public BanditLair() {
            super(1, 2, Map.of(RegionType.WILDERNESS, 1), PlaceType.RUINS,
                    List.of("Men — 3 strikes with 6 prowess"), Set.of(ItemType.MINOR_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    
    public static class Dunharrow extends Location {
        public Dunharrow() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class DruadanForest extends Location {
        public DruadanForest() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class EaglesEyrie extends Location {
        public EaglesEyrie() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class LossadanCairn extends Location {
        public LossadanCairn() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Undead — 2 strikes with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class LakeTown extends Location {
        public LakeTown() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class LondGalen extends Location {
        public LondGalen() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class IslesOfTheDeadThatLive extends Location {
        public IslesOfTheDeadThatLive() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Undead — 2 strikes with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class Irerock extends Location {
        public Irerock() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Dragon — 1 strike with 14 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class IronHillDwarfHold extends Location {
        public IronHillDwarfHold() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class HennethAnnun extends Location {
        public HennethAnnun() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class Himring extends Location {
        public Himring() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Undead — 1 strike with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class TheLonelyMountain extends Location {
        public TheLonelyMountain() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Dragon — 1 strike with 14 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class TheStones extends Location {
        public TheStones() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Pûkel-creature — 2 strikes with 9 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class SouthronOasis extends Location {
        public SouthronOasis() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class StoneCircle extends Location {
        public StoneCircle() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Pûkel-creature — 1 strike with 9 prowess"),
                    Set.of(ItemType.INFORMATION, ItemType.MINOR_ITEM));
        }
    }

    public static class ShelobsLair extends Location {
        public ShelobsLair() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.SHADOW_HOLD,
                    List.of("Orcs — 2 strikes with 8 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class ShrelKain extends Location {
        public ShrelKain() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class RuinedSignalTower extends Location {
        public RuinedSignalTower() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Spiders — 2 strikes with 8 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class SarnGoriwing extends Location {
        public SarnGoriwing() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.SHADOW_HOLD,
                    List.of("Orcs — 3 strikes with 5 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class Rhosgobel extends Location {
        public Rhosgobel() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class Pelargir extends Location {
        public Pelargir() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.FREE_HOLD, List.of(), Set.of());
        }
    }

    public static class OldForest extends Location {
        public OldForest() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class OstInEdhil extends Location {
        public OstInEdhil() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Wolves — 3 strikes with 5 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.GOLD_RING_ITEM));
        }
    }

    public static class MountGram extends Location {
        public MountGram() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Orcs — 3 strikes with 6 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class MountDoom extends Location {
        public MountDoom() {
            super(3, 3, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.SHADOW_HOLD, List.of(), Set.of());
        }
    }

    public static class MinasMorgul extends Location {
        public MinasMorgul() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.SHADOW_LAND, 1), PlaceType.SHADOW_HOLD,
                    List.of("Undead — 3 strikes with 8 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class LossadanCamp extends Location {
        public LossadanCamp() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class WosePassageHold extends Location {
        public WosePassageHold() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class TheWhiteTowers extends Location {
        public TheWhiteTowers() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Wolves — 2 strikes with 6 prowess"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

    public static class WoodmenTown extends Location {
        public WoodmenTown() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class VariagCamp extends Location {
        public VariagCamp() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class Weathertop extends Location {
        public Weathertop() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.BORDER_LAND, 1), PlaceType.RUINS,
                    List.of("Wolves — 2 strikes with 6 prowess"),
                    Set.of(ItemType.INFORMATION));
        }
    }

    public static class Tolfalas extends Location {
        public Tolfalas() {
            super(2, 2, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Undead — 3 strikes with 7 prowess; each character wounded must make a corruption check"),
                    Set.of(ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM, ItemType.GREATER_ITEM));
        }
    }

    public static class ValeOfErech extends Location {
        public ValeOfErech() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.BORDER_HOLD, List.of(), Set.of());
        }
    }

    public static class TheWindThrone extends Location {
        public TheWindThrone() {
            super(1, 1, Map.of(RegionType.WILDERNESS, 1, RegionType.COAST, 1), PlaceType.RUINS,
                    List.of("Orcs — 3 strikes with 7 prowess"),
                    Set.of(ItemType.INFORMATION, ItemType.MINOR_ITEM, ItemType.MAJOR_ITEM));
        }
    }

}
