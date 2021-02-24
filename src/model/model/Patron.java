package model.model;

import model.model.EntityBase;
import exception.InvalidPrimaryKeyException;
import impresario.IView;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class Patron extends EntityBase{

    private static final String myTableName = "Patron";
    protected Properties dependencies;
    private String updateStatusMessage = "";

    public Patron(String patronId) throws InvalidPrimaryKeyException {
        super(myTableName);
        this.setDependencies();
        String query = "SELECT * FROM " + myTableName + " WHERE (patronId = " + patronId + ")";
        Vector allDataFromDB = this.getSelectQueryResult(query);
        if (allDataFromDB != null) {
            int dataLen = allDataFromDB.size();
            if (dataLen != 1) {
                throw new InvalidPrimaryKeyException("Multiple Patrons matching id : " + patronId + " found.");
            } else {
                Properties patronData = (Properties)allDataFromDB.elementAt(0);
                this.persistentState = new Properties();
                Enumeration patronKeys = patronData.propertyNames();

                while(patronKeys.hasMoreElements()) {
                    String nextKey = (String)patronKeys.nextElement();
                    String nextValue = patronData.getProperty(nextKey);
                    if (nextValue != null) {
                        this.persistentState.setProperty(nextKey, nextValue);
                    }
                }

            }
        } else {
            throw new InvalidPrimaryKeyException("No Patron matching id : " + patronId + " found.");
        }
    }

    public Patron(Properties props) {
        super(myTableName);
        this.setDependencies();
        this.persistentState = new Properties();
        Enumeration allKeys = props.propertyNames();

        while(allKeys.hasMoreElements()) {
            String element = (String)allKeys.nextElement();
            String propOfElement = props.getProperty(element);
            if (propOfElement != null) {
                this.persistentState.setProperty(element, propOfElement);
            }
        }
     }

     private void setDependencies(){
        this.dependencies = new Properties();
        this.myRegistry.setDependencies(this.dependencies);
     }

    @Override
    public Object getState(String key) {
        return persistentState.getProperty(key);
    }

    @Override
    public void stateChangeRequest(String key, Object value) {

    }

//-----------------------------------------------------------------------------------
	public void update()
	{
		updateStateInDatabase();
	}
	
	//-----------------------------------------------------------------------------------
	private void updateStateInDatabase() 
	{
		try
		{
			if (persistentState.getProperty("PatronId") != null)
			{
				Properties whereClause = new Properties();
				whereClause.setProperty("patronId", persistentState.getProperty("PatronId"));
				updatePersistentState(mySchema, persistentState, whereClause);
				updateStatusMessage = "Patron data for Patron number : " + persistentState.getProperty("patronId") + " updated successfully in database!";
			}
			else
			{
				Integer patronId =
					insertAutoIncrementalPersistentState(mySchema, persistentState);
				persistentState.setProperty("patronId", "" + patronId.intValue());
				updateStatusMessage = "Patron data for new Patron : " +  persistentState.getProperty("patronId")
					+ "installed successfully in database!";
			}
		}
		catch (SQLException ex)
		{
			updateStatusMessage = "Error in installing Book data in database!";
		}
		//DEBUG System.out.println("updateStateInDatabase " + updateStatusMessage);
	}
	
    public String toString()
    {
		return "Patron: ID: " + getState("patronId") + " Name: " + getState("name") + " DOB: " + getState("dateOfBirth");
    }

    @Override
	//------------------------------------------------------------------------------------
    protected void initializeSchema(String tableName) {

		if (mySchema == null)
		{
			mySchema = getSchemaInfo(tableName);
		}
    }
	
	
	
	
}
