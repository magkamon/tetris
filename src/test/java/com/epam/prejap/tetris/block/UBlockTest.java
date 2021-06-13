package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = {"blockShapes"})
public class UBlockTest {

    UBlock uBlock = new UBlock();

    @Test
    public void shouldUBlockContainTwoRows() {
        int actualRows = uBlock.rows();
        int expectedRows = 2;
        assertEquals(actualRows, expectedRows, "Number of rows is incorrect, it should be: " + expectedRows + " when actual is: " + actualRows);
    }

    @Test
    public void shouldUBlockContainThreeCols() {
        int actualCols = uBlock.cols();
        int expectedCols = 3;
        assertEquals(actualCols, expectedCols, "Number of cols is incorrect, it should be: " + expectedCols + " when actual is: " + actualCols);
    }

    @Test(dataProvider = "dotsPlacement")
    public void shouldReturnCorrectDotPlace(int row, int cols, int expected, String message) {
        int actual = uBlock.dotAt(row, cols);
        assertEquals(actual, expected, message);
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
