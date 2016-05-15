package com.mitch.gamem.blocks;

import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class BoxFinishBlock extends Block {

    public void render(int line, boolean player) {
        switch (line) {
            case 1:
                System.out.print(ansi().fg(RED).a("┏━━━┓"));
                break;
            case 2:
                System.out.print(ansi().fg(RED).a("┃ ╳ ┃"));
                break;
            case 3:
                System.out.print(ansi().fg(RED).a("┗━━━┛"));
                break;
        }
    }

}
