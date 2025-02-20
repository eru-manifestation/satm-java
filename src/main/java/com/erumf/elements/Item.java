package com.erumf.elements;

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
     * @param type        the type of the resource
     * @param itemType    the type of the item
     */
    public Item(Player player, int mp, int corruption, int influence, int mind, int body, int prowess, ItemType itemType) {
        super(player, mp, corruption, influence, mind, body, prowess, Resource.Type.ITEM);
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
