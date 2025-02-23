package com.erumf.utils;

import java.util.ArrayList;

import com.erumf.Basic;

public class Deck extends ArrayList<Basic> {

    public <T> T findFirstOf(Class<T> clazz) {
        return this.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }
}
