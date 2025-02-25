package com.erumf.elements;

import com.erumf.Main;
import com.erumf.Player;

/**
 * The Item class represents an item card in the game.
 * It extends the Resource class and includes a property itemType.
 */
public abstract class Item extends Resource {
    public enum ItemType {
        GREATER_ITEM, MAJOR_ITEM, MINOR_ITEM, GOLD_RING_ITEM, SPECIAL_ITEM, INFORMATION
    }

    private final ItemType itemType;
    private State state = State.UNTAPPED;

    /**
     * Constructs a new Item with the specified properties.
     *
     * @param player      the player owning the item
     * @param mp          the mp of the item
     * @param corruption  the corruption points of the item
     * @param influence   the influence modifier of the item
     * @param mind        the mind of the item (for allies)
     * @param body        the body modifier of the item
     * @param prowess     the prowess of the item
     * @param itemType    the type of the item
     */
    public Item(Player player, int mp, int corruption, int influence, int mind, int body, int prowess, ItemType itemType, boolean unique) {
        super(player, mp, corruption, influence, mind, body, prowess, Resource.Type.ITEM, unique);
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    private void applyEffects(Character character) {
        this.getPlayer().setMp(this.getPlayer().getMp() + getMp());
        character.setCorruption(character.getCorruption() + getCorruption());
        character.setInfluence(character.getInfluence() + getInfluence());
        character.setMind(character.getMind() + getMind());
        character.setBody(character.getBody() + getBody());
        character.setProwess(character.getProwess() + getProwess());
    }

    /**
     * Plays the item as an initial item and puts it under the specified character.
     *
     * @param character the character to put the item under
     */
    public void playAsInitialItem(Character character) {        
        getPlayer().getDrawDeck().remove(this);
        Main.positionGraph.addVertex(character);
        Main.positionGraph.addEdge(character, this);//TODO: this should be prepared if it is not permitted, to go back
        applyEffects(character);
    }

    public boolean isTapped() {
        return state == State.TAPPED;
    }

    public void untap() {
        this.state = State.UNTAPPED;
    }

    public enum State {
        TAPPED, UNTAPPED
    }
}
