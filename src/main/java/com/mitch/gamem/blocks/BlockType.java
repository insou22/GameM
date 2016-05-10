package com.mitch.gamem.blocks;

import java.lang.reflect.InvocationTargetException;

public enum BlockType {

    V(VoidBlock.class),
    W(WallBlock.class),
    P(PathBlock.class),
    B(BoxBlock.class),
    F(FinishBlock.class),
    X(BoxFinishBlock.class);

    private Class<? extends Block> clazz;

    BlockType(Class<? extends Block> clazz) {
        this.clazz = clazz;
    }

    public Block blockValue() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return new VoidBlock();
    }

}
