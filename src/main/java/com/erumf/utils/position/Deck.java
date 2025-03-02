package com.erumf.utils.position;

import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card> {

    public <T> T findFirstOf(Class<T> clazz) {
        return this.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public Card draw() {
        return this.remove(0);
    }

    public List<Card> draw(Integer ammount) {
        List<Card> drawn = this.subList(0, ammount);
        this.removeRange(0, ammount);
        return drawn;
    }

    /**
     * Adds a card to the deck.
     * The only right way to remove a card with all its subcards from the game is to add it to a Deck, which cleans its father and children property.
     *
     * @param card the card to add
     * @return true if the card was added successfully, false otherwise
     */
    @Override
    public boolean add(Card card) {
        Card father = card.getFather();
        if(father != null) {
            father.removeChild(card);
        }
        card.children.forEach(this::add);
        return super.add(card);
    }
}
