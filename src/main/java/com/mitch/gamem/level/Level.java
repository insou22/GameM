package com.mitch.gamem.level;

import com.mitch.gamem.Main;
import com.mitch.gamem.blocks.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {

    protected final Main main;

    private final List<Block> levelBlocks;
    private List<Block> currentBlocks;

    private final Location originalLocation;
    private Location playerLocation;

    protected Level(Main main, List<Block> levelBlocks, Location playerLocation) {
        this.main = main;
        this.levelBlocks = levelBlocks;
        this.currentBlocks = new ArrayList<>(levelBlocks);
        this.originalLocation = new Location(playerLocation.getX(), playerLocation.getY());
        this.playerLocation = playerLocation;
    }

    public abstract Level nextLevel();

    private List<Block> getLevelBlocks() {
        return new ArrayList<>(levelBlocks);
    }

    public List<Block> getCurrentBlocks() {
        return currentBlocks;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    private Location getLocationFrom(Location location, Direction direction) {
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

    private Block getBlockAt(Location location) {
        return getCurrentBlocks().get(index(location));
    }

    /**
     *
     * @param direction
     * @return Whether the player moved location
     */
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

    private static int index(Location location) {
        return (((14 - location.getY()) * 15) + location.getX());
    }

}
