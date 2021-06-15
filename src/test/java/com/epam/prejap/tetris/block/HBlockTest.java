package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = {"blockShapes"})
public class HBlockTest {

    HBlock hBlock = new HBlock();

    public void rows_ShouldReturn3() {
        int expected = 3;
        int actual = hBlock.rows();
        assertEquals(actual, expected,
                String.format("Number of rows is incorrect.%nExpected: %d, actual: %d", expected, actual));
    }

    public void cols_shouldReturn3() {
        int expected = 3;
        int actual = hBlock.cols();
        assertEquals(actual, expected,
                String.format("Number of cols is incorrect.%nExpected: %d, actual: %d", expected, actual));
    }

    @Test(dataProvider = "dotsPositions")
    public void dotAtShouldReturnCorrectValue(int row, int col, int expected, String message) {
        int actual = hBlock.dotAt(row, col);
        assertEquals(actual, expected, message);
    }

    @DataProvider
    public static Object[][] dotsPositions() {
        return new Object[][]{
                {0, 0, 1, "Incorrect dotAt(0, 0)"},
                {0, 1, 0, "Incorrect dotAt(0, 1)"},
                {0, 2, 1, "Incorrect dotAt(0, 2)"},
                {1, 0, 1, "Incorrect dotAt(1, 0)"},
                {1, 1, 1, "Incorrect dotAt(1, 1)"},
                {1, 2, 1, "Incorrect dotAt(1, 2)"},
                {2, 0, 1, "Incorrect dotAt(2, 0)"},
                {2, 1, 0, "Incorrect dotAt(2, 1)"},
                {2, 2, 1, "Incorrect dotAt(2, 2)"}
        };
    }
}

