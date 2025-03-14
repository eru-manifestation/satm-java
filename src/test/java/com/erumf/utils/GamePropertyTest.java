package com.erumf.utils;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GamePropertyTest {

    @Test
    public void testConstructorWithValidParameters() {
        String name = "testProperty";
        String value = "initialValue";
        Object source = new Object();

        GameProperty<String> property = new GameProperty<>(name, value, source);

        assertEquals(name, property.getName());
        assertEquals(value, property.getValue());
        assertEquals(source, property.getSource());
        assertEquals(value, property.getInitialValue());
    }

    @Test
    public void testConstructorWithNullName() {
        String value = "initialValue";
        Object source = new Object();

        assertThrows(NullPointerException.class, () -> {
            new GameProperty<>(null, value, source);
        });
    }

    @Test
    public void testConstructorWithNullValue() {
        String name = "testProperty";
        Object source = new Object();

        assertThrows(NullPointerException.class, () -> {
            new GameProperty<>(name, null, source);
        });
    }

    @Test
    public void testConstructorWithNullSource() {
        String name = "testProperty";
        String value = "initialValue";

        assertThrows(NullPointerException.class, () -> {
            new GameProperty<>(name, value, null);
        });
    }

    @Test
    public void testInitialValueWithList() {
        String name = "testProperty";
        List<String> value = List.of("item1", "item2");
        Object source = new Object();

        GameProperty<List<String>> property = new GameProperty<>(name, value, source);

        assertEquals(value, property.getValue());
        assertEquals(value, property.getInitialValue());
    }

    @Test
    public void testInitialValueWithSet() {
        String name = "testProperty";
        Set<String> value = Set.of("item1", "item2");
        Object source = new Object();

        GameProperty<Set<String>> property = new GameProperty<>(name, value, source);

        assertEquals(value, property.getValue());
        assertEquals(value, property.getInitialValue());
    }

    @Test
    public void testInitialValueWithMap() {
        String name = "testProperty";
        Map<String, String> value = Map.of("key1", "value1", "key2", "value2");
        Object source = new Object();

        GameProperty<Map<String, String>> property = new GameProperty<>(name, value, source);

        assertEquals(value, property.getValue());
        assertEquals(value, property.getInitialValue());
    }
}