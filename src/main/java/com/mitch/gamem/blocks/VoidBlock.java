package com.mitch.gamem.blocks;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class VoidBlock extends Block {

    public void render(int line, boolean player) {
        switch (line) {
            case 1:
                System.out.print(ansi().fg(BLACK).a("     "));
                break;
            case 2:
                System.out.print(ansi().fg(BLACK).a("     "));
                break;
            case 3:
                System.out.print(ansi().fg(BLACK).a("     "));
                break;
            /*case 1:
                System.out.print(ansi().fg(BLACK).a("┏━━━┓"));
                break;
            case 2:
                System.out.print(ansi().fg(BLACK).a("┃   ┃"));
                break;
            case 3:
                System.out.print(ansi().fg(BLACK).a("┗━━━┛"));
                break;*/
        }
    }

}
