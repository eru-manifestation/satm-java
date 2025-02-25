package com.erumf.elements;

import java.util.Set;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.utils.GameProperty;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Deck;

/**
 * The Character class represents a character card in the game.
 * It extends the Basic class and includes various properties
 * such as influence, mind, skills, race, corruption, body, prowess, and mp.
 */
public abstract class Character extends Card {
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
    private final GameProperty<Integer> mp;
    private final int _mp;
    private boolean tapped = false;
    private boolean wounded = false;

    /**
     * Constructs a new Character with the specified properties.
     *
     * @param player      the player owning the character
     * @param race        the race of the character
     * @param birthplace  the birthplace of the character
     * @param influence   the influence of the character
     * @param mind        the mind of the character
     * @param skills      the skills of the character
     * @param corruption  the corruption of the character
     * @param body        the body of the character
     * @param prowess     the prowess of the character
     * @param mp          the mp of the character
     */
    public Character(Player player, Race race, Class<? extends Location> birthplace, int influence, int mind, Set<Skills> skills, int corruption, int body, int prowess, int mp) {
        super(player, true);
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
        this.mp = new GameProperty<>("mp", mp, this);
        this._mp = mp;
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
     * Gets the mp value.
     * This value is subject to changes by game rules.
     *
     * @return the mp value
     */
    public int getMp() {
        return Math.max(mp.getValue(), 0);
    }

    public void setMp(int mp) {
        this.mp.setValue(mp);
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
     * Gets the initial mp value.
     *
     * @return the initial mp value
     */
    public int getInitialMp() {
        return _mp;
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

    /**
     * Gets the companion size of the character.
     * Returns 0.5f if the race is HOBBIT, 1 otherwise.
     *
     * @return the companion size
     */
    public float companionSize() {
        return race == Race.HOBBIT ? 0.5f : 1.0f;
    }

    //TODO: doc
    // TODO: adjust to the new position sistem
    public void addCharacterToLocation(Class<? extends Location> locationClass) {
        Player player = this.getPlayer();
        Location location = Main.positionGraph.findLocation(locationClass);
        if (location == null) {
            throw new IllegalArgumentException("Location not found in the graph");
        }

        Fellowship fellowship = Main.positionGraph.edgesOf(location).stream()
                .map(Main.positionGraph::getEdgeTarget)
                .filter(Fellowship.class::isInstance)
                .map(Fellowship.class::cast)
                .filter(f -> f.getPlayer().equals(player))
                .findFirst()
                .orElse(null);

        if (fellowship == null) {
            fellowship = new Fellowship(player);
            Main.positionGraph.addVertex(fellowship);
            Main.positionGraph.addEdge(location, fellowship);
            Main.positionGraph.addVertex(this);
            Main.positionGraph.addEdge(fellowship, this);
        } else {
            if (fellowship.getCompanions() + this.companionSize() <= Fellowship.MAX_COMPANIONS) {
                Main.positionGraph.addVertex(this);
                Main.positionGraph.addEdge(fellowship, this);
            } else {
                throw new IllegalStateException("Fellowship would surpass the maximum number of companions");
            }
        }
    }

    public boolean isTapped() {
        return tapped;
    }

    public void untap() {
        this.tapped = false;
    }

    public boolean isWounded() {
        return wounded;
    }

    public void heal() {
        this.wounded = false;
        this.tapped = true;
    }

    public boolean isInHaven() {
        return false;//TODO: Implement
    }

    /**
     * Adds a child card to this character.
     * <p>If the child card is a {@link Character}:
     * - The child card is thought to be a follower and it checks if the character 
     * has enough influence to control the child character.
     * - If this character is in a {@link Fellowship}, it checks if the fellowship has enough space 
     * for the child character (follower).
     * - If this character is a follower, it throws an exception.
     * - If this character has no father (supposedly meaning it is in a {@link Deck}), 
     * it throws an exception.
     * 
     * @param card the child card to add
     * @throws IllegalArgumentException if the character cannot control the child character
     * @throws IllegalArgumentException if the fellowship has no space for this follower
     * @throws IllegalArgumentException if a follower character tries to have followers
     * @throws IllegalArgumentException if the character is not in a deck and has no father
     */
    @Override
    public void addChild(Card card){
        if(card instanceof Character character){
            this.setInfluence(this.getInfluence() - character.getMind());
            if(this.getInfluence() < 0){
                throw new IllegalArgumentException("Not enough influence to play the character as a follower");
            }
            switch(this.getFather()){
                case Fellowship fellowship -> {
                    fellowship.setCompanions(fellowship.getCompanions() + character.companionSize());
                    if(fellowship.getCompanions() > Fellowship.MAX_COMPANIONS){
                        throw new IllegalArgumentException("Fellowship is full");
                    }
                }
                case Character followedCharacter -> {
                    throw new IllegalArgumentException("Follower characters can't have followers");
                }
                case null -> {
                    throw new IllegalArgumentException("Characters with null father must always be in a deck");
                }
                default -> {
                    throw new IllegalArgumentException("Unexpected father found for a character in play");
                }
            }
        }
        super.addChild(card);
    }
}
