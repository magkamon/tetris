package com.epam.prejap.tetris.block;

final class UBlock extends Block {

    private static final byte[][] IMAGE = {
            {1, 0, 1},
            {1, 1, 1},
    };

    public UBlock() {
        super(IMAGE);
    }
}
