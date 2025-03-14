package com.erumf.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.erumf.events.EventManager;

/**
 * Represents a piece of mutable game data. Changes to this property must trigger
 * precondition checking for all listeners available.
 * 
 * @param <T> the type of the property's value
 */
public class GameProperty<T> {
    private T value;
    private final T initialValue;
    private final String name;
    private final Object source;

    /**
     * Constructs a new GameProperty with the specified name, initial value, and source.
     * 
     * @param name  the name of the property, which must be the name of the variable
     *              of the object to which it belongs
     * @param value the initial value of the property
     * @param source the source object to which this property belongs
     * @throws NullPointerException if name, value, or source is null
     */
    @SuppressWarnings("unchecked")
    public GameProperty(String name, T value, Object source) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.value = Objects.requireNonNull(value, "value must not be null");
        this.source = Objects.requireNonNull(source, "source must not be null");
        this.initialValue = switch (value) {
            case List<?> list -> (T) List.copyOf(list);
            case Set<?> set -> (T) Set.copyOf(set);
            case Map<?, ?> map ->(T) Map.copyOf(map);
            default -> value;
        };
    }

    /**
     * Gets the current value of the property.
     * 
     * @return the current value of the property
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of the property. If the preconditions of all listeners are
     * met, the value is updated and the listeners are notified.
     * 
     * @param value the new value of the property
     * @throws NullPointerException if value is null
     */
    public void setValue(T value) {
        Objects.requireNonNull(value, "value must not be null");
        if (EventManager.in(this, value)) {
            T oldValue = this.value;
            this.value = value;
            EventManager.out(this, oldValue);
        }
    }

    /**
     * Gets the name of the property.
     * 
     * @return the name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the source object to which this property belongs.
     * 
     * @return the source object
     */
    public Object getSource() {
        return source;
    }

    /**
     * Resets the value of the property to its initial value.
     */
    public void reset() {
        setValue(initialValue);
    }

    /**
     * Gets the initial value of the property.
     * 
     * @return the initial value of the property
     */
    public T getInitialValue() {
        return initialValue;
    }

    @Override
    public String toString() {
        return "GameProperty<" + value.getClass().toString() + "> = " + value + " / " + initialValue;
    }
}
