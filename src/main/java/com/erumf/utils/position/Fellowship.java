package com.erumf.utils.position;

import java.util.List;
import java.util.stream.Stream;

import com.erumf.Player;
import com.erumf.elements.Character;
import com.erumf.elements.Location;

/**
 * The Fellowship class represents a group of character cards in the game.
 * The fellowship moves and faces threats together.
 */
public class Fellowship extends Card {
    public static final float MAX_COMPANIONS = 7f;
    private boolean empty = true;
    private float companions = 0.0f;

    public Fellowship(Player player) {
        super(player, false);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public float getCompanions() {
        return companions;
    }

    public void setCompanions(float companions) {
        this.companions = companions;
    }

    /**
     * Adds a card to the fellowship.
     * <p>If the card is a character, it is considered as if a character joins the fellowship
     * and increases the number of companions.
     * If the number of companions exceeds the maximum allowed, an exception is thrown.
     *
     * @param card the card to add
     * @throws IllegalArgumentException if the fellowship is full
     */
    @Override
    public void addChild(Card card) {
        if(card instanceof Character character){
            this.setCompanions(this.getCompanions() + character.companionSize());
            empty = false;
            if(companions >= MAX_COMPANIONS){
                throw new IllegalArgumentException("Fellowship is full");
            }
        }
        super.addChild(card);
    }

    /**
     * Removes a card from the fellowship.
     * <p>If the card is a character, it is considered as if a character leaves the fellowship
     * and decreases the number of companions.
     *
     * @param card the card to remove
     */
    @Override
    public void removeChild(Card card) {
        if(card instanceof Character character){
            this.setCompanions(this.getCompanions() - character.companionSize());
            if(companions == 0){
                empty = true;
                // Remove empty Fellowship
                this.getFather().removeChild(this);
            }
        }
        super.removeChild(card);
    }

    /**
     * Gets the list of characters in the fellowship and their followers in order.
     *
     * @return the list of characters in the fellowship and their followers
     */
    public List<Character> getCompanionList(){
        List<Character> companionList = this.getChildren().stream()
                .filter(Character.class::isInstance)
                .map(Character.class::cast).toList();
        Stream<Character> followers = companionList.stream()
               .flatMap(character -> character.getFollowers().stream());
        return Stream.concat(companionList.stream(), followers).toList();
    }

    /**
     * Gets the location of the fellowship.
     *
     * @return the {@link Location} of the fellowship
     */
    public Location getLocation() {
        return (Location) this.getFather();
    }
}
