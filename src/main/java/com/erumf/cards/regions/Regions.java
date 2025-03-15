package com.erumf.cards.regions;

import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import com.erumf.elements.Region;
import com.erumf.elements.Region.RegionName;
import com.erumf.elements.Region.RegionType;

public class Regions {
    public static Graph<Region, DefaultEdge> generateDefaultRegions() {
        Graph<Region, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Create regions
        Region woodlandRealm = new Region(RegionName.WOODLAND_REALM, RegionType.BORDER_LAND,
                Set.of(RegionName.ANDUIN_VALES, RegionName.HEART_OF_MIRKWOOD, RegionName.NORTHERN_RHOVANION,
                        RegionName.WESTERN_MIRKWOOD, RegionName.GREY_MOUNTAIN_NARROWS));
        Region woldFoothills = new Region(RegionName.WOLD_FOOTHILLS, RegionType.WILDERNESS,
                Set.of(RegionName.ANDUIN_VALES, RegionName.BROWN_LANDS, RegionName.FANGORN, RegionName.REDHORN_GATE, RegionName.ROHAN));
        Region andrast = new Region(RegionName.ANDRAST, RegionType.WILDERNESS, Set.of(RegionName.ANDRAST_COAST,
                RegionName.ANFALAS, RegionName.BAY_OF_BELFALAS, RegionName.ERIADORAN_COAST, RegionName.OLD_PUKEL_LAND));
        Region andrastCoast = new Region(RegionName.ANDRAST_COAST, RegionType.COAST,
                Set.of(RegionName.ANDRAST, RegionName.BAY_OF_BELFALAS, RegionName.ERIADORAN_COAST));
        Region belfalas = new Region(RegionName.BELFALAS, RegionType.FREE_LAND, Set.of(RegionName.MOUTHS_OF_THE_ANDUIN,
                RegionName.ANFALAS, RegionName.BAY_OF_BELFALAS, RegionName.LAMEDON, RegionName.LEBENNIN));
        Region brownLands = new Region(RegionName.BROWN_LANDS, RegionType.SHADOW_LAND, Set.of(RegionName.ANDUIN_VALES,
                RegionName.DAGORLAD, RegionName.SOUTHERN_MIRKWOOD, RegionName.WOLD_FOOTHILLS));
        Region arthedain = new Region(RegionName.ARTHEDAIN, RegionType.WILDERNESS,
                Set.of(RegionName.ANGMAR, RegionName.CARDOLAN, RegionName.FOROCHEL, RegionName.LINDON,
                        RegionName.NUMERIADOR, RegionName.RHUDAUR, RegionName.THE_SHIRE));
        Region bayOfBelfalas = new Region(RegionName.BAY_OF_BELFALAS, RegionType.COAST,
                Set.of(RegionName.ANDRAST_COAST, RegionName.ANDRAST, RegionName.MOUTHS_OF_THE_ANDUIN,
                        RegionName.ANFALAS, RegionName.BELFALAS));
        Region angmar = new Region(RegionName.ANGMAR, RegionType.SHADOW_LAND,
                Set.of(RegionName.ARTHEDAIN, RegionName.FOROCHEL, RegionName.GUNDABAD, RegionName.RHUDAUR));
        Region anorien = new Region(RegionName.ANORIEN, RegionType.FREE_LAND,
                Set.of(RegionName.ITHILIEN, RegionName.LEBENNIN, RegionName.ROHAN));
        Region anduinVales = new Region(RegionName.ANDUIN_VALES, RegionType.BORDER_LAND,
                Set.of(RegionName.BROWN_LANDS, RegionName.GREY_MOUNTAIN_NARROWS, RegionName.GUNDABAD,
                        RegionName.HIGH_PASS, RegionName.SOUTHERN_MIRKWOOD, RegionName.WESTERN_MIRKWOOD,
                        RegionName.WOLD_FOOTHILLS, RegionName.WOODLAND_REALM));
        Region anfalas = new Region(RegionName.ANFALAS, RegionType.WILDERNESS, Set.of(RegionName.ANDRAST,
                RegionName.BAY_OF_BELFALAS, RegionName.BELFALAS, RegionName.LAMEDON, RegionName.OLD_PUKEL_GAP));
        Region gundabad = new Region(RegionName.GUNDABAD, RegionType.DARK_LAND,
                Set.of(RegionName.ANDUIN_VALES, RegionName.ANGMAR));
        Region harondor = new Region(RegionName.HARONDOR, RegionType.WILDERNESS,
                Set.of(RegionName.MOUTHS_OF_THE_ANDUIN, RegionName.ITHILIEN, RegionName.KHAND));
        Region gorgoroth = new Region(RegionName.GORGOROTH, RegionType.DARK_LAND,
                Set.of(RegionName.IMLAD_MORGUL, RegionName.NURN, RegionName.UDUN));
        Region greyMountainNarrows = new Region(RegionName.GREY_MOUNTAIN_NARROWS, RegionType.SHADOW_LAND,
                Set.of(RegionName.ANDUIN_VALES, RegionName.NORTHERN_RHOVANION, RegionName.WITHERED_HEATH,
                        RegionName.WOODLAND_REALM));
        Region imladMorgul = new Region(RegionName.IMLAD_MORGUL, RegionType.SHADOW_LAND,
                Set.of(RegionName.GORGOROTH, RegionName.ITHILIEN));
        Region ironHills = new Region(RegionName.IRON_HILLS, RegionType.WILDERNESS,
                Set.of(RegionName.NORTHERN_RHOVANION, RegionName.WITHERED_HEATH));
        Region hollin = new Region(RegionName.HOLLIN, RegionType.WILDERNESS,
                Set.of(RegionName.CARDOLAN, RegionName.DUNLAND, RegionName.REDHORN_GATE, RegionName.RHUDAUR));
        Region horsePlains = new Region(RegionName.HORSE_PLAINS, RegionType.SHADOW_LAND,
                Set.of(RegionName.DAGORLAD, RegionName.NURN, RegionName.SOUTHERN_RHOVANION));
        Region heartOfMirkwood = new Region(RegionName.HEART_OF_MIRKWOOD, RegionType.WILDERNESS,
                Set.of(RegionName.NORTHERN_RHOVANION, RegionName.SOUTHERN_MIRKWOOD, RegionName.SOUTHERN_RHOVANION,
                        RegionName.WESTERN_MIRKWOOD, RegionName.WOODLAND_REALM));
        Region highPass = new Region(RegionName.HIGH_PASS, RegionType.WILDERNESS,
                Set.of(RegionName.ANDUIN_VALES, RegionName.RHUDAUR));
        Region dagorlad = new Region(RegionName.DAGORLAD, RegionType.SHADOW_LAND,
                Set.of(RegionName.BROWN_LANDS, RegionName.HORSE_PLAINS, RegionName.ITHILIEN,
                        RegionName.SOUTHERN_MIRKWOOD, RegionName.SOUTHERN_RHOVANION));
        Region dorwinion = new Region(RegionName.DORWINION, RegionType.BORDER_LAND,
                Set.of(RegionName.NORTHERN_RHOVANION, RegionName.SOUTHERN_RHOVANION));
        Region cardolan = new Region(RegionName.CARDOLAN, RegionType.WILDERNESS,
                Set.of(RegionName.ARTHEDAIN, RegionName.DUNLAND, RegionName.ENEDHWAITH, RegionName.ERIADORAN_COAST,
                        RegionName.HOLLIN, RegionName.RHUDAUR, RegionName.THE_SHIRE));
        Region gapOfIsen = new Region(RegionName.GAP_OF_ISEN, RegionType.BORDER_LAND,
                Set.of(RegionName.ENEDHWAITH, RegionName.FANGORN, RegionName.OLD_PUKEL_LAND, RegionName.ROHAN));
        Region fangorn = new Region(RegionName.FANGORN, RegionType.WILDERNESS,
                Set.of(RegionName.GAP_OF_ISEN, RegionName.ROHAN, RegionName.WOLD_FOOTHILLS));
        Region forochel = new Region(RegionName.FOROCHEL, RegionType.WILDERNESS,
                Set.of(RegionName.ANGMAR, RegionName.ARTHEDAIN, RegionName.NUMERIADOR));
        Region enedwaith = new Region(RegionName.ENEDHWAITH, RegionType.WILDERNESS, Set.of(RegionName.CARDOLAN,
                RegionName.DUNLAND, RegionName.ERIADORAN_COAST, RegionName.GAP_OF_ISEN, RegionName.OLD_PUKEL_LAND));
        Region eriadoranCoast = new Region(RegionName.ERIADORAN_COAST, RegionType.COAST,
                Set.of(RegionName.ANDRAST, RegionName.ANDRAST_COAST, RegionName.CARDOLAN, RegionName.ELVEN_SHORES,
                        RegionName.ENEDHWAITH, RegionName.OLD_PUKEL_LAND));
        Region dunland = new Region(RegionName.DUNLAND, RegionType.WILDERNESS,
                Set.of(RegionName.CARDOLAN, RegionName.ENEDHWAITH, RegionName.HOLLIN));
        Region elvenShores = new Region(RegionName.ELVEN_SHORES, RegionType.COAST,
                Set.of(RegionName.ERIADORAN_COAST, RegionName.LINDON));
        Region southernMirkwood = new Region(RegionName.SOUTHERN_MIRKWOOD, RegionType.DARK_LAND,
                Set.of(RegionName.ANDUIN_VALES, RegionName.BROWN_LANDS, RegionName.DAGORLAD,
                        RegionName.HEART_OF_MIRKWOOD, RegionName.SOUTHERN_RHOVANION, RegionName.WESTERN_MIRKWOOD));
        Region southernRhovanion = new Region(RegionName.SOUTHERN_RHOVANION, RegionType.WILDERNESS,
                Set.of(RegionName.DAGORLAD, RegionName.DORWINION, RegionName.HEART_OF_MIRKWOOD, RegionName.HORSE_PLAINS,
                        RegionName.NORTHERN_RHOVANION, RegionName.SOUTHERN_MIRKWOOD));
        Region rhudaur = new Region(RegionName.RHUDAUR, RegionType.WILDERNESS, Set.of(RegionName.ANGMAR,
                RegionName.ARTHEDAIN, RegionName.CARDOLAN, RegionName.HIGH_PASS, RegionName.HOLLIN));
        Region rohan = new Region(RegionName.ROHAN, RegionType.BORDER_LAND,
                Set.of(RegionName.ANORIEN, RegionName.FANGORN, RegionName.GAP_OF_ISEN, RegionName.WOLD_FOOTHILLS));
        Region oldPukelLand = new Region(RegionName.OLD_PUKEL_LAND, RegionType.WILDERNESS, Set.of(RegionName.ANDRAST,
                RegionName.ENEDHWAITH, RegionName.ERIADORAN_COAST, RegionName.GAP_OF_ISEN, RegionName.OLD_PUKEL_GAP));
        Region redhornGate = new Region(RegionName.REDHORN_GATE, RegionType.WILDERNESS,
                Set.of(RegionName.HOLLIN, RegionName.WOLD_FOOTHILLS));
        Region westernMirkwood = new Region(RegionName.WESTERN_MIRKWOOD, RegionType.WILDERNESS,
                Set.of(RegionName.ANDUIN_VALES, RegionName.HEART_OF_MIRKWOOD, RegionName.SOUTHERN_MIRKWOOD,
                        RegionName.WOODLAND_REALM));
        Region witheredHeath = new Region(RegionName.WITHERED_HEATH, RegionType.WILDERNESS,
                Set.of(RegionName.GREY_MOUNTAIN_NARROWS, RegionName.IRON_HILLS));
        Region theShire = new Region(RegionName.THE_SHIRE, RegionType.FREE_LAND,
                Set.of(RegionName.ARTHEDAIN, RegionName.CARDOLAN));
        Region udun = new Region(RegionName.UDUN, RegionType.DARK_LAND, Set.of(RegionName.GORGOROTH));
        Region lebennin = new Region(RegionName.LEBENNIN, RegionType.FREE_LAND,
                Set.of(RegionName.BELFALAS, RegionName.ANORIEN));
        Region lindon = new Region(RegionName.LINDON, RegionType.FREE_LAND,
                Set.of(RegionName.ARTHEDAIN, RegionName.ELVEN_SHORES));
        Region khand = new Region(RegionName.KHAND, RegionType.SHADOW_LAND, Set.of(RegionName.HARONDOR));
        Region lamedon = new Region(RegionName.LAMEDON, RegionType.BORDER_LAND,
                Set.of(RegionName.BELFALAS, RegionName.ANFALAS));
        Region ithilien = new Region(RegionName.ITHILIEN, RegionType.WILDERNESS,
                Set.of(RegionName.ANORIEN, RegionName.HARONDOR, RegionName.IMLAD_MORGUL));
        Region oldPukelGap = new Region(RegionName.OLD_PUKEL_GAP, RegionType.WILDERNESS,
                Set.of(RegionName.ANFALAS, RegionName.OLD_PUKEL_LAND));
        Region numeriador = new Region(RegionName.NUMERIADOR, RegionType.WILDERNESS,
                Set.of(RegionName.ARTHEDAIN, RegionName.FOROCHEL));
        Region nurn = new Region(RegionName.NURN, RegionType.DARK_LAND,
                Set.of(RegionName.GORGOROTH, RegionName.HORSE_PLAINS));
        Region mouthsOfTheAnduin = new Region(RegionName.MOUTHS_OF_THE_ANDUIN, RegionType.COAST,
                Set.of(RegionName.BELFALAS, RegionName.HARONDOR));
        Region northernRhovanion = new Region(RegionName.NORTHERN_RHOVANION, RegionType.WILDERNESS,
                Set.of(RegionName.DORWINION, RegionName.GREY_MOUNTAIN_NARROWS, RegionName.HEART_OF_MIRKWOOD,
                        RegionName.IRON_HILLS, RegionName.SOUTHERN_RHOVANION));

        // Add regions to graph
        graph.addVertex(woodlandRealm);
        graph.addVertex(woldFoothills);
        graph.addVertex(andrast);
        graph.addVertex(andrastCoast);
        graph.addVertex(belfalas);
        graph.addVertex(brownLands);
        graph.addVertex(arthedain);
        graph.addVertex(bayOfBelfalas);
        graph.addVertex(angmar);
        graph.addVertex(anorien);
        graph.addVertex(anduinVales);
        graph.addVertex(anfalas);
        graph.addVertex(gundabad);
        graph.addVertex(harondor);
        graph.addVertex(gorgoroth);
        graph.addVertex(greyMountainNarrows);
        graph.addVertex(imladMorgul);
        graph.addVertex(ironHills);
        graph.addVertex(hollin);
        graph.addVertex(horsePlains);
        graph.addVertex(heartOfMirkwood);
        graph.addVertex(highPass);
        graph.addVertex(dagorlad);
        graph.addVertex(dorwinion);
        graph.addVertex(cardolan);
        graph.addVertex(gapOfIsen);
        graph.addVertex(fangorn);
        graph.addVertex(forochel);
        graph.addVertex(enedwaith);
        graph.addVertex(eriadoranCoast);
        graph.addVertex(dunland);
        graph.addVertex(elvenShores);
        graph.addVertex(southernMirkwood);
        graph.addVertex(southernRhovanion);
        graph.addVertex(rhudaur);
        graph.addVertex(rohan);
        graph.addVertex(oldPukelLand);
        graph.addVertex(redhornGate);
        graph.addVertex(westernMirkwood);
        graph.addVertex(witheredHeath);
        graph.addVertex(theShire);
        graph.addVertex(udun);
        graph.addVertex(lebennin);
        graph.addVertex(lindon);
        graph.addVertex(khand);
        graph.addVertex(lamedon);
        graph.addVertex(ithilien);
        graph.addVertex(oldPukelGap);
        graph.addVertex(numeriador);
        graph.addVertex(nurn);
        graph.addVertex(mouthsOfTheAnduin);
        graph.addVertex(northernRhovanion);

        // Add edges between regions that are connected through moveTo
        for (Region region : graph.vertexSet()) {
            for (RegionName moveTo : region.getMoveTo()) {
                Region connectedRegion = graph.vertexSet().stream().filter(r -> r.getRegionName().equals(moveTo))
                        .findFirst().orElse(null);
                graph.addEdge(region, connectedRegion);
            }
        }

        return graph;
    }
}
