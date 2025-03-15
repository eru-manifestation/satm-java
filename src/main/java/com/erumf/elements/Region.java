package com.erumf.elements;

import java.util.Set;

import com.erumf.utils.position.Card;

public class Region extends Card{

    private final RegionName regionName;
    private final RegionType regionType;
    private final Set<Region> moveTo;

    // Constructor
    public Region(RegionName regionName, RegionType regionType, Set<Region> moveTo) {
        super(null, true);
        this.regionName = regionName;
        this.regionType = regionType;
        this.moveTo = Set.copyOf(moveTo);
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public Set<Region> getMoveTo() {
        return moveTo;
    }

    public RegionName getRegionName() {
        return regionName;
    }

    public enum RegionName {
        WOODLAND_REALM,
        WOLD_FOOTHILLS,
        ANDRAST,
        ANDRAST_COAST,
        BELFALAS,
        BROWN_LANDS,
        ARTHEDAIN,
        BAY_OF_BELFALAS,
        ANGMAR,
        ANORIEN,
        ANDUIN_VALES,
        ANFALAS,
        GUNDABAD,
        HARONDOR,
        GORGOROTH,
        GREY_MOUNTAIN_NARROWS,
        IMLAD_MORGUL,
        IRON_HILLS,
        HOLLIN,
        HORSE_PLAINS,
        HEART_OF_MIRKWOOD,
        HIGH_PASS,
        DAGORLAD,
        DORWINION,
        CARDOLAN,
        GAP_OF_ISEN,
        FANGORN,
        FOROCHEL,
        ENEDHWAITH,
        ERIADORAN_COAST,
        DUNLAND,
        ELVEN_SHORES,
        SOUTHERN_MIRKWOOD,
        SOUTHERN_RHOVANION,
        RHUDAUR,
        ROHAN,
        OLD_PUKEL_LAND,
        REDHORN_GATE,
        WESTERN_MIRKWOOD,
        WITHERED_HEATH,
        THE_SHIRE,
        UDUN,
        LEBENNIN,
        LINDON,
        KHAND,
        LAMEDON,
        ITHILIEN,
        OLD_PUKEL_GAP,
        NUMERIADOR,
        NURN,
        MOUTHS_OF_THE_ANDUIN,
        NORTHERN_RHOVANION
    }
}