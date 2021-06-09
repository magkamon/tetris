package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/*
 * @author: Radosław Piwowarski
 */
@Test(groups = "Playfield")
public class TestPlayfield {

    /*
     * Check if after moving to the bottom, player can still move to left or right
     * Result should be false
     */
    public void TestMoveWithMoveToBottom() {
        var feed = new BlockFeed();
        var printer = new Printer(System.out);
        var playfield = new Playfield(10, 20, feed, printer);
        playfield.nextBlock();
        assertTrue(playfield.move(Move.TO_BOTTOM_NOW));
    }
}

