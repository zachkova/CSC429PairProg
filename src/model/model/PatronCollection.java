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
public class PatronCollection  extends EntityBase
{
    private static final String myTableName = "Patron";

    private Vector<Patron> patronList;
    // GUI Components



    // constructor for this class
    //----------------------------------------------------------
    public PatronCollection()
    {
        super(myTableName);
        patronList = new Vector<Patron>();
    }

    //----------------------------------------------------------
    public void findPatronsOlderThan(String date)
    {

        String query = "SELECT * FROM " + myTableName + " WHERE (dateOfBirth < " + date + ")";
        try {
            queryBuilder(query);
        } catch (Exception x) {
            System.out.println("Error: "+ x);
        }


    }

    //----------------------------------------------------------
    public void findPatronsYoungerThan(String date)
    {

        String query = "SELECT * FROM " + myTableName + " WHERE (dateOfBirth > " + date + ")";
        try {
            queryBuilder(query);
        } catch (Exception x) {
            System.out.println("Error: "+ x);
        }


    }

    //----------------------------------------------------------
    public void findPatronsAtZipCode(String zip)
    {

        String query = "SELECT * FROM " + myTableName + " WHERE (zip = " + zip + ")";
        try {
            queryBuilder(query);
        } catch (Exception x) {
            System.out.println("Error: "+ x);
        }


    }
    //----------------------------------------------------------
    public void findPatronsWithNameLike(String name)
    {

        String query = "SELECT * FROM " + myTableName + " WHERE (name LIKE '%" + name + "%')";
        try {
            queryBuilder(query);
        } catch (Exception x) {
            System.out.println("Error: "+ x);
        }


    }

    //---------------------------------------------------------------------------------
    public void queryBuilder(String query) throws Exception{
        Vector allDataRetrieved = getSelectQueryResult(query);

        if (allDataRetrieved != null)
        {
            patronList = new Vector<Patron>();

            for (int index = 0; index < allDataRetrieved.size(); index++)
            {
                Properties nextPatronData = (Properties)allDataRetrieved.elementAt(index);

                Patron patron = new Patron(nextPatronData);

                if (patron != null)
                {
                    addPatron(patron);
                }
            }

        }
        else
        {
            throw new InvalidPrimaryKeyException("No books matching criteria found");
        }



    }

    //----------------------------------------------------------------------------------
    private void addPatron(Patron p)
    {
        //accounts.add(a);
        int index = findIndexToAdd(p);
        patronList.insertElementAt(p,index); // To build up a collection sorted on some key
    }

    //----------------------------------------------------------------------------------
    private int findIndexToAdd(Patron p)
    {
        //users.add(u);
        int low=0;
        int high = patronList.size()-1;
        int middle;

        while (low <=high)
        {
            middle = (low+high)/2;

            Patron midSession = patronList.elementAt(middle);

            int result = Patron.compare(p,midSession);

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
        if (key.equals("Patron"))
            return patronList;
        else if (key.equals("PatronList"))
            return this;
        else
            return null;
    }

    //---------------------------------------------------------------
    public void stateChangeRequest(String key, Object value)
    {

        myRegistry.updateSubscribers(key, this);
    }

    //----------------------------------------------------------
    public Patron retrieve(String patronId)
    {
        Patron retValue = null;
        for (int cnt = 0; cnt < patronList.size(); cnt++)
        {
            Patron nextPatron = patronList.elementAt(cnt);
            String nextPatronId = (String)nextPatron.getState("patronId");
            if (nextPatronId.equals(patronId) == true)
            {
                retValue = nextPatron;
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
    public String toString()
    {
        String retValue = "";
        for (int cnt = 0; cnt < patronList.size(); cnt++)
            retValue += patronList.get(cnt).toString() + "\n";
        return retValue;
    }

    //-----------------------------------------------------------------------------------
    protected void initializeSchema(String tableName)
    {
        if (mySchema == null)
        {
            mySchema = getSchemaInfo(tableName);
        }
    }
}
