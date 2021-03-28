package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

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
    }
}
