package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.Block;
import com.mitch.gamem.blocks.BlockType;
import static com.mitch.gamem.blocks.BlockType.*;
import com.mitch.gamem.blocks.VoidBlock;
import com.mitch.gamem.blocks.WallBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 extends Level {

    public Level1(Main main) {
        super(
                main,
                new ArrayList<>(
                    Arrays.asList(
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,

                            V,V,V, V,V,W,W,W,V,V,V, V,V,V,V,
                            V,V,V, V,V,W,F,W,V,V,V, V,V,V,V,
                            V,V,V, V,V,W,P,W,W,W,W, V,V,V,V,
                            V,V,V, W,W,W,B,P,B,F,W, V,V,V,V,
                            V,V,V, W,F,P,B,P,W,W,W, V,V,V,V,
                            V,V,V, W,W,W,W,B,W,V,V, V,V,V,V,
                            V,V,V, V,V,V,W,F,W,V,V, V,V,V,V,
                            V,V,V, V,V,V,W,W,W,V,V, V,V,V,V,

                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                            V,V,V, V,V,V,V,V,V,V,V, V,V,V,V
                    ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(7, 7)
        );
    }

    @Override
    public Level nextLevel() {
        return new Level2(main);
    }

}
