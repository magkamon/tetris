package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/*
 * @author: Radosław Piwowarski
 */
@Test(groups = {"Playfield"})
public class TestPlayfield {

    /*
     * Check if after moving to the bottom player can still move to left or right
     * Result should be false
     */
    BlockFeed feed;
    Printer printer;
    Playfield playfield;

    @BeforeMethod
    public void initializePlayfield() {
        feed = new BlockFeed();
        printer = new Printer(System.out);
        playfield = new Playfield(10, 20, feed, printer);
    }

    @DataProvider
    public Object[][] provideNumberOfMovesAndExceptedResults() {
        return new Object[][]
                {
                        {1, true, Move.RIGHT},
                        {2, true, Move.RIGHT},
                        {5, true, Move.RIGHT},
                        {8, true, Move.RIGHT},
                        {9, false, Move.RIGHT},
                        {1, true, Move.LEFT},
                        {2, true, Move.LEFT},
                        {5, true, Move.LEFT},
                        {8, true, Move.LEFT},
                        {9, false, Move.LEFT},
                };
    }

    /*
     * Tests if calling moving methods let us move the block.
     * Direct call to move block after it touches the wall causes IndexOutOfBoundsException
     * Direct position checking is not possible, grid is private.
     */
    @Test(dataProvider = "provideNumberOfMovesAndExceptedResults")
    public void testMoveLeftSide(int move, boolean endEffect, Move side) throws IndexOutOfBoundsException {
        playfield.nextBlock();
        boolean moved = false;
        for (int i = 0; i < move; i++) {
            moved = playfield.move(side);
        }
        assertEquals(moved, endEffect);
    }

    public void testMoveWithMoveToBottom() {
        playfield.nextBlock();
        assertFalse(playfield.move(Move.TO_BOTTOM_NOW));
    }

}

