package com.erumf.phases;

import java.util.List;

import com.erumf.Main;
import com.erumf.Player;
import com.erumf.elements.Hazard;
import com.erumf.elements.Resource;
import com.erumf.utils.cli.ConsoleUtils;

public class LongEventPhase {

    /**
     * This method represents the long event phase of the game. It is divided into
     * three steps: 1. Discard your long event resources in play. 2. Play long
     * event resources from your hand. 3. Discard your opponent's long event
     * hazards in play.
     * @param player1
     */
    public static void longEventPhase(Player player1) {
        discardFormerLongEventResources(player1);
        boolean done;
        do { 
            done = playLongEvents(player1);
        } while (done);
        discardFormerLongEventHazards(player1);
    }

    private static void discardFormerLongEventResources(Player player) {
        player.getCardsInPlay().stream()
                .filter(Resource.class::isInstance)
                .map(Resource.class::cast)
                .filter(r->r.getType().equals(Resource.Type.LONG_EVENT))
                .forEach(card -> player.getDiscardDeck().add(card));
    }

    private static boolean playLongEvents(Player player) {
        List<Resource> playableLongEvents = player.getHand().stream()
                .filter(Resource.class::isInstance)
                .map(Resource.class::cast)
                .filter(r->r.getType().equals(Resource.Type.LONG_EVENT))
                .filter(Resource::isPlayable)
                .toList();

        String choice = ConsoleUtils.chooseFromOptional("Play a long event", playableLongEvents.stream().map(r->r.getClass().getSimpleName()).toList());
        if (choice!=null) {
            Resource chosenEvent = playableLongEvents.stream().filter(r -> r.getClass().getSimpleName().equals(choice)).findFirst().orElse(null);
            if (chosenEvent != null) {
                player.getHand().remove(chosenEvent);
                player.getCardsInPlay().add(chosenEvent);
                return true;
            }else{
                throw new IllegalArgumentException("Card not found");
            }
        }
        return false;
        
    }

    private static void discardFormerLongEventHazards(Player player) {
        Main.enemy(player).getCardsInPlay().stream()
                .filter(Hazard.class::isInstance)
                .map(Hazard.class::cast)
                .filter(r->r.getType().equals(Hazard.Type.LONG_EVENT))
                .forEach(card -> player.getDiscardDeck().add(card));
    }
    
}
