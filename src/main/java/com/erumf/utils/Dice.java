package com.erumf.utils;

public class Dice {

    public static Integer roll() {
        return (int) (Math.random() * 6) + (int) (Math.random() * 6) + 2;
    }

}
