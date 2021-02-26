// specify the package
package model.model;

// system imports
import java.util.Properties;
import java.util.Vector;
import javafx.scene.Scene;

// project imports
import exception.InvalidPrimaryKeyException;
import event.Event;
import database.*;

public class PatronCollection extends EntityBase{

    private static final String myTableName = "Book";

    private Vector<Patron> patronList;
    // GUI Components


    // constructor for this class
    //----------------------------------------------------------
    public PatronCollection() {
        super(myTableName);
        patronList = new Vector<Patron>();
    }

    //----------------------------------------------------------
    public void findPatronsOlderThan(String date) {

        String query = "SELECT * FROM " + myTableName + "WHERE (pubYear < " + year + ")";
        queryBuilder(query);


    }

    //---------------------------------------------------------------------------------
    public void queryBuilder(String query) throws Exception {
        Vector allDataRetrieved = getSelectQueryResult(query);

        if (allDataRetrieved != null) {
            bookList = new Vector<Book>();

            for (int index = 0; index < allDataRetrieved.size(); index++) {
                Properties nextBookData = (Properties) allDataRetrieved.elementAt(index);

                Book book = new Book(nextBookData);

                if (book != null) {
                    addBook(book);
                }
            }

        } else {
            throw new InvalidPrimaryKeyException("No books matching criteria found");
        }


    }

    //----------------------------------------------------------------------------------
    private void addBook(Book a) {
        //accounts.add(a);
        int index = findIndexToAdd(a);
        bookList.insertElementAt(a, index); // To build up a collection sorted on some key
    }

    //----------------------------------------------------------------------------------
    private int findIndexToAdd(Book a) {
    }

    @Override
    public Object getState(String key) {
        return null;
    }

    @Override
    public void stateChangeRequest(String key, Object value) {

    }

    @Override
    protected void initializeSchema(String tableName) {

    }
}