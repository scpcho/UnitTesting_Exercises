package p03_ListIterator;

import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static final String[] testArray = new String[]{"1", "2", "3"};
    private static final String[] testArrayWhitOneElement = new String[]{"1"};
    private static final String[] empty = null;

    private static ListIterator listIterator;

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenParametersIsNull() throws OperationNotSupportedException {
        listIterator = createListIterator(empty);
        listIterator = createListIterator();
    }

    @Test
    public void testConstructorWhenGetCorrectParameters() throws OperationNotSupportedException {
        listIterator = createListIterator(testArray);
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextIfArrayHasElements() throws OperationNotSupportedException {
        listIterator = createListIterator(testArray);
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextIfArrayHasOneElement() throws OperationNotSupportedException {
        listIterator = createListIterator(testArrayWhitOneElement);
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextIfArrayIsEmpty() throws OperationNotSupportedException {
        listIterator = createListIterator();
        assertFalse(listIterator.hasNext());

    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWhenArrayIsEmptyMustFails() throws OperationNotSupportedException {
        listIterator = createListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintWhenArrayHasMoreParameters() throws OperationNotSupportedException {
        listIterator = createListIterator(testArray);
        for (String s : testArray) {
            assertEquals(listIterator.print(), s);
            if (listIterator.hasNext()) {
                listIterator.move();
            }
        }
    }

    public static ListIterator createListIterator(String ... args) throws OperationNotSupportedException {
        return new ListIterator(args);
    }
}
