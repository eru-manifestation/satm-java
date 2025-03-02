package com.erumf.phases;

import org.jgrapht.alg.util.Pair;

import com.erumf.Player;
import com.erumf.elements.Location;
import com.erumf.exception.GameLogicException;
import com.erumf.utils.position.Fellowship;

public class MovementPhase {

    public static void movementPhase(Player player) {
        player.getDestinations().forEach(MovementPhase::movementPhaseExec);
    }

    private static void movementPhaseExec(Pair<Fellowship,Location> pair) {
        if(pair == null) {
    //  La compañía no se mueve
        }else{
            Fellowship fellowship = pair.getFirst();
            Location location = pair.getSecond();
            if(fellowship.isEmpty()) {
                throw new GameLogicException("An empty fellowship cannot move");
            }
        }
    }
    
}
