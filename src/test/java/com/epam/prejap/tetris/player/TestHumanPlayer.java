package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;
import org.jnativehook.GlobalScreen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = {"HumanPlayer"})
public class TestHumanPlayer {


    @DataProvider
    public Object[][] provideKeysForMovement() {
        return new Object[][] {
                {' ', Move.NONE},
                {'h', Move.LEFT},
                {'l', Move.RIGHT},
                {'j', Move.TO_BOTTOM_NOW}
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
