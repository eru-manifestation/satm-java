package com.erumf.utils;

import java.util.Objects;

import com.erumf.events.EventManager;

/**
 * Represents a piece of mutable game data. Changes to this property must trigger
 * precondition checking for all listeners available.
 * 
 * @param <T> the type of the property's value
 */
public class GameProperty<T> {
    private T value;
    private final String name;
    private final Object source;

    /**
     * Constructs a new GameProperty with the specified name, initial value, and source.
     * 
     * @param name  the name of the property, which must be the name of the variable
     *              of the object to which it belongs
     * @param value the initial value of the property
     * @param source the source object to which this property belongs
     * @throws NullPointerException if name or source is null
     */
    public GameProperty(String name, T value, Object source) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.value = value;
        this.source = Objects.requireNonNull(source, "source must not be null");
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
     */
    public void setValue(T value) {
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

    @Override
    public String toString() {
        return "GameProperty<" + value.getClass().toString() + "> = " + value + "";
    }
}
