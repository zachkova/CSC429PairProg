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



/** The class containing the BookCollection */
//==============================================================
public class BookCollection  extends EntityBase
{
    private static final String myTableName = "Book";

    private Vector<Book> bookList;
    // GUI Components



    // constructor for this class
    //----------------------------------------------------------
    public BookCollection()
    {
        super(myTableName);
        bookList = new Vector<Book>();
    }

    //----------------------------------------------------------
    public void findBooksOlderThan(String year)
    {

        String query = "SELECT * FROM " + myTableName + "WHERE (pubYear < " + year + ")";
        try {
            queryBuilder(query);
        } catch (Exception x) {
            System.out.println("Invaild Year");
        }


    }
    //---------------------------------------------------------------------------------
    public void queryBuilder(String query) throws Exception{
        Vector allDataRetrieved = getSelectQueryResult(query);

        if (allDataRetrieved != null)
        {
            bookList = new Vector<Book>();

            for (int index = 0; index < allDataRetrieved.size(); index++)
            {
                Properties nextBookData = (Properties)allDataRetrieved.elementAt(index);

                Book book = new Book(nextBookData);

                if (book != null)
                {
                    addBook(book);
                }
            }

        }
        else
        {
            throw new InvalidPrimaryKeyException("No books matching criteria found");
        }



    }

    //----------------------------------------------------------------------------------
    private void addBook(Book a)
    {
        //accounts.add(a);
        int index = findIndexToAdd(a);
        bookList.insertElementAt(a,index); // To build up a collection sorted on some key
    }

    //----------------------------------------------------------------------------------
    private int findIndexToAdd(Book a)
    {
        //users.add(u);
        int low=0;
        int high = bookList.size()-1;
        int middle;

        while (low <=high)
        {
            middle = (low+high)/2;

            Book midSession = bookList.elementAt(middle);

            int result = Book.compare(a,midSession);

            if (result ==0)
            {
                return middle;
            }
            else if (result<0)
            {
                high=middle-1;
            }
            else
            {
                low=middle+1;
            }
        }
        return low;
    }



    //----------------------------------------------------------
    public Object getState(String key)
    {
        return null;
    }

    //---------------------------------------------------------------
    public void stateChangeRequest(String key, Object value)
    {
        myRegistry.updateSubscribers(key, this);
    }

    //----------------------------------------------------------
    public Book retrieve(String bookId)
    {
        Book retValue = null;
        for (int cnt = 0; cnt < bookList.size(); cnt++)
        {
            Book nextBook = bookList.elementAt(cnt);
            String nextBookId = (String)nextBook.getState("bookId");
            if (nextBookId.equals(bookId) == true)
            {
                retValue = nextBook;
                return retValue; // we should say 'break;' here
            }
        }

        return retValue;
    }

    /** Called via the IView relationship */
    //----------------------------------------------------------
    public void updateState(String key, Object value)
    {
        stateChangeRequest(key, value);
    }

/*
	//------------------------------------------------------
	protected void createAndShowView()
	{

		Scene localScene = myViews.get("AccountCollectionView");

		if (localScene == null)
		{
				// create our new view
				View newView = ViewFactory.createView("AccountCollectionView", this);
				localScene = new Scene(newView);
				myViews.put("AccountCollectionView", localScene);
		}
		// make the view visible by installing it into the frame
		swapToView(localScene);

	}*/

    //-----------------------------------------------------------------------------------
    protected void initializeSchema(String tableName)
    {
        if (mySchema == null)
        {
            mySchema = getSchemaInfo(tableName);
        }
    }
}
