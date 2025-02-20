package com.erumf.elements;

import com.erumf.Basic;
import com.erumf.Player;

/**
 * The Resource class represents a resource card in the game.
 * It extends the Basic class and includes various properties
 * such as mp, corruption, influence, mind, body, and prowess.
 */
public abstract class Resource extends Basic {
    private int mp;
    private final int _mp;
    private int corruption;
    private final int _corruption;
    private int influence;
    private final int _influence;
    private int mind;
    private final int _mind;
    private int body;
    private final int _body;
    private int prowess;
    private final int _prowess;

    public enum Type {
        ALLY, FACTION, ITEM, SHORT_EVENT, LONG_EVENT, PERMANENT_EVENT
    }

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
    public Resource(Player player, int mp, int corruption, int influence, int mind, int body, int prowess, Type type) {
        super(player);
        this.mp = mp;
        this._mp = mp;
        this.corruption = corruption;
        this._corruption = corruption;
        this.influence = influence;
        this._influence = influence;
        this.mind = mind;
        this._mind = mind;
        this.body = body;
        this._body = body;
        this.prowess = prowess;
        this._prowess = prowess;
        this.type = type;
    }

    /**
     * Gets the mp value.
     * This value is subject to changes by game rules.
     *
     * @return the mp value
     */
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    /**
     * Gets the corruption value.
     * This value is subject to changes by game rules.
     *
     * @return the corruption value
     */
    public int getCorruption() {
        return corruption;
    }

    public void setCorruption(int corruption) {
        this.corruption = corruption;
    }

    /**
     * Gets the influence value.
     * This value is subject to changes by game rules.
     *
     * @return the influence value
     */
    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    /**
     * Gets the mind value.
     * This value is subject to changes by game rules.
     *
     * @return the mind value
     */
    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    /**
     * Gets the body value.
     * This value is subject to changes by game rules.
     *
     * @return the body value
     */
    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    /**
     * Gets the prowess value.
     * This value is subject to changes by game rules.
     *
     * @return the prowess value
     */
    public int getProwess() {
        return prowess;
    }

    public void setProwess(int prowess) {
        this.prowess = prowess;
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
        return _mp;
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
}
