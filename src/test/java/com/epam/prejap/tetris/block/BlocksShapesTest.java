package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "blockShapes")
public class BlocksShapesTest {

    private final Block block;
    private final int rowsExpected;
    private final int colsExpected;
    private final Object[][] shape;

    public void numberOfEveryBlockShapeRowsAsExpected() {
        assertEquals(block.rows(), rowsExpected,
                String.format("Number of rows for %s is incorrect.", block.getClass().getSimpleName()));
    }

    public void numberOfEveryBlockShapeColsAsExpected() {
        assertEquals(block.cols(), colsExpected,
                String.format("Number of columns for %s is incorrect.", block.getClass().getSimpleName()));
    }

    @Test(dataProvider = "shapeDots")
    public void blocksDotAtReturnsCorrectValue(int i, int j, int expected) {
        assertEquals(block.dotAt(i, j), (byte) expected,
                String.format("%s incorrect dotAt(%s, %s)", block.getClass().getSimpleName(), i, j));
    }

    @DataProvider
    public Object[][] shapeDots() {
        return shape;
    }

    @Factory(dataProvider = "blocks")
    public BlocksShapesTest(Block block, int rowsExpected, int colsExpected, Object[][] shape) {
        this.block = block;
        this.rowsExpected = rowsExpected;
        this.colsExpected = colsExpected;
        this.shape = shape;
    }

    @DataProvider
    public static Object[][] blocks() {
        return new Object[][]{
                createTestHBlockObject(),
                createTestOBlockObject(),
                createTestTBlockObject(),
                createTestYBlockObject()
        };
    }

    private static Object[] createTestHBlockObject() {
        var shape = new Object[][]{
                createTestDotObject(0, 0, 1),
                createTestDotObject(0, 1, 0),
                createTestDotObject(0, 2, 1),
                createTestDotObject(1, 0, 1),
                createTestDotObject(1, 1, 1),
                createTestDotObject(1, 2, 1),
                createTestDotObject(2, 0, 1),
                createTestDotObject(2, 1, 0),
                createTestDotObject(2, 2, 1)
        };
        return createTestBlockObject(new HBlock(), 3, 3, shape);
    }

    private static Object[] createTestOBlockObject() {
        var shape = new Object[][]{
                createTestDotObject(0, 0, 1),
                createTestDotObject(0, 1, 1),
                createTestDotObject(1, 0, 1),
                createTestDotObject(1, 1, 1)
        };
        return createTestBlockObject(new OBlock(), 2, 2, shape);
    }

    private static Object[] createTestTBlockObject() {
        var shape = new Object[][]{
                createTestDotObject(0, 0, 1),
                createTestDotObject(0, 1, 1),
                createTestDotObject(0, 2, 1),
                createTestDotObject(1, 0, 0),
                createTestDotObject(1, 1, 1),
                createTestDotObject(1, 2, 0)
        };
        return createTestBlockObject(new TBlock(), 2, 3, shape);
    }

    private static Object[] createTestYBlockObject() {
        var shape = new Object[][]{
                createTestDotObject(0, 0, 1),
                createTestDotObject(0, 1, 0),
                createTestDotObject(0, 2, 1),
                createTestDotObject(1, 0, 0),
                createTestDotObject(1, 1, 1),
                createTestDotObject(1, 2, 0),
                createTestDotObject(2, 0, 0),
                createTestDotObject(2, 1, 1),
                createTestDotObject(2, 2, 0)
        };
        return createTestBlockObject(new YBlock(), 3, 3, shape);
    }

    private static Object[] createTestDotObject(int i, int j, int expected) {
        return new Object[]{i, j, expected};
    }

    private static Object[] createTestBlockObject(Block block, int rowsExpected, int colsExpected, Object[][] shape) {
        return new Object[]{block, rowsExpected, colsExpected, shape};
    }
}
