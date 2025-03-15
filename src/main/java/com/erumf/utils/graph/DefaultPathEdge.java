package com.erumf.utils.graph;

import java.util.Map;

import com.erumf.elements.Region.RegionType;

public class DefaultPathEdge {
    private Map<RegionType,Integer> regionTypes;

    public DefaultPathEdge(Map<RegionType,Integer> regionTypes) {
        this.regionTypes = regionTypes;
    }

    public Map<RegionType,Integer> getRegionTypes() {
        return regionTypes;
    }

    public void setRegionTypes(Map<RegionType,Integer> regionTypes) {
        this.regionTypes = regionTypes;
    }
}
