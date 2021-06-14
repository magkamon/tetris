package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author Kanybek Mukalaev
 *
 */

@Test(groups = {"blockShapes"})
public class IBlockTest {
    IBlock b;
    @DataProvider()
    public static Object[][] IBlock() {
        byte[][] IBlock = {
                {1},
                {1},
                {1},
                {1},
        };
        return new Object[][] {IBlock};
    }
    @Test(dataProvider = "IBlock")
    public void checkIBlockShapeOfTetris(byte[][] expectedResult){
        byte [][] actualResult = IBlock.image;
        assertEquals(actualResult, expectedResult);
    }
    public void checkRowOfIBlock(){
        b = new IBlock();
        int actualResult = b.rows();
        int expectedResult = 4;
        assertEquals(actualResult, expectedResult, "We expected 4, but get " + actualResult);
    }
    public void checkColumnOfIBlock(){
        b = new IBlock();
        int actualResult = b.cols();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult, "We expected 1, but get " + actualResult);
    }
    @Test(dataProvider = "checkDotAtIBlock")
    public void checkDotAtOfIBlock(int i, int j, int expectedResult){
        b = new IBlock();
        int actualResult = b.dotAt(i, j);
        assertEquals(actualResult, expectedResult);
    }
    @DataProvider()
    public static Object[][] checkDotAtIBlock(){
        return new Object[][]{
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1}
        };
    }
}
