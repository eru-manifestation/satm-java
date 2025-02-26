package com.erumf.utils.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.erumf.Player;

/**
 * The Basic class represents a basic element in the game.
 * For safety reasons, the classes in charge of positioning must be isolated in
 * a separate package.
 * This is in order to avoid misusage of the methods that manage parenting.
 * 
 * The addChild method is the only destructive method that should be used when
 * managing the positioning of elements.
 * All the other data is automatically configured.
 */
public abstract class Card {
    private final Player player;
    private Card father;
    final List<Card> children = new ArrayList<>();
    private final boolean unique;

    public Card(Player player, boolean unique) {
        this.player = player;
        this.unique = unique;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getFather() {
        return father;
    }

    void setFather(Card father) {
        this.father = father;
    }

    /**
     * Returns an unmodifiable view of the children list. If you want to modify the list
     * of children, use the addChild and removeChild methods.
     *
     * @return an unmodifiable list of children
     */
    public List<Card> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /**
     * Adds a child to this Basic.
     * This method is the only setter method that should be used when managing the
     * positioning of elements.
     * All the other data is automatically configured.
     *
     * @param child the child to add
     * @throws IllegalArgumentException if the card is unique and already in the discard deck
     */
    public void addChild(Card child) {
        if(child.isUnique() && child.getPlayer().isUniqueDisabled(child.getClass())){
            throw new IllegalArgumentException("Card is unique and already in the discard deck or in play");
        }
        if (child.father != null) {
            child.father.removeChild(child);
        }else{
            child.getPlayer().getCardsInPlay().add(child);
        }
        this.children.add(child);
        child.setFather(this);
    }

    /**
     * Removes a child from this Basic.
     * This method can only be called when the card is put into a deck or when it is
     * set to another father.
     *
     * @param child the child to remove
     */
    public void removeChild(Card child) {
        children.remove(child);
        child.setFather(null);
    }

    /**
     * Gets the unique property of the card.
     *
     * @return true if the card is unique, false otherwise
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * Discards this card, removing it from its current position and adding it to the player's discard deck.
     */
    public void discard() {
        if (this.father != null) {
            this.father.removeChild(this);
        }
        this.player.getCardsInPlay().remove(this);
        this.player.getDiscardDeck().add(this);
    }

    /**
     * TODO: IMPLEMENTAR UNA COLECCIÓN DE LISTENERS CON TIPO: IN, EXEC, OUT Y UN
     * EVENTO ASOCIADO
     * CUANDO SE AÑADE UN LISTENER DE UN EVENTO ASOCIADO AUTOMATICAMENTE EN ESTA
     * CLASE SE DEBE
     * AÑADIR A LA COLECCIÓN DE LISTENERS DE ESA CLASE DE EVENTO
     * 
     * 
     * TODO: dividir las fases de forma programática, en eventos que se siguen unos
     * detrás de otros??
     */
}