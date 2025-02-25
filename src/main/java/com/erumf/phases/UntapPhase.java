package com.erumf.phases;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Character;
import com.erumf.elements.Fellowship;
import com.erumf.elements.Item;
import com.erumf.utils.position.Card;

/**
 * The UntapPhase class handles the untapping phase of the game.
 * During this phase, the active player can untap all their items,
 * characters and other cards that are tapped (90°) except for
 * locations. If the characters are in a haven, you can heal the
 * wounded characters by moving them from the wounded position
 * (180°) to the tapped position (90°).
 * <p>
 * In this implementation it is supossed that every player wants to
 * untap all their cards, and heal all their characters in haven.
 */
public class UntapPhase {
    /**
     * Untaps all tapped characters and items of the given player.
     *
     * @param player the player whose fellowship to untap
     */
    public static void untapPhase(Player player) {
        Main.positionGraph.locations.stream()
                .flatMap(loc -> loc.getChildren().stream())
                .filter(Fellowship.class::isInstance)
                .filter(fell -> fell.getPlayer().equals(player))
                .flatMap(fell -> fell.getChildren().stream())
                .forEach((Card card) -> {
                    switch (card) {
                        case Character character -> {
                            if (character.isTapped()) {
                                character.untap();
                            } else if (character.isWounded() && character.isInHaven()) {
                                character.heal();
                            }
                        }
                        case Item item -> {
                            if (item.isTapped()) {
                                item.untap();
                            }
                        }
                        // case Resource resource -> {
                        // if (resource isTapped()) {
                        // resource.untap();
                        // }
                        // }
                        default -> {
                        }
                    }
                });
    }
}
