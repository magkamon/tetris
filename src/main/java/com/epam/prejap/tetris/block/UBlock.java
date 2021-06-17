package com.epam.prejap.tetris.block;

/**
 * The UBlock class stands for "U" Block in Tetris game
 *
 * @author Magdalena Kamoń
 * @see BlockFeed
 */

final class UBlock extends Block {

    private static final byte[][] IMAGE = {
            {1, 0, 1},
            {1, 1, 1},
    };

    public UBlock() {
        super(IMAGE);
    }
}
