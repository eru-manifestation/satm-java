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

    private Integer unassignedStrikes;
    private String result = "success";
    private final List<Character> strikes;
    private final Creature creature;
    private final Fellowship fellowship;

    private Combat(Fellowship fellowship, Creature creature) {
        this.fellowship = fellowship;
        this.creature = creature;
        // Jugar cartas que modifiquen el número de golpes
        playStrikeNumberModifyingHazards();
        
        // Asignar golpes
        this.strikes = assignStrikes();
        this.unassignedStrikes = creature.getStrikes() - strikes.size();

        // Resolución de golpes
        resolveStrikes();

        // Consecuencias de los golpes
        if(this.result.equals("success")){
            creature.eliminate();
        }else{
            creature.discard();
        }
    }
        
    public static Combat creatureCombat(Fellowship fellowship, Creature creature) {
        return new Combat(fellowship, creature);
    }

    /**
     * Resolves the strikes of the creature against the fellowship.
     */
    private void resolveStrikes() {
        do { 
            Character striken = ConsoleUtils.chooseElement("Choose the strike that you would like to resolve", 
                strikes, 
                ch -> ch.getClass().getSimpleName());
            strikes.remove(striken);
            StrikeCheck strike = new StrikeCheck(this, striken, creature);
            if("success".equals(this.result))
                this.result = strike.getResult();
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
    private List<Character> assignStrikes() {
        List<Character> companions = this.fellowship.getCompanionList();
        List<Character> unstrikenUntapped = companions.stream()
            .filter(ch -> !ch.isTapped())
            .toList();
        List<Character> assignedStrikes = new ArrayList<>();
        Boolean keep = false;
        if(!unstrikenUntapped.isEmpty() && ConsoleUtils.confirmAction("Do you want to a strike?")){
            keep = true;
        }

        while(keep && !unstrikenUntapped.isEmpty()) {
            Character strike = ConsoleUtils.chooseElementOptional("Choose the character that will face the next strike", 
                unstrikenUntapped, 
                ch -> ch.getClass().getSimpleName());
            unstrikenUntapped.remove(strike);
            assignedStrikes.add(strike);
            keep = ConsoleUtils.confirmAction("Do you want to assign another strike?");
        }
        while(!unstrikenUntapped.isEmpty()){
            Character strike = ConsoleUtils.chooseElementOptional("Choose the character that will face the next strike", 
                unstrikenUntapped, 
                ch -> ch.getClass().getSimpleName());
            strikes.add(strike);
            unstrikenUntapped.remove(strike);
        }
        
        return assignedStrikes;
    }

    public Integer getUnassignedStrikes() {
        return unassignedStrikes;
    }

    public void setUnassignedStrikes(Integer unassignedStrikes) {
        this.unassignedStrikes = unassignedStrikes;
    }

    public String getResult() {
        return result;
    }

    /**
     * The enemy plays {@link Hazard} that modify the number of strikes.
     */
    private void playStrikeNumberModifyingHazards() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
