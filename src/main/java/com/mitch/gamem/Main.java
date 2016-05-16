package com.mitch.gamem;

import com.mitch.gamem.key.Key;
import com.mitch.gamem.key.KeyThread;
import com.mitch.gamem.level.Direction;
import com.mitch.gamem.level.Level;
import com.mitch.gamem.level.Level1;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.fusesource.jansi.Ansi.ansi;

public class Main {

    private static final String SEPARATOR = System.lineSeparator();

    // String that is built as 75 * \r\n - line break
    private static final String CLEAR = IntStream.range(1, 75).mapToObj(i -> SEPARATOR).collect(Collectors.joining());

    public static void main(String[] args) throws IOException {
        // Load colour API for console
        AnsiConsole.systemInstall();
        // Create new instance of Main class
        new Main();
    }

    // Whether the program is currently running
    private volatile boolean running = true;

    // Level counter shown next to controls
    private int level = 1;
    // The current level instance
    private Level currentLevel;

    // The list of keys to execute, added by KeyThread in separate Thread
    private Queue<Key> keyQueue = new ConcurrentLinkedQueue<>();

    // Main constructor, private as only constructed in main method
    private Main() {
        // Starting listening for keypresses in a separate Thread
        new KeyThread(this).start();

        // Set their current Level to Level1 to start
        currentLevel = new Level1(this);

        // Clear the screen
        clearScreen();
        // Tick program once, render the screen (true)
        tick(true);
        // Keep executing whilst program is running
        while (running) {
            // Tick program, only render screen if necessary (false)
            tick(false);
        }
    }

    /**
     * @param toRender Whether or not to force rendering the screen
     */
    private void tick(boolean toRender) {
        // Grab all keys that are currently in the keyQueue
        Key key;
        while ((key = keyQueue.poll()) != null) {
            // Execute onClick for the key, set toRender to true
            // if the key caused a change which needs to be rendered
            if (onClick(key)) {
                toRender = true;
            }
        }
        // If the level is finished
        if (currentLevel.isFinished()) {
            // Increment level counter to display next to controls
            level++;
            // Set the currentLevel to the next Level
            currentLevel = currentLevel.nextLevel();
            // If currentLevel is null, meaning there is no nextLevel
            if (currentLevel == null) {
                // Clear screen
                clearScreen();
                // Set running to false
                running = false;
                // Send congratulation message for winning
                System.out.println(ansi().fg(Ansi.Color.MAGENTA).a("Congratulations, you win!"));
                // Exit program
                System.exit(0);
                // Return from method
                return;
            }
            // There *is* a nextLevel, set toRender to true so screen will toRender
            toRender = true;
        }
        // If the toRender variable is true
        if (toRender) {
            // Call the render method
            render();
        }
    }

    private void render() {
        System.out.println(ansi().fg(Ansi.Color.MAGENTA).a("Controls: [ W A S D / ↑ ← ↓ → ] - Move. R - Restart. Q - quit. | Level: " + level));
        System.out.println(ansi().fg(Ansi.Color.BLACK).a("┌───────────────────────────────────────────────────────────────────────────┐"));
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < 15; row++) {
            builder.append("   ");
            for (int line = 1; line <= 3; line++) {
                System.out.print(ansi().fg(Ansi.Color.BLACK).a(builder.toString() + "│"));
                for (int column = 0; column < 15; column++) {
                    currentLevel.getCurrentBlocks().get((row * 15) + column).render(line, (currentLevel.getPlayerLocation().getX() == column && 14 - currentLevel.getPlayerLocation().getY() == row));
                }
                System.out.print(ansi().fg(Ansi.Color.BLACK).a("│" + SEPARATOR));
            }
        }
        System.out.println(ansi().fg(Ansi.Color.BLACK).a("└───────────────────────────────────────────────────────────────────────────┘"));
    }

    /**
     * @param key
     * @return whether to re-render
     */
    private boolean onClick(Key key) {
        // If the key is directional, i.e. up, down, left, right
        if (key.isDirectional()) {
            // Get the corresponding Direction for the key
            Direction direction = Direction.valueOf(key);
            // Return whether they moved, if true the screen will re-render
            return currentLevel.movePlayer(direction);
        }
        // If the key was R [Reset]
        if (key == Key.R) {
            // Clear the screen
            clearScreen();
            // Call restart method on currentLevel
            currentLevel.restart();
            // We *do* want to re-render so return true
            return true;
        }
        // If the key was Q [Quit]
        if (key == Key.Q) {
            // Clear the screen
            clearScreen();
            // Set running to false
            running = false;
            // Send thank you message
            System.out.println(ansi().fg(Ansi.Color.BLUE).a("Thanks for playing!"));
            // Print empty line for spacing
            System.out.println();
            // Exit program
            System.exit(0);
            // Return false to not re-render the level
            return false;
        }
        // This will only be reached if the key was unknown
        // Return false to not re-render
        return false;
    }

    // Method called by KeyThread to add keys to the keyQueue
    public synchronized void addToQueue(Key key) {
        // Offer [Add] the key to the keyQueue
        keyQueue.offer(key);
    }

    private void clearScreen() {
        // Print the CLEAR variable (75 * line break (\r\n))
        System.out.println(CLEAR);
    }

}
