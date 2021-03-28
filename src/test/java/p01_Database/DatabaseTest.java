package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = new Integer[]{4, 6, 19, 32, 5};
    private Database database;

    @Before

    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test

    public void whenCorrectElementsArePassedThenCreateDataBaseInstance() throws OperationNotSupportedException {

        assertEquals(ELEMENTS.length, database.getElements().length);
        assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenElementsMoreThenSixteenPassedToConstructionThenExceptionIsThrown() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsLessThanOnePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        new Database();

    }

    //add

    @Test

    public void whenValidElementPassedToAddThenElementIsAddedOnLastPosition() throws OperationNotSupportedException {

        int element = 15;
        database.add(15);
        Integer[] databaseElements = database.getElements();

        assertEquals(ELEMENTS.length + 1, databaseElements.length);
        assertEquals(Integer.valueOf(element), databaseElements[databaseElements.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenInvalidElementPassedToAddThanExceptionIsThrown() throws OperationNotSupportedException {

        database.add(null);
    }

    //remove

    @Test

    public void whenRemoveThanLastElementIsRemoved() throws OperationNotSupportedException {


        database.remove();
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length - 1, databaseElements.length);
        assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenElementIsEmptyAndRemoveThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();

    }
}
