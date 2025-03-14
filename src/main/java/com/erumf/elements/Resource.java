package com.erumf.elements;

import com.erumf.Player;
import com.erumf.utils.GameProperty;
import com.erumf.utils.position.Card;

/**
 * The Resource class represents a resource card in the game.
 * It extends the Basic class and includes various properties
 * such as mp, corruption, influence, mind, body, and prowess.
 */
public abstract class Resource extends Card {
    public enum Type {
        ALLY, FACTION, ITEM, SHORT_EVENT, LONG_EVENT, PERMANENT_EVENT
    }

    // GameProperties
    private final GameProperty<Integer> mp;
    private final GameProperty<Integer> corruption;
    private final GameProperty<Integer> influence;
    private final GameProperty<Integer> mind;
    private final GameProperty<Integer> body;
    private final GameProperty<Integer> prowess;

    // Intrinsic properties
    private final Type type;

    /**
     * Constructs a new Resource with the specified properties.
     *
     * @param player      the player owning the resource
     * @param mp          the mp of the resource
     * @param corruption  the corruption points of the resource
     * @param influence   the influence modifier of the resource
     * @param mind        the mind of the resource (for allies)
     * @param body        the body modifier of the resource
     * @param prowess     the prowess of the resource
     * @param type        the type of the resource
     */
    public Resource(Player player, int mp, int corruption, int influence, int mind, int body, int prowess, Type type, boolean unique) {
        super(player, unique);
        this.mp = new GameProperty<>("mp", mp, this);
        this.corruption = new GameProperty<>("corruption", corruption, this);
        this.influence = new GameProperty<>("influence", influence, this);
        this.mind = new GameProperty<>("mind", mind, this);
        this.body = new GameProperty<>("body", body, this);
        this.prowess = new GameProperty<>("prowess", prowess, this);
        this.type = type;
    }

    /**
     * Gets the mp value.
     * This value is subject to changes by game rules.
     *
     * @return the mp value
     */
    public int getMp() {
        return mp.getValue();
    }

    public void setMp(int mp) {
        this.mp.setValue(mp);
    }

    /**
     * Gets the corruption value.
     * This value is subject to changes by game rules.
     *
     * @return the corruption value
     */
    public int getCorruption() {
        return corruption.getValue();
    }

    public void setCorruption(int corruption) {
        this.corruption.setValue(corruption);
    }

    /**
     * Gets the influence value.
     * This value is subject to changes by game rules.
     *
     * @return the influence value
     */
    public int getInfluence() {
        return influence.getValue();
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
        return mind.getValue();
    }

    public void setMind(int mind) {
        this.mind.setValue(mind);
    }

    /**
     * Gets the body value.
     * This value is subject to changes by game rules.
     *
     * @return the body value
     */
    public int getBody() {
        return body.getValue();
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
        return prowess.getValue();
    }

    public void setProwess(int prowess) {
        this.prowess.setValue(prowess);
    }

    public Type getType() {
        return type;
    }

    /**
     * Gets the initial mp value.
     *
     * @return the initial mp value
     */
    public int getInitialMp() {
        return mp.getInitialValue();
    }

    /**
     * Gets the initial corruption value.
     *
     * @return the initial corruption value
     */
    public int getInitialCorruption() {
        return corruption.getInitialValue();
    }

    /**
     * Gets the initial influence value.
     *
     * @return the initial influence value
     */
    public int getInitialInfluence() {
        return influence.getInitialValue();
    }

    /**
     * Gets the initial mind value.
     *
     * @return the initial mind value
     */
    public int getInitialMind() {
        return mind.getInitialValue();
    }

    /**
     * Gets the initial body value.
     *
     * @return the initial body value
     */
    public int getInitialBody() {
        return body.getInitialValue();
    }

    /**
     * Gets the initial prowess value.
     *
     * @return the initial prowess value
     */
    public int getInitialProwess() {
        return prowess.getInitialValue();
    }
}
