package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.mitch.gamem.blocks.BlockType.*;

public class Level6 extends Level {

    public Level6(Main main) {
        super(
                main,
                new ArrayList<>(
                        Arrays.asList(
                                V, V,V,V,V,V,V,V,V,V,V,V,V,V, V,
                                V, V,V,V,V,V,V,V,V,V,V,V,V,V, V,

                                V, V,V,V,W,W,W,W,W,W,W,V,V,V, V,
                                V, W,W,W,W,P,P,P,P,P,W,V,V,V, V,
                                V, W,P,P,P,F,W,W,W,P,W,V,V,V, V,
                                V, W,P,W,P,W,P,P,P,P,W,W,V,V, V,
                                V, W,P,W,P,B,P,B,W,F,P,W,V,V, V,
                                V, W,P,W,P,P,X,P,P,W,P,W,V,V, V,
                                V, W,P,F,W,B,P,B,P,W,P,W,V,V, V,
                                V, W,W,P,P,P,P,W,P,W,P,W,W,W, V,
                                V, V,W,P,W,W,W,F,P,P,P,P,P,W, V,
                                V, V,W,P,P,P,P,P,W,W,P,P,P,W, V,
                                V, V,W,W,W,W,W,W,W,W,W,W,W,W, V,

                                V, V,V,V,V,V,V,V,V,V,V,V,V,V, V,
                                V, V,V,V,V,V,V,V,V,V,V,V,V,V, V
                        ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(12, 4)
        );
    }

    @Override
    public Level nextLevel() {
        return null;
    }

}
