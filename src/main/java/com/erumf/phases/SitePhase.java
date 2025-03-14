package com.erumf.phases;

import java.util.List;

import com.erumf.Player;
import com.erumf.elements.Location;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Fellowship;

public class SitePhase {

    public static void sitePhase(Player player) {
        List<Fellowship> fellowships = player.getCardsInPlay().stream()
            .filter(Fellowship.class::isInstance)
            .map(Fellowship.class::cast)
            .toList();
        boolean done = false;
        do {
            Fellowship fellowship = ConsoleUtils.chooseElementOptional("Choose a fellowship to execute its site phase", 
                fellowships, f -> f.getLocation().getClass().getSimpleName());
            if (fellowship == null) {
                done = true;
            } else {
                sitePhaseExec(player, fellowship);
                fellowships.remove(fellowship);
            }
        } while (!done || !fellowships.isEmpty());
    }

    private static void sitePhaseExec(Player player, Fellowship fellowship) {
        // Automatic attacks
        automaticAttacks(player, fellowship.getLocation());
        
        // Play objects, ally or faction
        playResources(player, fellowship.getLocation());
        
        // Play additional minor item
        playAdditionalMinorItem(player, fellowship.getLocation());
    }

    private static void automaticAttacks(Player player, Location location) {
        // TODO: Implement automatic attacks
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void playResources(Player player, Location location) {
        // TODO: Implement play resources
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void playAdditionalMinorItem(Player player, Location location) {
        // TODO: Implement play additional minor item
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
