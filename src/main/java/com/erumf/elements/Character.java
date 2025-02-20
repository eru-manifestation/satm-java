package com.erumf.elements;

import java.util.Set;

import com.erumf.Basic;
import com.erumf.Player;
import com.erumf.utils.GameProperty;

/**
 * The Character class represents a character card in the game.
 * It extends the Basic class and includes various properties
 * such as influence, mind, skills, race, corruption, body, and prowess.
 */
public abstract class Character extends Basic {
    private final boolean unique;
    private final Class<? extends Location> birthplace;
    private final GameProperty<Integer> influence;
    private final int _influence;
    private final GameProperty<Integer> mind;
    private final int _mind;
    private final GameProperty<Set<Skills>> skills;
    private final Set<Skills> _skills;
    private final Race race;
    private final GameProperty<Integer> corruption;
    private final int _corruption;
    private final GameProperty<Integer> body;
    private final int _body;
    private final GameProperty<Integer> prowess;
    private final int _prowess;

    /**
     * Constructs a new Character with the specified properties.
     *
     * @param player      the player owning the character
     * @param unique      whether the character is unique
     * @param race        the race of the character
     * @param birthplace  the birthplace of the character
     * @param influence   the influence of the character
     * @param mind        the mind of the character
     * @param skills      the skills of the character
     * @param corruption  the corruption of the character
     * @param body        the body of the character
     * @param prowess     the prowess of the character
     */
    public Character(Player player, Race race, Class<? extends Location> birthplace, int influence, int mind, Set<Skills> skills, int corruption, int body, int prowess) {
        super(player);
        this.unique = true;
        this.race = race;
        this.birthplace = birthplace;
        this.influence = new GameProperty<>("influence", influence, this);
        this._influence = influence;
        this.mind = new GameProperty<>("mind", mind, this);
        this._mind = mind;
        this.skills = new GameProperty<>("skills", skills, this);
        this._skills = skills;
        this.corruption = new GameProperty<>("corruption", corruption, this);
        this._corruption = corruption;
        this.body = new GameProperty<>("body", body, this);
        this._body = body;
        this.prowess = new GameProperty<>("prowess", prowess, this);
        this._prowess = prowess;
    }

    public boolean isUnique() {
        return unique;
    }

    public Class<? extends Location> getBirthplace() {
        return birthplace;
    }

    /**
     * Gets the influence value.
     * This value is subject to changes by game rules.
     *
     * @return the influence value
     */
    public int getInfluence() {
        return Math.max(influence.getValue(), 0);
    }

    public void setInfluence(int influence) {
        this.influence.setValue(influence);
    }

    /**
     * Gets the mind value.
     * This value is subject to changes by game rules.
     *
     * @return the mind value
     */
    public int getMind() {
        return Math.max(mind.getValue(), 0);
    }

    public void setMind(int mind) {
        this.mind.setValue(mind);
    }

    /**
     * Gets the skills.
     * These values are subject to changes by game rules.
     *
     * @return the skills
     */
    public Set<Skills> getSkills() {
        return skills.getValue();
    }

    public void setSkills(Set<Skills> skills) {
        this.skills.setValue(skills);
    }

    public Race getRace() {
        return race;
    }

    /**
     * Gets the corruption value.
     * This value is subject to changes by game rules.
     *
     * @return the corruption value
     */
    public int getCorruption() {
        return Math.max(corruption.getValue(), 0);
    }

    public void setCorruption(int corruption) {
        this.corruption.setValue(corruption);
    }

    /**
     * Gets the body value.
     * This value is subject to changes by game rules.
     *
     * @return the body value
     */
    public int getBody() {
        return Math.max(body.getValue(), 0);
    }

    public void setBody(int body) {
        this.body.setValue(body);
    }

    /**
     * Gets the prowess value.
     * This value is subject to changes by game rules.
     *
     * @return the prowess value
     */
    public int getProwess() {
        return Math.max(prowess.getValue(), 0);
    }

    public void setProwess(int prowess) {
        this.prowess.setValue(prowess);
    }

    /**
     * Gets the initial influence value.
     *
     * @return the initial influence value
     */
    public int getInitialInfluence() {
        return _influence;
    }

    /**
     * Gets the initial mind value.
     *
     * @return the initial mind value
     */
    public int getInitialMind() {
        return _mind;
    }

    /**
     * Gets the initial skills.
     *
     * @return the initial skills
     */
    public Set<Skills> getInitialSkills() {
        return _skills;
    }

    /**
     * Gets the initial corruption value.
     *
     * @return the initial corruption value
     */
    public int getInitialCorruption() {
        return _corruption;
    }

    /**
     * Gets the initial body value.
     *
     * @return the initial body value
     */
    public int getInitialBody() {
        return _body;
    }

    /**
     * Gets the initial prowess value.
     *
     * @return the initial prowess value
     */
    public int getInitialProwess() {
        return _prowess;
    }

    /**
     * The possible races of a character.
     */
    public enum Race {
        DUNEDAIN, ELF, DWARF, HOBBIT, MAN, WIZARD
    }

    public enum Skills {
        WARRIOR, SCOUT, RANGER, SAGE, DIPLOMAT
    }
}
