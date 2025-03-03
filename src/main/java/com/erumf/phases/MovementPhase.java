package com.erumf.phases;

import java.util.List;

import org.jgrapht.alg.util.Pair;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Character;
import com.erumf.elements.Creature;
import com.erumf.elements.Haven;
import com.erumf.elements.Location;
import com.erumf.phases.combat.Combat;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Fellowship;

public class MovementPhase {

    public static void movementPhase(Player player) {
        List<Pair<Fellowship, Location>> destinations = player.getDestinations().toList();
        do {
            Pair<Fellowship, Location> choice = ConsoleUtils
                    .chooseAction("Choose a fellowship to execute its movement phase", destinations);
            movementPhaseExec(player, choice);
        } while (!destinations.isEmpty());
    }

    private static void movementPhaseExec(Player player, Pair<Fellowship, Location> pair) {
        Fellowship fellowship = pair.getFirst();
        Location location = pair.getSecond();
        Integer hazardLimit;
        if (location == null) {
            // La compañía no se mueve

            // Calcular limite de adversidades
            hazardLimit = hazardLimit(fellowship);
            // Jugar adversidades
            playhazards(player, fellowship, location, hazardLimit);
            // Reponer mano
            player.standardizeHand();
            Main.enemy(player).standardizeHand();
        } else {
            // Revelar el lugar de destino
            // TODO
            // Calcular limite de adversidades
            hazardLimit = hazardLimit(fellowship);
            // Robar cartas
            drawCards(player, fellowship.getLocation() ,location);
            // Jugar adversidades
            playhazards(player, fellowship, location, hazardLimit);
            // Llegar al lugar de destino
            // TODO
            // Reponer mano
            player.standardizeHand();
            Main.enemy(player).standardizeHand();
        }
    }

    /**
     * Returns the hazard limit for a given fellowship. The hazard limit is equal to
     * the size of the company,
     * but the hobbits count as half a character, rounded up; and the minimum is
     * two. The hazard limit will remain fixed even if a character leaves the
     * company later.
     * It indicates the number of hazard cards that the opponent can play on the
     * company.
     * 
     * @param fellowship
     * @return
     */
    private static Integer hazardLimit(Fellowship fellowship) {
        return Math.max(2, (int) Math.ceil(fellowship.getCompanionList().stream()
                .mapToDouble(Character::companionSize)
                .sum()));
    }

    private static void drawCards(Player player, Location origin, Location destination) {
        if (destination instanceof Haven){
            player.draw(origin.getPlayerDraw());
            Main.enemy(player).draw(origin.getEnemyDraw());
        }else if (destination != null) {
            player.draw(destination.getPlayerDraw());
            Main.enemy(player).draw(destination.getEnemyDraw());
        }else{
            throw new IllegalArgumentException("Destination is null");
        }
    }

    private static void playhazards(Player player, Fellowship fellowship, Location location, Integer hazardLimit) {
        boolean done;
        do {
            done = playEventhazard(player, fellowship, location);
            done |= playCreaturehazard(player, fellowship, location);
        } while (hazardLimit > 0 && done);
    }

    private static boolean playEventhazard(Player player, Fellowship fellowship, Location location) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static boolean playCreaturehazard(Player player, Fellowship fellowship, Location location) {
        List<Creature> choices = Main.enemy(player).getHand().stream()
                .filter(Creature.class::isInstance)
                .map(Creature.class::cast)
                .filter(Creature::isPlayable)
                .toList();
        
        Creature creature = ConsoleUtils.chooseElementOptional("Choose a creature hazard to play", 
            choices, 
            c->c.getClass().getSimpleName());
        if (creature != null) {
            creature.play();
            Combat.creatureCombat(fellowship, creature);
            return true;
        }
        return false;
    }

}
