package com.erumf.utils.log;

public class Logger {

    public static void info(String message) {
        System.out.println();
        printWithTag("[INFO]", message);
    }

    public static void warning(String message) {
        System.out.println();
        printWithTag("[WARNING]", message);
    }

    public static void error(String message) {
        System.out.println();
        printWithTag("[ERROR]", message);
    }

    private static void printWithTag(String tag, String message) {
        String[] lines = message.split("\n");
        for (String line : lines) {
            System.out.println(tag + " " + line);
        }
    }
}
