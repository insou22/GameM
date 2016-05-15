package com.mitch.gamem.blocks;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class VoidBlock extends Block {

    public void render(int line, boolean player) {
        System.out.print(ansi().fg(BLACK).a("     "));
    }

}
