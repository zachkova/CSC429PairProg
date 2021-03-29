
// specify the package
package userinterface;

// system imports
import java.text.NumberFormat;
import java.util.Properties;

import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

// project imports
import impresario.IModel;
import model.model.Librarian;

/** The class containing the Teller View  for the ATM application */
//==============================================================
public class LibrarianView extends View
{

    // GUI stuff
    private Button newBook;
    private Button newPatron;
    private Button searchBook;
    private Button searchPatron;
    private Button done;

    // For showing error message
    private MessageView statusLog;

    // constructor for this class -- takes a model object
    //----------------------------------------------------------
    public LibrarianView( IModel Librarian)
    {

        super(Librarian, "LibrarianView");

        // create a container for showing the contents
        VBox container = new VBox(10);

        container.setPadding(new Insets(15, 5, 5, 5));

        // create a Node (Text) for showing the title
        container.getChildren().add(createTitle());

        // create a Node (GridPane) for showing data entry fields
        container.getChildren().add(createFormContents());

        // Error message area
        container.getChildren().add(createStatusLog("                          "));

        getChildren().add(container);

        populateFields();

        // STEP 0: Be sure you tell your model what keys you are interested in
        myModel.subscribe("LoginError", this);
    }

    // Create the label (Text) for the title of the screen
    //-------------------------------------------------------------
    private Node createTitle()
    {

        Text titleText = new Text("       Librarian System          ");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);


        return titleText;
    }

    // Create the main form contents
    //-------------------------------------------------------------
    private GridPane createFormContents()
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        // data entry fields

        newBook = new Button("Add new Book");
        grid.add(newBook, 1, 0);
        newBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               // processAction(e);
                myModel.stateChangeRequest("addBook", null);

            }
        });

        newPatron = new Button("Add new Patron");
        grid.add(newPatron, 1, 1);
        newPatron.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               // processAction(e);
                myModel.stateChangeRequest("addPatron", null);
            }
        });

        searchBook = new Button("Search Books");
        grid.add(searchBook, 1, 2);
        searchBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //processAction(e);
                myModel.stateChangeRequest("SearchView", null);
            }
        });

        searchPatron = new Button("Search Patrons");
        grid.add(searchPatron, 1, 3);
        searchPatron.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //processAction(e);
                myModel.stateChangeRequest("PSearchView", null);
            }
        });

        done = new Button("Done");
        grid.add(done, 2, 5);
        done.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                processAction(e);
            }
        });


        return grid;
    }



    // Create the status log field
    //-------------------------------------------------------------
    private MessageView createStatusLog(String initialMessage)
    {

        statusLog = new MessageView(initialMessage);

        return statusLog;
    }

    //-------------------------------------------------------------
    public void populateFields()
    {

    }

    // This method processes events generated from our GUI components.
    // Make the ActionListeners delegate to this method
    //-------------------------------------------------------------
    public void processAction(Event evt)
    {
        // DEBUG: System.out.println("TellerView.actionPerformed()");



    }



    //---------------------------------------------------------
    public void updateState(String key, Object value)
    {
        // STEP 6: Be sure to finish the end of the 'perturbation'
        // by indicating how the view state gets updated.


    }

    /**
     * Display error message
     */
    //----------------------------------------------------------
    public void displayErrorMessage(String message)
    {
        statusLog.displayErrorMessage(message);
    }

    /**
     * Clear error message
     */
    //----------------------------------------------------------
    public void clearErrorMessage()
    {
        statusLog.clearErrorMessage();
    }

}

