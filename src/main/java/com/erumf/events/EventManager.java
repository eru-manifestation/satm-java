package com.erumf.events;

import java.util.ArrayList;
import java.util.List;

import com.erumf.utils.GameProperty;

/**
 * This class calls all game elements with special abilities or conditions when a change is made in the game.
 * <p>
 * {@code inListeners} is a list of functionalities that may discard the game change.
 * {@code outListeners} is a list of functionalities which happen right after the changes have happened.
 * <p>TODO: Specify the order in which listeners are called depending on their position on the board.
 * For example, listeners could be called in the order of appearance in the hand, or from left to right in the board.
 */
public class EventManager {

    private static final List<GameListener<?>> inListeners = new ArrayList<>();
    private static final List<GameListener<?>> outListeners = new ArrayList<>();

    /**
     * Checks if all preconditions of the {@code inListeners} are met.
     * 
     * @param <T> the type of the property's value
     * @param property the game property
     * @param value the new value of the property
     * @return {@code true} if all preconditions are met, {@code false} otherwise
     */
    public static <T> boolean in(GameProperty<T> property, T value) {
        return inListeners.stream().allMatch(listener -> listen(listener, property, value));
    }

    /**
     * Calls all {@code outListeners} after the changes have happened.
     * 
     * @param <T> the type of the property's value
     * @param property the game property
     * @param value the old value of the property
     */
    public static <T> void out(GameProperty<T> property, T value) {
        outListeners.forEach(listener -> listen(listener, property, value));
    }

    @SuppressWarnings("unchecked")
    private static <T> boolean listen(GameListener<?> listener, GameProperty<T> property, T value) {
        return ((GameListener<T>) listener).listen(property, value);
    }

    public static boolean addInListener(GameListener<?> listener) {
        return inListeners.add(listener);
    }

    public static boolean removeInListener(GameListener<?> listener) {
        return inListeners.remove(listener);
    }

    public static boolean addOutListener(GameListener<?> listener) {
        return outListeners.add(listener);
    }

    public static boolean removeOutListener(GameListener<?> listener) {
        return outListeners.remove(listener);
    }
}
