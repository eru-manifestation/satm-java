package com.erumf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.jgrapht.alg.util.Pair;

import com.erumf.elements.Location;
import com.erumf.utils.GameProperty;
import com.erumf.utils.cli.ConsoleUtils;
import com.erumf.utils.position.Card;
import com.erumf.utils.position.Deck;
import com.erumf.utils.position.Fellowship;

/**
 * The Player class represents a player in the game.
 * It includes properties such as the player's name, draw deck, hand, general influence, and marshal points.
 */
public class Player {
    private Deck drawDeck = null;
    private final Deck hand = new Deck();
    private final Deck discardDeck = new Deck();
    private final Deck mpDeck = new Deck();
    /**
     * Since this is just a view of the cards in play, it MUST NOT have the add implementation
     * that disconnects the card from the position tree.
     */
    private final List<Card> cardsInPlay = new ArrayList<>();
    private final String name;
    private final GameProperty<Integer> generalInfluence;
    private final GameProperty<Integer> mp;
    public static final int MAX_HAND_SIZE = 8;
    private Stream<Pair<Fellowship, Location>> destinations;

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
     * Gets the player's discard deck.
     *
     * @return the discard deck
     */
    public Deck getDiscardDeck() {
        return discardDeck;
    }

    /**
     * Gets the player's cards in play.
     *
     * @return the cards in play
     */
    public List<Card> getCardsInPlay() {
        return cardsInPlay;
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

    /**
     * Checks if a unique card of the specified class is disabled (in the discard deck)
     * or in play. Use only on unique cards.
     *
     * @param clazz the class of the card to check
     * @param <T>   the type of the card
     * @return true if the unique card is in the discard deck or in play, false otherwise
     */
    public <T extends Card> boolean isUniqueDisabled(Class<T> clazz) {
        return this.getDiscardDeck().stream()
                .anyMatch(discarded -> discarded.getClass().equals(clazz)) ||
               this.getCardsInPlay().stream()
                .anyMatch(inPlay -> inPlay.getClass().equals(clazz));
    }

    public void setDestinations(Stream<Pair<Fellowship, Location>> destinations) {
        this.destinations = destinations;
    }

    public Deck getMpDeck() {
        return mpDeck;
    }
}