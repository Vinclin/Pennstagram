package org.cis1200;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Use this file to test your implementation of Pixel.
 * <p>
 * We will manually grade this file to give you feedback
 * about the completeness of your test cases.
 */

public class MyPixelTest {

    /*
     * Remember, UNIT tests should ideally have one point of failure. Below we
     * give you two examples of unit tests for the Pixel constructor, one that
     * takes in three ints as arguments and one that takes in an array. We use
     * the getRed(), getGreen(), and getBlue() methods to check that the values
     * were set correctly. These two tests do not comprehensively test all * Pixel,
     * so you must add your own.
     *
     * You might want to look into assertEquals, assertTrue, assertFalse, and
     * assertArrayEquals at the following:
     * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
     *
     * Note, if you want to add global variables so that you can reuse Pixels
     * in multiple tests, feel free to do so.
     */

    @Test
    public void testConstructInBounds() {
        Pixel px = new Pixel(40, 50, 60);
        assertEquals(40, px.getRed(), "");
        assertEquals(50, px.getGreen(), "");
        assertEquals(60, px.getBlue(), "");
    }

    @Test
    public void testConstructArrayLongerThan3() {
        int[] arr = {10, 20, 30, 40};
        Pixel px = new Pixel(arr);
        assertEquals(10, px.getRed(), "");
        assertEquals(20, px.getGreen(), "");
        assertEquals(30, px.getBlue(), "");
    }

    /* ADD YOUR OWN TESTS BELOW */
    @Test
    public void testConstructArrayShorterThan3() {
        int[] arr = {10};
        Pixel px = new Pixel(arr);
        assertEquals(10, px.getRed(), "");
        assertEquals(0, px.getGreen(), "");
        assertEquals(0, px.getBlue(), "");
    }

    @Test
    public void testConstructArrayLowerBounds() {
        int[] arr = {-1, 0, 1};
        Pixel px = new Pixel(arr);
        assertEquals(0, px.getRed(), "");
        assertEquals(0, px.getGreen(), "");
        assertEquals(1, px.getBlue(), "");
    }

    @Test
    public void testConstructArrayLength4Bounds() {
        int[] arr = {-2, -1, 0, 1};
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getRed(), "");
        assertEquals(0, p.getGreen(), "");
        assertEquals(0, p.getBlue(), "");
    }

    @Test
    public void testGetComponentsListNull() {
        int[] arr = {};
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getComponents()[0], "");
        assertEquals(0, p.getComponents()[1], "");
        assertEquals(0, p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsListLength1() {
        int[] arr = {10};
        Pixel p = new Pixel(arr);
        assertEquals(arr[0], p.getComponents()[0], "");
        assertEquals(0, p.getComponents()[1], "");
        assertEquals(0, p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsListLength2() {
        int[] arr = {10, 20};
        Pixel p = new Pixel(arr);
        assertEquals(arr[0], p.getComponents()[0], "");
        assertEquals(arr[1], p.getComponents()[1], "");
        assertEquals(0, p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsListLength3() {
        int[] arr = {10, 20, 30};
        Pixel p = new Pixel(arr);
        assertEquals(arr[0], p.getComponents()[0], "");
        assertEquals(arr[1], p.getComponents()[1], "");
        assertEquals(arr[2], p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsListLongerThan3() {
        int[] arr = {10, 20, 30, 40};
        Pixel p = new Pixel(arr);
        assertEquals(arr[0], p.getComponents()[0], "");
        assertEquals(arr[1], p.getComponents()[1], "");
        assertEquals(arr[2], p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsUpperBounds() {
        int[] arr = {254, 255, 256};
        Pixel p = new Pixel(arr);
        assertEquals(254, p.getComponents()[0], "");
        assertEquals(255, p.getComponents()[1], "");
        assertEquals(255, p.getComponents()[2], "");
    }

    @Test
    public void testGetComponentsLowerBounds() {
        int[] arr = {-1, 0, 1};
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getComponents()[0], "");
        assertEquals(0, p.getComponents()[1], "");
        assertEquals(1, p.getComponents()[2], "");
    }

    @Test
    public void testDistanceNotEquals() {
        Pixel p1 = new Pixel(10, 20, 30);
        Pixel p2 = new Pixel(10, 10, 10);
        assertEquals(30, p1.distance(p2), "");
    }

    @Test
    public void testDistanceEquals() {
        Pixel p1 = new Pixel(10, 20, 30);
        Pixel p2 = new Pixel(10, 20, 30);
        assertEquals(0, p1.distance(p2), "");
    }

    @Test
    public void testToString() {
        Pixel p1 = new Pixel(10, 20, 30);
        assertEquals("(10, 20, 30)", p1.toString(), "");
    }

    @Test
    public void testSameRGBEquals() {
        Pixel p1 = new Pixel(10, 20, 30);
        Pixel p2 = new Pixel(10, 20, 30);
        assertEquals(p1, p2, "");
    }

    @Test
    public void testSameRGBNotEquals() {
        Pixel p1 = new Pixel(10, 20, 30);
        Pixel p2 = new Pixel(10, 10, 10);
        assertNotEquals(p1, p2, "");
    }

}
