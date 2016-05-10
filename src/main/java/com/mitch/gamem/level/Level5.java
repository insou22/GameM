package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.mitch.gamem.blocks.BlockType.*;
import static com.mitch.gamem.blocks.BlockType.V;
import static com.mitch.gamem.blocks.BlockType.W;

public class Level5 extends Level {

    public Level5(Main main) {
        super(
                main,
                new ArrayList<>(
                        Arrays.asList(
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,

                                V,V,V, V,W,W,W,W,W,V,V, V,V,V,V,
                                V,V,V, V,W,P,P,W,W,W,V, V,V,V,V,
                                V,V,V, V,W,P,B,P,P,W,V, V,V,V,V,
                                V,V,V, W,W,W,P,W,P,W,W, V,V,V,V,
                                V,V,V, W,F,W,P,W,P,P,W, V,V,V,V,
                                V,V,V, W,F,B,P,P,W,P,W, V,V,V,V,
                                V,V,V, W,F,P,P,P,B,P,W, V,V,V,V,
                                V,V,V, W,W,W,W,W,W,W,W, V,V,V,V,

                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V,
                                V,V,V, V,V,V,V,V,V,V,V, V,V,V,V
                        ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(5, 9)
        );
    }

    @Override
    public Level nextLevel() {
        return new Level6(main);
    }

}
