package com.epam.prejap.tetris.block;

/**
 * Stands for "U" Block in Tetris game
 * @author Magdalena Kamoń
 */
final class UBlock extends Block {

    /**
     * Byte array represents "U" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *      # #
     *      ###
     *  -------------------
     */
    private static final byte[][] IMAGE = {
            {1, 0, 1},
            {1, 1, 1},
    };

    public UBlock() {
        super(IMAGE);
    }
}
