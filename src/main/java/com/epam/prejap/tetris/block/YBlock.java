package com.epam.prejap.tetris.block;

/**
 * @author Anna Silenko
 *
 *Represents Y block in BlockFeed
 * @see BlockFeed
 *
 */
final class YBlock extends Block {

    private static final byte[][] IMAGE = {
            {1, 0, 1},
            {0, 1, 0},
            {0, 1, 0}
    };

    public YBlock() {
        super(IMAGE);
    }

}
