package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {

    public static final int HEIGHT = 15;
    public static final int WIDTH = 15;

    protected final Main main;
    protected final List<Block> levelBlocks;

    protected List<Block> currentBlocks;

    protected final Location originalLocation;

    protected Location playerLocation;

    protected Level(Main main, List<Block> levelBlocks, Location playerLocation) {
        this.main = main;
        this.levelBlocks = levelBlocks;
        this.currentBlocks = new ArrayList<>(levelBlocks);
        this.originalLocation = new Location(playerLocation.getX(), playerLocation.getY());
        this.playerLocation = playerLocation;
    }

    public abstract Level nextLevel();

    public List<Block> getLevelBlocks() {
        return new ArrayList<>(levelBlocks);
    }

    public List<Block> getCurrentBlocks() {
        return currentBlocks;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public Location getLocationFrom(Location location, Direction direction) {
        switch (direction) {
            case UP:
                return new Location(location.getX(), location.getY() + 1);
            case DOWN:
                return new Location(location.getX(), location.getY() - 1);
            case LEFT:
                return new Location(location.getX() - 1, location.getY());
            case RIGHT:
                return new Location(location.getX() + 1, location.getY());
            default:
                return null;
        }
    }

    public Block getBlockAt(Location location) {
        return getCurrentBlocks().get(((14 - location.getY()) * 15) + location.getX());
    }

    public boolean movePlayer(Direction direction) {
        Location location = getLocationFrom(getPlayerLocation(), direction);
        Block locBlock = getBlockAt(location);
        if (locBlock instanceof WallBlock || locBlock instanceof VoidBlock) {
            return false;
        }
        if (locBlock instanceof BoxBlock || locBlock instanceof BoxFinishBlock) {
            Location nextTo = getLocationFrom(location, direction);
            Block nextBlock = getBlockAt(nextTo);
            if (nextBlock instanceof WallBlock || nextBlock instanceof VoidBlock) {
                return false;
            }
            if (nextBlock instanceof FinishBlock) {
                getCurrentBlocks().set(index(nextTo), new BoxFinishBlock());

                Block old = getLevelBlocks().get(index(location));
                if (old instanceof BoxBlock) {
                    getCurrentBlocks().set(index(location), new PathBlock());
                } else if (old instanceof BoxFinishBlock) {
                    getCurrentBlocks().set(index(location), new FinishBlock());
                } else {
                    getCurrentBlocks().set(index(location), getLevelBlocks().get(index(location)));
                }

//                getCurrentBlocks().set(index(location), getLevelBlocks().get(index(location)));
                getPlayerLocation().setX(location.getX());
                getPlayerLocation().setY(location.getY());
                return true;
            }
            if (nextBlock instanceof PathBlock) {
                getCurrentBlocks().set(index(nextTo), new BoxBlock());
                Block old = getLevelBlocks().get(index(location));
                if (old instanceof BoxBlock) {
                    getCurrentBlocks().set(index(location), new PathBlock());
                } else if (old instanceof BoxFinishBlock) {
                    getCurrentBlocks().set(index(location), new FinishBlock());
                } else {
                    getCurrentBlocks().set(index(location), getLevelBlocks().get(index(location)));
                }
                getPlayerLocation().setX(location.getX());
                getPlayerLocation().setY(location.getY());
                return true;
            }
            return false;
        }
        getPlayerLocation().setX(location.getX());
        getPlayerLocation().setY(location.getY());
        return true;
    }

    public boolean isFinished() {
        return currentBlocks.stream().filter(block -> block instanceof BoxBlock).count() == 0;
    }

    public void restart() {
        currentBlocks = new ArrayList<>(levelBlocks);
        playerLocation = new Location(originalLocation.getX(), originalLocation.getY());
    }

    public static int index(Location location) {
        return (((14 - location.getY()) * 15) + location.getX());
    }

}
