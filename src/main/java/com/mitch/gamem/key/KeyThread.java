package com.mitch.gamem.key;

import com.mitch.gamem.Main;

import java.io.IOException;

public class KeyThread extends Thread {

    // Instance of Main class, used to add keys to queue
    private final Main main;

    /**
     * @param main - instance of the Main class
     */
    public KeyThread(Main main) {
        this.main = main;
    }

    // What is run when the Thread starts
    @Override
    public void run() {
        // Infinite loop, okay to do because separate Thread
        while (true) {
            // Global try block in case of IOException, ignore exceptions
            try {
                // Get or wait for the next character-press
                char input = (char) RawConsoleInput.read(true);
                // Invalid key, means potential arrow key
                if (Character.getNumericValue(input) == -1) {
                    // Random ignored press, invalid key
                    RawConsoleInput.read(false);
                    // Input is now third key
                    input = (char) RawConsoleInput.read(false);
                    int id = Character.getNumericValue(input);
                    // Check for arrow keys against id
                    if (id == 10) {
                        main.addToQueue(Key.UP);
                        continue;
                    }
                    if (id == 11) {
                        main.addToQueue(Key.DOWN);
                        continue;
                    }
                    if (id == 12) {
                        main.addToQueue(Key.RIGHT);
                        continue;
                    }
                    if (id == 13) {
                        main.addToQueue(Key.LEFT);
                        continue;
                    }
                } else {
                    // Key was a normal press, check for potential characters
                    if (input == 'w' || input == 'W') {
                        main.addToQueue(Key.UP);
                        continue;
                    }
                    if (input == 'a' || input == 'A') {
                        main.addToQueue(Key.LEFT);
                        continue;
                    }
                    if (input == 's' || input == 'S') {
                        main.addToQueue(Key.DOWN);
                        continue;
                    }
                    if (input == 'd' || input == 'D') {
                        main.addToQueue(Key.RIGHT);
                        continue;
                    }
                    if (input == 'r' || input == 'R') {
                        main.addToQueue(Key.R);
                        continue;
                    }
                    if (input == 'z' || input == 'Z') {
                        main.addToQueue(Key.Z);
                        continue;
                    }
                    if (input == 'q' || input == 'Q') {
                        main.addToQueue(Key.Q);
                        continue;
                    }
                }
                // Ignore a potential IOException, as the key will be picked up next loop
            } catch (IOException ignored) {}
        }
    }

}
