package com.epam.prejap.tetris.block;

/**
 * @author Kanybek Mukalaev
 * @see BlockFeed
 *
 */
class IBlock extends Block {
    public static final byte [][] image = {
            {1},
            {1},
            {1},
            {1},
    };
    public IBlock(){
        super(image);
    }
}
