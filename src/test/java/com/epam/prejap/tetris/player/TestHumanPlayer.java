package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TestHumanPlayer {


    @DataProvider
    public Object[][] provideKeysForMovement() {
        return new Object[][] {
                {' ', Move.NONE},
                {'h', Move.LEFT},
                {'l', Move.RIGHT},
                {NativeKeyEvent.VC_DOWN, Move.TO_BOTTOM_NOW}
        };
    }

    @Test(dataProvider = "provideKeysForMovement")
    public void testIfKeysNumbersResultsWithProperMovements (int key, Move movement) {
        assertEquals(new HumanPlayer().mapMoveToKey(key), movement);
    }

    public void testHumanPlayerRegisterHook () {
        var human = new HumanPlayer();
        assertTrue(GlobalScreen.isNativeHookRegistered());
    }

    public void testKillHumanPlayerUnregisterHook () {
        var human = new HumanPlayer();
        human.killHumanPlayer();
        assertFalse(GlobalScreen.isNativeHookRegistered());
    }
}