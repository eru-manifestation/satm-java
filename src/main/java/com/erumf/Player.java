package com.erumf;

import java.util.List;

import com.erumf.utils.GameProperty;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Deck;

/**
 * The Player class represents a player in the game.
 * It includes properties such as the player's name, draw deck, hand, general influence, and marshal points.
 */
public class Player {
    private Deck drawDeck = null;
    private final Deck hand = new Deck();
    private final String name;
    private final GameProperty<Integer> generalInfluence;
    private final GameProperty<Integer> mp;
    public static final int MAX_HAND_SIZE = 8;

    /**
     * Constructs a new Player with the specified name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.generalInfluence = new GameProperty<>("generalInfluence", 20, this);
        this.mp = new GameProperty<>("mp", 0, this);
    }

    /**
     * Gets the player's draw deck.
     *
     * @return the draw deck
     */
    public Deck getDrawDeck() {
        return drawDeck;
    }

    /**
     * Sets the player's draw deck.
     *
     * @param drawDeck the draw deck to set
     */
    public void setDrawDeck(Deck drawDeck) {
        this.drawDeck = drawDeck;
    }

    /**
     * Gets the player's hand.
     *
     * @return the hand
     */
    public Deck getHand() {
        return hand;
    }

    /**
     * Gets the player's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's general influence.
     *
     * @return the general influence
     */
    public int getGeneralInfluence() {
        return generalInfluence.getValue();
    }

    /**
     * Sets the player's general influence.
     *
     * @param generalInfluence the general influence to set
     */
    public void setGeneralInfluence(int generalInfluence) {
        this.generalInfluence.setValue(generalInfluence);
    }

    /**
     * Gets the player's marshal points.
     *
     * @return the marshal points
     */
    public int getMp() {
        return mp.getValue();
    }

    /**
     * Sets the player's marshal points.
     *
     * @param mp the marshal points to set
     */
    public void setMp(int mp) {
        this.mp.setValue(mp);
    }

    /**
     * Standardizes the player's hand to ensure it has the maximum number of cards.
     */
    public void standardizeHand() {
        if (hand.size() > MAX_HAND_SIZE) {
            discard();
            standardizeHand();
        } else if (hand.size() < MAX_HAND_SIZE) {
            draw();
            standardizeHand();
        }
    }

    /**
     * Draws a card from the draw deck and adds it to the player's hand.
     */
    public void draw() {
        this.hand.add(this.drawDeck.draw());
    }

    /**
     * Asks the user to select a card for discard from the player's hand.
     */
    private void discard() {
        ConsoleUtils.chooseFrom("Discard a card", hand.stream().map(Object::toString).toList());
    }

    /**
     * Gets a list of cards from the player's hand that match the specified class.
     *
     * @param clazz the class of the cards to get
     * @param <T>   the type of the cards
     * @return a list of cards that match the specified class
     */
    public <T extends Card> List<T> getFromHand(Class<T> clazz) {
        return this.getHand().stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }
}