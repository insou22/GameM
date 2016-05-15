package com.mitch.gamem.blocks;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class PathBlock extends Block {

    public void render(int line, boolean player) {
        if (player) {
            switch (line) {
                case 1:
                    System.out.print(ansi().fg(GREEN).a("┏━━━┓"));
                    break;
                case 2:
                    System.out.print(ansi().fg(GREEN).a("┃").fg(MAGENTA).a("ʘ‿ʘ").fg(GREEN).a("┃"));
                    break;
                case 3:
                    System.out.print(ansi().fg(GREEN).a("┗━━━┛"));
                    break;
            }
        } else {
            switch (line) {
                case 1:
                    System.out.print(ansi().fg(GREEN).a("┏━━━┓"));
                    break;
                case 2:
                    System.out.print(ansi().fg(GREEN).a("┃   ┃"));
                    break;
                case 3:
                    System.out.print(ansi().fg(GREEN).a("┗━━━┛"));
                    break;
            }
        }
    }

}
