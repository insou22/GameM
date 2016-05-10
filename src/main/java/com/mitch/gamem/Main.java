package com.mitch.gamem;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean running = true;
        while (running) {
            System.out.println("Input: ");
            char input = (char) RawConsoleInput.read(true);
            if (Character.getNumericValue(input) == -1) {
                RawConsoleInput.read(false);
                input = (char) RawConsoleInput.read(false);
                if (Character.getNumericValue(input) == -1) {
                    running = false;
                } else {
                    System.out.println("Strange char - " + Character.getNumericValue(input) + ": " + input);
                }
            } else {
                System.out.println(Character.getNumericValue(input) + ": " + input);
            }
        }
    }



}
