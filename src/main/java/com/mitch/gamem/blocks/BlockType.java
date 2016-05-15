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
        // clazz = VoidBlock.class
    }

    public Block blockValue() {
        try {
            // Return new instance of clazz
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // This should never be called, but just in case
        return new VoidBlock();
    }

}
