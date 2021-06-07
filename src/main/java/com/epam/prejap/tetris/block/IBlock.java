package com.epam.prejap.tetris.block;

/**
 * @author Kanybek Mukalaev
 * @see BlockFeed
 * @see Block
 * @see com.epam.prejap.tetris.game.Printer
 * It creates I block of tetris
 *
 */
class IBlock extends Block {
    static final byte [][] image = {
            {1},
            {1},
            {1},
            {1},
    };
    public IBlock(){
        super(image);
    }
}
