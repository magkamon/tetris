package com.epam.prejap.tetris.game;

import org.jnativehook.keyboard.NativeKeyEvent;

public enum Move {

    NONE(' '),
    LEFT('h'),
    RIGHT('l'),
    /*
     * Arrow key down
     */
    TO_BOTTOM_NOW(NativeKeyEvent.VC_DOWN)
    ;

    private final int key;

    Move(int key) {
        this.key = key;
    }

    public static Move of(int key) {
        for (var move : values()) {
            if (move.key == key) {
                return move;
            }
        }
        return NONE;
    }
}
