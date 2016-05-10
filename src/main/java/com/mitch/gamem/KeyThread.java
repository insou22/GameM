package com.mitch.gamem;

import java.io.IOException;

public class KeyThread extends Thread {

    private final Main main;

    public KeyThread(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        while (true) {
            try {
                char input = (char) RawConsoleInput.read(true);
                if (Character.getNumericValue(input) == -1) {
                    Character.getNumericValue(RawConsoleInput.read(false));
                    input = (char) RawConsoleInput.read(false);
                    int id = Character.getNumericValue(input);
                    if (id == 10) {
                        main.addToQueue(Key.UP);
                        continue;
                    }
                    if (id == 11) {
                        main.addToQueue(Key.DOWN);
                        continue;
                    }
                    if (id == 13) {
                        main.addToQueue(Key.LEFT);
                        continue;
                    }
                    if (id == 12) {
                        main.addToQueue(Key.RIGHT);
                        continue;
                    }
                } else {
                    int id = Character.getNumericValue(input);
                    if (input == 'w') {
                        main.addToQueue(Key.UP);
                        continue;
                    }
                    if (input == 'a') {
                        main.addToQueue(Key.LEFT);
                        continue;
                    }
                    if (input == 's') {
                        main.addToQueue(Key.DOWN);
                        continue;
                    }
                    if (input == 'd') {
                        main.addToQueue(Key.RIGHT);
                        continue;
                    }
                    if (input == 'r') {
                        main.addToQueue(Key.R);
                        continue;
                    }
                    if (input == 'z') {
                        main.addToQueue(Key.Z);
                        continue;
                    }
                    if (input == 'q') {
                        main.addToQueue(Key.Q);
                        continue;
                    }
                }
            } catch (IOException ignored) {}
        }
    }

}
