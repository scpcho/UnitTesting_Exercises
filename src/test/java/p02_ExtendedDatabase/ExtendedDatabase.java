package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ExtendedDatabase {
    private static final Person[] POEPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C")
    };


    private Database database;

    @Before

    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(POEPLE);
    }

    @Test

    public void whenCorrectElementsArePassedThenCreateDataBaseInstance() throws OperationNotSupportedException {

        assertEquals(POEPLE.length, database.getElements().length);
        assertArrayEquals(POEPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenElementsMoreThenSixteenPassedToConstructionThenExceptionIsThrown() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsLessThanOnePassedToConstructorThenExceptionIsThrown() throws OperationNotSupportedException {
        new Database();

    }

    //add

    @Test

    public void whenValidElementPassedToAddThenElementIsAddedOnLastPosition() throws OperationNotSupportedException {

        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        Person[] databaseElements = database.getElements();

        assertEquals(POEPLE.length + 1, databaseElements.length);
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenInvalidElementPassedToAddThanExceptionIsThrown() throws OperationNotSupportedException {

        database.add(null);
    }

    //remove

    @Test

    public void whenRemoveThanLastElementIsRemoved() throws OperationNotSupportedException {


        database.remove();
        Person[] databaseElements = database.getElements();
        assertEquals(POEPLE.length - 1, databaseElements.length);
        Person expectedPerson = POEPLE[POEPLE.length - 2];
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenElementIsEmptyAndRemoveThenExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Person(4, "G"));
        database.remove();
        database.remove();

    }

    //findByUsername

    @Test(expected = OperationNotSupportedException.class)

    public void whenUsernameIsNullPassedToFindByUsernameExceptionIsThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test

    public void whenValidUsernamePassedToFindByUsernameThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("B");
        assertEquals(POEPLE[1].getId(), actualPerson.getId());
        assertEquals(POEPLE[1].getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)

    public void whenFindByUsernameOnEmptyArrayThenExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername("A");
    }
    //findById

    @Test(expected = OperationNotSupportedException.class)

    public void whenFindPersonByIdOrEmptyArrayThenExceptionThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findById(2);
    }

    @Test

    public void whenValidIdPassedThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findById(2);
        assertEquals(POEPLE[1].getId(), actualPerson.getId());
        assertEquals(POEPLE[1].getUsername(), actualPerson.getUsername());
    }
}

