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

    private static final String myTableName = "Patron";

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

        String query = "SELECT * FROM " + myTableName + "WHERE (pubYear < " + date + ")";
        try {
            queryBuilder(query);
        }
        catch (Exception x){
            System.out.println("Error" + x);
        }

    }

    //----------------------------------------------------------
    public String toString()
    {
        String retValue = "";
        for (int cnt = 0; cnt < patronList.size(); cnt++)
            retValue += patronList.get(cnt).toString() + "\n";
        return retValue;
    }

    //---------------------------------------------------------------------------------
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
    public void queryBuilder(String query) throws Exception {
        Vector allDataRetrieved = getSelectQueryResult(query);

        if (allDataRetrieved != null) {
            patronList = new Vector<Patron>();

            for (int index = 0; index < allDataRetrieved.size(); index++) {
                Properties nextPatronData = (Properties) allDataRetrieved.elementAt(index);

                Patron patron = new Patron(nextPatronData);

                if (patron != null) {
                    addPatron(patron);
                }
            }

        } else {
            throw new InvalidPrimaryKeyException("No books matching criteria found");
        }


    }

    //----------------------------------------------------------------------------------
    private void addPatron(Patron a) {
        //accounts.add(a);
        int index = findIndexToAdd(a);
        patronList.insertElementAt(a, index); // To build up a collection sorted on some key
    }

    //----------------------------------------------------------------------------------
    private int findIndexToAdd(Patron a) {
        int low=0;
        int high = patronList.size()-1;
        int middle;

        while (low <=high)
        {
            middle = (low+high)/2;

            Patron midSession = patronList.elementAt(middle);

            int result = Patron.compare(a,midSession);

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