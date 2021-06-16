package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = {"blockShapes"})
public class UBlockTest {

    UBlock uBlock = new UBlock();

    @Test
    public void shouldUBlockContainTwoRows() {
        int allUBlockRows = uBlock.rows();
        int rows2 = 2;
        assertEquals(allUBlockRows, rows2, "Number of rows is incorrect, it should be: " + rows2 + " when actual is: " + allUBlockRows);
    }

    @Test
    public void shouldUBlockContainThreeCols() {
        int allUBlockCols = uBlock.cols();
        int cols3 = 3;
        assertEquals(allUBlockCols, cols3, "Number of cols is incorrect, it should be: " + cols3 + " when actual is: " + allUBlockCols);
    }

    @Test(dataProvider = "dotsPlacement")
    public void shouldReturnCorrectDotPlace(int row, int col, int expectedDotPlacement, String message) {
        int uBlockDotPlacement = uBlock.dotAt(row, col);
        assertEquals(uBlockDotPlacement, expectedDotPlacement, message);
    }

    @DataProvider
    public static Object[][] dotsPlacement() {
        return new Object[][]{
                {0, 0, 1, "Incorrect dotAt(0,0)"},
                {0, 1, 0, "Incorrect dotAt(0,1)"},
                {0, 2, 1, "Incorrect dotAt(0,2)"},
                {1, 0, 1, "Incorrect dotAt(1,0)"},
                {1, 1, 1, "Incorrect dotAt(1,1)"},
                {1, 2, 1, "Incorrect dotAt(1,2)"},
        };
    }
}
