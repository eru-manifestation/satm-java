package com.erumf.utils.cli;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.jgrapht.alg.util.Pair;

import com.erumf.utils.position.Card;

public class ConsoleUtils {

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

    public static <T extends Card, U extends Card> Pair<T, U> chooseAction(String message, List<Pair<T, U>> actions) {
        List<String> options = actions.stream()
                .map(action -> action.getFirst().getClass().getSimpleName() + " -> " + action.getSecond().getClass().getSimpleName())
                .collect(Collectors.toList());
        String choice = chooseFrom(message, options);
        return actions.get(options.indexOf(choice));
    }
}
