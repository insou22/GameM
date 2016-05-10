package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.Block;
import com.mitch.gamem.blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.mitch.gamem.blocks.BlockType.*;
import static com.mitch.gamem.blocks.BlockType.V;
import static com.mitch.gamem.blocks.BlockType.W;

public class Level2 extends Level {

    public Level2(Main main) {
        super(
                main,
                new ArrayList<>(
                        Arrays.asList(
                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V,

                                V,V,V, W,W,W,W,W,V,V,V,V, V,V,V,
                                V,V,V, W,P,P,P,W,V,V,V,V, V,V,V,
                                V,V,V, W,P,B,B,W,V,W,W,W, W,V,V,
                                V,V,V, W,P,B,P,W,V,W,F,W, V,V,V,
                                V,V,V, W,W,W,P,W,W,W,F,W, V,V,V,
                                V,V,V, V,W,W,P,P,P,P,F,W, V,V,V,
                                V,V,V, V,W,P,P,P,W,P,P,W, V,V,V,
                                V,V,V, V,W,P,P,P,W,W,W,W, V,V,V,
                                V,V,V, V,W,W,W,W,W,V,V,V, V,V,V,

                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V,V, V,V,V
                        ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(4, 10)
        );
    }

    @Override
    public Level nextLevel() {
        return null;
    }

}
