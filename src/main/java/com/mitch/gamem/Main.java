package com.mitch.gamem;

import com.mitch.gamem.level.Direction;
import com.mitch.gamem.level.Level;
import com.mitch.gamem.level.Level1;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.ansi;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        AnsiConsole.systemInstall();
        new Main();
    }

    private volatile boolean running = true;

    private Level currentLevel = new Level1(this);

    private KeyThread keyThread;

    private Queue<Key> keyQueue = new ConcurrentLinkedDeque<>();

    private String clear;

    private Main() {
        StringBuilder clearBuilder = new StringBuilder();
        IntStream.range(1, 75).forEach(i -> clearBuilder.append("\r\n"));
        clear = clearBuilder.toString();
        keyThread = new KeyThread(this);
        keyThread.start();
        clearScreen();
        tick(true);
        while (running) {
            tick(false);
        }
    }

    private void tick(boolean update) {
        Key key;
        while ((key = keyQueue.poll()) != null) {
            if (onClick(key)) {
                update = true;
            }
        }
        if (currentLevel.isFinished()) {
            currentLevel = currentLevel.nextLevel();
            if (currentLevel == null) {
                clearScreen();
                System.out.println(ansi().fg(Ansi.Color.MAGENTA).a("Congratulations, you win!"));
                System.exit(0);
                return;
            }
        }
        if (update) {
            render();
        }
    }

    private void render() {
        System.out.println(ansi().fg(Ansi.Color.MAGENTA).a("Controls: [ W A S D / ↑ ← ↓ → ] - Move. R - Restart. Q - quit"));
        System.out.println(ansi().fg(Ansi.Color.BLACK).a("┌───────────────────────────────────────────────────────────────────────────┐"));
        for (int row = 0; row < 15; row++) {
            for (int line = 1; line <= 3; line++) {
                System.out.print(ansi().fg(Ansi.Color.BLACK).a("│"));
                for (int column = 0; column < 15; column++) {
                    currentLevel.getCurrentBlocks().get((row * 15) + column).render(line, (currentLevel.getPlayerLocation().getX() == column && 14 - currentLevel.getPlayerLocation().getY() == row));
                }
                System.out.print(ansi().fg(Ansi.Color.BLACK).a("│\n"));
            }
        }
        System.out.println(ansi().fg(Ansi.Color.BLACK).a("└───────────────────────────────────────────────────────────────────────────┘"));
    }

    /**
     * @param key
     * @return whether to re-render
     */
    private boolean onClick(Key key) {
        if (key.isDirectional()) {
            Direction direction = Direction.valueOf(key);
            return currentLevel.movePlayer(direction);
        }
        if (key == Key.R) {
            clearScreen();
            currentLevel.restart();
            return true;
        }
        if (key == Key.Q) {
            clearScreen();
            System.out.println(ansi().fg(Ansi.Color.BLUE).a("Thanks for playing!"));
            System.out.println();
            System.exit(0);
            return false;
        }
        return false;
    }

    public void addToQueue(Key key) {
        keyQueue.add(key);
    }

    private void clearScreen() {
        System.out.println(clear);
    }

}
