package com.erumf.events;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import com.erumf.utils.GameProperty;

/**
 * A game listener is a pair of a predicate and a function that, by learning the changes foreseen or applied to the game,
 * decides whether to let them happen, cancel them, or to do more actions right after.
 * <p>
 * The listeners marked as {@code IN} are used to decide whether to cancel the change or not and MUST NOT have any other function.
 * Those marked as {@code OUT} are expected to make changes in the game right after the change takes place.
 * <p>
 * The correct usage of this class would be to create it and store the listener inside a game element in order to be able to stop it from listening when not necessary.
 *
 * @param <T> the type of the property's value
 */
public class GameListener<T> {
    
    public enum EventType {
        IN,
        OUT
    }

    public boolean listen(GameProperty<T> property, T value) {
        if (this.preconditions.test(property, value))
            return this.effects.apply(property, value);
        else return true;
    }

    private final BiPredicate<GameProperty<T>, T> preconditions;
    private final BiFunction<GameProperty<T>, T, Boolean> effects;

    private GameListener(BiPredicate<GameProperty<T>, T> preconditions, BiFunction<GameProperty<T>, T, Boolean> effects) {
        this.preconditions = preconditions;
        this.effects = effects;
    }

    /**
     * Creates a new game listener and registers it with the appropriate event type.
     *
     * @param eventType the type of the event (IN or OUT)
     * @param preconditions the predicate to check preconditions
     * @param effects the function to apply effects
     * @param <T> the type of the property's value
     * @return the created game listener
     */
    public static <T> GameListener<T> create(EventType eventType, BiPredicate<GameProperty<T>, T> preconditions, BiFunction<GameProperty<T>, T, Boolean> effects) {
        GameListener<T> listener = new GameListener<>(preconditions, effects);
        switch (eventType) {
            case IN -> EventManager.addInListener(listener);
            case OUT -> EventManager.addOutListener(listener);
            default -> throw new AssertionError("Unknown event type: " + eventType);
        }
        return listener;
    }
}
