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
import javafx.scene.control.*;
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
import model.model.Book;
import model.model.Librarian;

/** The class containing the Teller View  for the ATM application */
//==============================================================
public class BookView extends View
{

    // GUI components
    protected TextField newAuthor;
    protected TextField newTitle;
    protected TextField pubYear;

    ComboBox comboBox = new ComboBox();

    protected Button subButton;
    protected Button canButton;

    // For showing error message
    private MessageView statusLog;

    // constructor for this class -- takes a model object
    //----------------------------------------------------------
    public BookView( IModel Book)
    {
        super(Book, "BookView");

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
        Text titleText = new Text("       Book System          ");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);

        return titleText;
    }

    // Create the main form contents
    //-------------------------------------------------------------
    private VBox createFormContent()
    {
        VBox vbox = new VBox(10);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text prompt = new Text("BOOK INFORMATION");
        prompt.setWrappingWidth(400);
        prompt.setTextAlignment(TextAlignment.CENTER);
        prompt.setFill(Color.BLACK);
        grid.add(prompt, 0, 0, 2, 1);

        Text accNumLabel = new Text(" Book Author : ");
        Font myFont = Font.font("Helvetica", FontWeight.BOLD, 12);
        accNumLabel.setFont(myFont);
        accNumLabel.setWrappingWidth(150);
        accNumLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(accNumLabel, 0, 1);

        accountNumber = new TextField();
        accountNumber.setEditable(false);
        grid.add(accountNumber, 1, 1);

        Text acctTypeLabel = new Text(" Account Type : ");
        acctTypeLabel.setFont(myFont);
        acctTypeLabel.setWrappingWidth(150);
        acctTypeLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(acctTypeLabel, 0, 2);

        acctType = new TextField();
        acctType.setEditable(false);
        grid.add(acctType, 1, 2);

        Text balLabel = new Text(" Account Balance : ");
        balLabel.setFont(myFont);
        balLabel.setWrappingWidth(150);
        balLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(balLabel, 0, 3);

        balance = new TextField();
        balance.setEditable(false);
        grid.add(balance, 1, 3);

        Text scLabel = new Text(" Service Charge : ");
        scLabel.setFont(myFont);
        scLabel.setWrappingWidth(150);
        scLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(scLabel, 0, 4);

        serviceCharge = new TextField();
        serviceCharge.setEditable(true);
        serviceCharge.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                clearErrorMessage();
                myModel.stateChangeRequest("ServiceCharge", serviceCharge.getText());
            }
        });
        grid.add(serviceCharge, 1, 4);

        HBox doneCont = new HBox(10);
        doneCont.setAlignment(Pos.CENTER);
        cancelButton = new Button("Back");
        cancelButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                clearErrorMessage();
                myModel.stateChangeRequest("AccountCancelled", null);
            }
        });
        doneCont.getChildren().add(cancelButton);

        vbox.getChildren().add(grid);
        vbox.getChildren().add(doneCont);

        return vbox;
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


