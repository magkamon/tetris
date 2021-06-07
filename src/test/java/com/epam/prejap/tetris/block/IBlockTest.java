package com.epam.prejap.tetris.block;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kanybek Mukalaev
 * This class methods of IBlock.
 */
@Test
public class IBlockTest {
    IBlock b = new IBlock();
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
    public void checkBlockIOfTetris(byte[][] expectedResult){
        byte [][] actualResult = IBlock.image;
        Assert.assertEquals(actualResult, expectedResult);
    }
    public void checkRowOfIBlock(){
        int actualResult = b.rows();
        int expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult, "We check here I block and row is more than 3");
    }
    public void checkColumnOfIBlock(){
        int actualResult = b.cols();
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult, "We check here I block column and it is less than 3");
    }
    @Test(dataProvider = "checkDotAtIBlock")
    public void checkDotAtOfIBlock(int i, int j, int expectedResult){
        int actualResult = b.dotAt(i, j);
        Assert.assertEquals(actualResult, expectedResult);
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
