package com.mitch.gamem.blocks;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class FinishBlock extends Block {

    public void render(int line, boolean player) {
        if (player) {
            switch (line) {
                case 1:
                    System.out.print(ansi().fg(BLUE).a("┏━━━┓"));
                    break;
//            case 2:
//                System.out.print(ansi().fg(YELLOW).a("┃╲ ╱┃"));
//                break;
                case 2:
                    System.out.print(ansi().fg(BLUE).a("┃").fg(MAGENTA).a("ʘ‿ʘ").fg(BLUE).a("┃"));
                    break;
//            case 4:
//                System.out.print(ansi().fg(YELLOW).a("┃╱ ╲┃"));
//                break;
                case 3:
                    System.out.print(ansi().fg(BLUE).a("┗━━━┛"));
                    break;
            }
        } else {
            switch (line) {
                case 1:
                    System.out.print(ansi().fg(BLUE).a("┏━━━┓"));
                    break;
//            case 2:
//                System.out.print(ansi().fg(YELLOW).a("┃╲ ╱┃"));
//                break;
                case 2:
                    System.out.print(ansi().fg(BLUE).a("┃ 0 ┃"));
                    break;
//            case 4:
//                System.out.print(ansi().fg(YELLOW).a("┃╱ ╲┃"));
//                break;
                case 3:
                    System.out.print(ansi().fg(BLUE).a("┗━━━┛"));
                    break;
            }
        }
    }

}
