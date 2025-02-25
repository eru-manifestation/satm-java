package com.erumf.utils.position;

import java.util.ArrayList;
import java.util.List;

import com.erumf.Player;

/**
 * The Basic class represents a basic element in the game.
 * For safety reasons, the classes in charge of positioning must be isolated in a separate package.
 * This is in order to avoid misusage of the methods that manage parenting.
 * 
 * The addChild method is the only destructive method that should be used when managing the positioning of elements.
 * All the other data is automatically configured.
 */
public abstract class Card {
    private final Player player;
    private Card father;
    private final List<Card> children = new ArrayList<>();

    public Card(Player player) {
        this.player = player;
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

    public List<Card> getChildren() {
        return children;
    }

    /**
     * Adds a child to this Basic.
     * This method is the only setter method that should be used when managing the positioning of elements.
     * All the other data is automatically configured.
     *
     * @param child the child to add
     */
    public void addChild(Card child) {
        if(this.father != null) {
            this.father.removeChild(child);
        }
        children.add(child);
        child.setFather(this);
    }

    /**
     * Removes a child from this Basic.
     * This method can only be called when the card is put into a deck or when it is set to another father.
     *
     * @param child the child to remove
     */
    void removeChild(Card child) {
        children.remove(child);
        child.setFather(null);
    }

    /**
     * TODO: IMPLEMENTAR UNA COLECCIÓN DE LISTENERS CON TIPO: IN, EXEC, OUT Y UN EVENTO ASOCIADO
     * CUANDO SE AÑADE UN LISTENER DE UN EVENTO ASOCIADO AUTOMATICAMENTE EN ESTA CLASE SE DEBE
     * AÑADIR A LA COLECCIÓN DE LISTENERS DE ESA CLASE DE EVENTO
     * 
     * 
     * TODO: dividir las fases de forma programática, en eventos que se siguen unos detrás de otros??
     */
}