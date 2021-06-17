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

    public void checkRowOfIBlock(){
        IBlock b = new IBlock();
        int actualResult = b.rows();
        int expectedResult = 4;
        assertEquals(actualResult, expectedResult,
                String.format("We expected %d, but get %d",expectedResult, actualResult));
    }
    public void checkColumnOfIBlock(){
        IBlock b  = new IBlock();
        int actualResult = b.cols();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult,
                String.format("We expected %d, but get %d",expectedResult, actualResult));
    }
    @Test(dataProvider = "checkDotAtIBlock")
    public void checkDotAtOfIBlock(int i, int j, int expectedResult){
        IBlock b  = new IBlock();
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
