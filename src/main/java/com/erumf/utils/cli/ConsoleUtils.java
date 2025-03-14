package com.erumf.utils.cli;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jgrapht.alg.util.Pair;

import com.erumf.utils.position.Card;

/**
 * The ConsoleUtils class provides utility methods for interacting with the console.
 * It includes methods for displaying options to the user and allowing them to make a choice.
 */
public class ConsoleUtils {

    /**
     * Displays a list of options to the user and prompts them to make a choice.
     *
     * @param message the message to display to the user
     * @param options the list of options to choose from
     * @return the chosen option
     */
    public static String chooseFrom(String message, List<String> options) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = -1;

            while (choice < 0 || choice >= options.size()) {
                System.out.println(message);
                for (int i = 0; i < options.size(); i++) {
                    System.out.println(i + ": " + options.get(i));
                }

                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    scanner.next(); // consume invalid input
                }
            }

            return options.get(choice);
        } catch (Exception e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
            return null;
        }
    }

    /**
     * Displays a list of options to the user and prompts them to choose one or do nothing.
     *
     * @param message the message to display to the user
     * @param options the list of options to choose from
     * @return the chosen option or null if the user chooses to do nothing
     */
    public static String chooseFromOptional(String message, List<String> options) {
        options.add("Do nothing");
        return chooseFrom(message, options);
    }

    /**
     * Displays a list of actions to the user and prompts them to choose one.
     *
     * @param message the message to display to the user
     * @param actions the list of actions to choose from
     * @param <T>     the type of the first element in the pair
     * @param <U>     the type of the second element in the pair
     * @return the chosen action
     */
    public static <T, U extends Card> Pair<T, U> chooseAction(String message, List<Pair<T, U>> actions) {
        List<String> options = actions.stream()
                .map(action -> action.getFirst().getClass().getSimpleName() + " -> " + action.getSecond().getClass().getSimpleName())
                .collect(Collectors.toList());
        options.add("Do nothing");
        String choice = chooseFrom(message, options);
        Integer indexChoice = options.indexOf(choice);
        return indexChoice == options.size()-1 ? null : actions.get(indexChoice);
    }

    /**
     * Displays a list of actions to the user and prompts them to choose one or do nothing.
     *
     * @param message the message to display to the user
     * @param actions the list of actions to choose from
     * @param <T>     the type of the first element in the pair
     * @param <U>     the type of the second element in the pair
     * @return the chosen action or null if the user chooses to do nothing
     */
    public static <T, U extends Card> Pair<T, U> chooseActionNoForced(String message, List<Pair<T, U>> actions) {
        List<String> options = actions.stream()
                .map(action -> action.getFirst().getClass().getSimpleName() + " -> " + action.getSecond().getClass().getSimpleName())
                .collect(Collectors.toList());
        options.add("Do nothing");
        String choice = chooseFrom(message, options);
        Integer indexChoice = options.indexOf(choice);
        return indexChoice == options.size()-1 ? null : actions.get(indexChoice);
    }

    /**
     * Prompts the user to confirm an action with a yes or no response.
     *
     * @param message the message to display to the user
     * @return true if the user confirms the action, false otherwise
     */
    public static boolean confirmAction(String message) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = "";
            while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.print(message + " (y/n): ");
                choice = scanner.next();
            }
            return choice.equalsIgnoreCase("y");
        } catch (Exception e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
            return false;
        }
    }

    /**
     * Displays a list of elements to the user and prompts them to choose one.
     *
     * @param message  the message to display to the user
     * @param elements the list of elements to choose from
     * @param toString the function to convert an element to a string
     * @param <T>      the type of the elements
     * @return the chosen element
     */
    public static <T> T chooseElement(String message, List<T> elements, Function<T, String> toString) {
        List<String> options = elements.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        String choice = chooseFrom(message, options);
        Integer indexChoice = options.indexOf(choice);
        return elements.get(indexChoice);
    }

    /**
     * Displays a list of elements to the user and prompts them to choose one.
     *
     * @param message  the message to display to the user
     * @param elements the list of elements to choose from
     * @param toString the function to convert an element to a string
     * @param <T>      the type of the elements
     * @return the chosen element
     */
    public static <T> T chooseElementOptional(String message, List<T> elements, Function<T, String> toString) {
        List<String> options = elements.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        String choice = chooseFromOptional(message, options);
        Integer indexChoice = options.indexOf(choice);
        return elements.get(indexChoice);
    }
}
