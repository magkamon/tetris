package com.epam.prejap.tetris.block;

/**
 *  It creates I block of tetrist
 *
 * @author Kanybek Mukalaev
 *
 * @see BlockFeed
 * @see Block
 *
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
