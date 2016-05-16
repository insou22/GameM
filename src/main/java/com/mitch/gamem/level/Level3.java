package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.mitch.gamem.blocks.BlockType.*;

public class Level3 extends Level {

    public Level3(Main main) {
        super(
                main,
                new ArrayList<>(
                        Arrays.asList(
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,

                                V,V, V,W,W,W,W,W,W,W,V,V, V,V,V,
                                V,V, V,W,P,P,P,P,P,W,W,W, V,V,V,
                                V,V, W,W,B,W,W,W,P,P,P,W, V,V,V,
                                V,V, W,P,P,P,B,P,P,B,P,W, V,V,V,
                                V,V, W,P,F,F,W,P,B,P,W,W, V,V,V,
                                V,V, W,W,F,F,W,P,P,P,W,V, V,V,V,
                                V,V, V,W,W,W,W,W,W,W,W,V, V,V,V,

                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V,
                                V,V, V,V,V,V,V,V,V,V,V,V, V,V,V
                        ).stream().map(BlockType::blockValue).collect(Collectors.toList())
                ),
                new Location(4, 7)
        );
    }

    @Override
    public Level nextLevel() {
        return new Level4(main);
    }

}
