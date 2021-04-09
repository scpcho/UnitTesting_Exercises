package p04_BubbleSort;

import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

    private static final int [] sorted = new int[]{1,2,3,4,5};
    private static final int [] unSorted = new int[]{5,2,1,3,4};
    private static final int [] empty = new int[0];

    @Test
    public void testSortMustReturnSortedArrayWhenGetUnsorted(){
        Bubble.sort(unSorted);
        assertArrayEquals(sorted,unSorted);
    }

    @Test
    public void testSortMustReturnSameArrayWhenGetSorted(){
        Bubble.sort(sorted);
        assertArrayEquals(sorted,sorted);
    }

    @Test
    public void testSortMustReturnSameArrayWhenGetEmpty(){
        Bubble.sort(empty);
        assertEquals(0,empty.length);
    }
}