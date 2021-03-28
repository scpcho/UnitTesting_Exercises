package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test

    public void whenCorrectElementsArePassedThenCreateDataBaseInstance() throws OperationNotSupportedException {
        //arrange
        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};
        //act
        Database database = new Database(elements);
        //assert
        assertEquals(elements.length, database.getElements().length);
        assertArrayEquals(elements, database.getElements());
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
        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};

        Database database = new Database(elements);

        int element = 15;
        database.add(15);
        Integer[] databaseElements = database.getElements();

        assertEquals(elements.length + 1, databaseElements.length);
        assertEquals(Integer.valueOf(element), databaseElements[databaseElements.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenInvalidElementPassedToAddThanExceptionIsThrown() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};

        Database database = new Database(elements);

        database.add(null);
    }

    //remove

    @Test

    public void whenRemoveThanLastElementIsRemoved() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};

        Database database = new Database(elements);

        database.remove();
        Integer[] databaseElements = database.getElements();
        assertEquals(elements.length - 1, databaseElements.length);
        assertEquals(elements[elements.length - 2], databaseElements[databaseElements.length - 1]);

    }
}
