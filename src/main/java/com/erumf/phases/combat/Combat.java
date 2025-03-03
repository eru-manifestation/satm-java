package com.erumf.phases.combat;

import java.util.ArrayList;
import java.util.List;

import com.erumf.elements.Character;
import com.erumf.elements.Creature;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Fellowship;

/**
 * The Combat class represents the combat phase of the game.
 * It includes methods to resolve combat between a fellowship and a creature.
 * The combat phase is divided into strikes, which are resolved one by one.
 * Each strike affects one character in the fellowship.
 */
public class Combat {

    public static void creatureCombat(Fellowship fellowship, Creature creature) {
        // TODO

        /**
         * Las cartas que modifiquen el número de golpes se tienen que
        jugar antes de asignarlos. Los factores que modifican un golpe
        deben decidirse antes de hacer la tirada en este orden:
            l. El jugador atacante puede jugar cartas de adversidades que
            modifiquen el golpe .
            2. El jugador atacante puede usar los golpes sin objetivo como
            modificadores -1 al poder sobre un personaje.
            3. El personaje objetivo del golpe puede luchar con -3 al poder
            para no quedar girado.
            4. Finalmente el jugador defensor puede jugar recursos que
            modifiquen el golpe.
         */
        // Jugar cartas que modifiquen el número de golpes
        // TODO
        // Asignar golpes
        List<Character> strikes = assignStrikes(fellowship, creature);
        Integer unAsiggnedStrikes = creature.getStrikes() - strikes.size();
        do { 
            Character strike = ConsoleUtils.chooseElement("Choose the strike that you would like to resolve", 
                strikes, 
                ch -> ch.getClass().getSimpleName());
            strikes.remove(strike);
            unAsiggnedStrikes = executeStrike(strike, unAsiggnedStrikes);
        } while (!strikes.isEmpty());
    }


    /**
     * The defender can choose the target character of each strike, but only if it is untapped.
     * If there are no untapped characters, the attacking player must assign the remaining strikes
     * to the tapped or wounded characters that have not yet faced any.
     * @param fellowship
     * @param creature
     * @return the list of characters that will face the strikes
     */
    public static List<Character> assignStrikes(Fellowship fellowship, Creature creature) {
        List<Character> companions = fellowship.getCompanionList();
        List<Character> unstrikenUntapped = companions.stream()
            .filter(ch -> !ch.isTapped())
            .toList();
        List<Character> strikes = new ArrayList<>();
        Boolean keep = false;
        if(!unstrikenUntapped.isEmpty() && ConsoleUtils.confirmAction("Do you want to a strike?")){
            keep = true;
        }

        while(keep && !unstrikenUntapped.isEmpty()) {
            Character strike = ConsoleUtils.chooseElementOptional("Choose the character that will face the next strike", 
                unstrikenUntapped, 
                ch -> ch.getClass().getSimpleName());
            unstrikenUntapped.remove(strike);
            strikes.add(strike);
            keep = ConsoleUtils.confirmAction("Do you want to assign another strike?");
        }
        while(!unstrikenUntapped.isEmpty()){
            Character strike = ConsoleUtils.chooseElementOptional("Choose the character that will face the next strike", 
                unstrikenUntapped, 
                ch -> ch.getClass().getSimpleName());
            strikes.add(strike);
            unstrikenUntapped.remove(strike);
        }
        
        return strikes;
    }

    private static Integer executeStrike(Character strike, Integer unAsiggnedStrikes) {
        Integer accumulatedModifier = 0;
        // Jugar cartas que modifiquen un golpe
        // TODO
        // Atacante puede asignar un golpe sin objetivo como modificador -1 al poder sobre un personaje
        if(unAsiggnedStrikes > 0) {
            if(ConsoleUtils.confirmAction("Do yo want to use a unassigned strike as a -1 modifier for this strike?")) {
                unAsiggnedStrikes--;
                strike.setProwess(strike.getProwess() - 1);
                accumulatedModifier-=1;
            }
        }
        // Personaje objetivo del golpe puede luchar con -3 al poder para no quedar girado
        if(!strike.isTapped()){
            if (ConsoleUtils.confirmAction("Do you want to face the strike with a -3 prowess modifier to avoid tapping the character afterwards?" )) {
                strike.setProwess(strike.getProwess() - 3);
                accumulatedModifier-=3;
            }
        }else if(strike.isWounded()){
            strike.setProwess(strike.getProwess() - 2);
            accumulatedModifier-=2;
        }else{
            strike.setProwess(strike.getProwess() - 1);
            accumulatedModifier-=1;
        }

        // Defensor puede jugar recursos que modifiquen el golpe
        // TODO

        // Se resuelve el golpe
        // TODO

        // Consecuencia de los golpes
        // TODO
        
        strike.setProwess(strike.getProwess() - accumulatedModifier);
        return unAsiggnedStrikes;
    }

}
