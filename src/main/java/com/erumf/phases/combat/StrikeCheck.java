package com.erumf.phases.combat;

import com.erumf.elements.Character;
import com.erumf.elements.Creature;
import com.erumf.utils.Dice;
import com.erumf.utils.cli.ConsoleUtils;

public class StrikeCheck {

    private String result;
    private Integer accumulatedModifier = 0;
    private final Character striken;
    private final Creature creature;
    private final Combat combat;

    /**
     * The factors that modify the strike must be decided before making the roll in this order:
     * <lo>
     * <li> The attacking player can play hazards that modify the strike.
     * <li> The attacking player can use unassigned strikes as -1 modifiers to the prowess of a character.
     * <li> The target character of the strike can face the strike with -3 prowess to avoid being tapped.
     * <li> Finally, the defending player can play resources that modify the strike.
     * </lo>
     * 
     * @param combat the combat phase in which the strike is being resolved
     * @param striken the character that is being attacked
     * @param creature the creature that is attacking
     * 
     * @see Combat
     * @see Character
    */
    public StrikeCheck(Combat combat, Character striken, Creature creature) {
        this.combat = combat;
        this.striken = striken;
        this.creature = creature;

        // Jugar cartas que modifiquen un golpe
        playStrikeModifyingHazards();

        // Atacante puede asignar un golpe sin objetivo como modificador -1 al poder sobre un personaje
        chooseUnassignedModifier();

        // Personaje objetivo del golpe puede luchar con -3 al poder para no quedar girado
        chooseNotTap();

        // Defensor puede jugar recursos que modifiquen el golpe
        playStrikeModifyingResources();

        // Se resuelve el golpe
        resolveStrike();

        // Consecuencia de los golpes
        strikeConsequences();
        
        // Resetea los modificadores
        striken.setProwess(striken.getProwess() - accumulatedModifier);   
    }

    public String getResult() {
        return this.result;
    }


    /**
     * The enemy plays {@link Hazard} that modify this single strike.
     */
    private void playStrikeModifyingHazards() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * The player plays {@link Resource} that modify this single strike.
     */
    private void playStrikeModifyingResources() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates the result of the strike based on the dice roll and the prowess of the characters
     * and the prowess of the creature.
     */
    private void resolveStrike() {
        Integer dice = Dice.roll() + striken.getProwess();
        if(dice > creature.getProwess()){
            this.result = "success";
        }else if (dice == creature.getProwess()){
            this.result = "tie";
        }else{
            this.result = "failure";
        }
    }

    /**
     * Applies the consequences of the strike based on the result of the strike.
     */
    private void strikeConsequences() {
        switch (this.result) {
            case "success" -> {
                if(creature.resistanceCheck()){
                    this.result = "tie";
                }
            }
            case "tie" -> {}
            case "failure" -> striken.resistanceCheck();
            default -> throw new AssertionError();
        }
    }

    /**
     * The character can choose to face the strike with a -3 prowess modifier to avoid tapping the character afterwards.
     */
    private void chooseNotTap() {
        if(!striken.isTapped()){
            if (ConsoleUtils.confirmAction("Do you want to face the strike with a -3 prowess modifier to avoid tapping the character afterwards?" )) {
                striken.setProwess(striken.getProwess() - 3);
                accumulatedModifier-=3;
            }
        }else if(striken.isWounded()){
            striken.setProwess(striken.getProwess() - 2);
            accumulatedModifier-=2;
        }else{
            striken.setProwess(striken.getProwess() - 1);
            accumulatedModifier-=1;
        }
    }

    /**
     * The attacker can choose to use an unassigned strike as a -1 modifier for this strike.
     */
    private void chooseUnassignedModifier() {
        if(combat.getUnassignedStrikes() > 0) {
            if(ConsoleUtils.confirmAction("Do yo want to use a unassigned strike as a -1 modifier for this strike?")) {
                combat.setUnassignedStrikes(combat.getUnassignedStrikes()-1);
                striken.setProwess(striken.getProwess() - 1);
                accumulatedModifier-=1;
            }
        }
    }

}
