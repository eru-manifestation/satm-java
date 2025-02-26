package com.erumf.utils;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static <T> List<List<T>> getAllCombinations(List<T> elements) {
        List<List<T>> result = new ArrayList<>();
        generateCombinations(elements, 0, new ArrayList<>(), result);
        return result;
    }

    private static <T> void generateCombinations(List<T> elements, int index, List<T> current, List<List<T>> result) {
        if (index == elements.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element and move to the next
        generateCombinations(elements, index + 1, current, result);

        // Include the current element and move to the next
        current.add(elements.get(index));
        generateCombinations(elements, index + 1, current, result);

        // Backtrack to remove the current element
        current.remove(current.size() - 1);
    }

    /**
     * Generates all combinations of elements in the list, excluding the combination of all elements together.
     *
     * @param elements the list of elements to generate combinations from
     * @param <T>      the type of the elements
     * @return a list of combinations, excluding the combination of all elements together
     */
    public static <T> List<List<T>> getAllCombinationsExcludingAll(List<T> elements) {
        List<List<T>> result = new ArrayList<>();
        generateCombinationsExcludingAll(elements, 0, new ArrayList<>(), result);
        return result;
    }

    private static <T> void generateCombinationsExcludingAll(List<T> elements, int index, List<T> current, List<List<T>> result) {
        if (index == elements.size()) {
            if (current.size() != elements.size()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Exclude the current element and move to the next
        generateCombinationsExcludingAll(elements, index + 1, current, result);

        // Include the current element and move to the next
        current.add(elements.get(index));
        generateCombinationsExcludingAll(elements, index + 1, current, result);

        // Backtrack to remove the current element
        current.remove(current.size() - 1);
    }
}