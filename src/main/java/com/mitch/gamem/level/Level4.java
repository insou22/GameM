package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.mitch.gamem.blocks.BlockType.*;

public class Level4 extends Level {

    public Level4(Main main) {
        super(
                main,
                new ArrayList<>(
                        Arrays.asList(
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,

                                V,V,V,V, V,W,W,W,W,V, V,V,V,V,V,
                                V,V,V,V, W,W,P,P,W,V, V,V,V,V,V,
                                V,V,V,V, W,P,B,P,W,V, V,V,V,V,V,
                                V,V,V,V, W,W,B,P,W,W, V,V,V,V,V,
                                V,V,V,V, W,W,P,B,P,W, V,V,V,V,V,
                                V,V,V,V, W,F,B,P,P,W, V,V,V,V,V,
                                V,V,V,V, W,F,F,X,F,W, V,V,V,V,V,
                                V,V,V,V, W,W,W,W,W,W, V,V,V,V,V,

                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V,
                                V,V,V,V, V,V,V,V,V,V, V,V,V,V,V
                        ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(5, 9)
        );
    }

    @Override
    public Level nextLevel() {
        return new Level5(main);
    }

}
