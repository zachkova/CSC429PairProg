package userinterface;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class GUI extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System");

        Button nb = new Button();
        Button np = new Button();
        Button sb = new Button();
        Button sp = new Button();
        Button done = new Button();

        nb.setText("Insert New Book");
        nb.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Test NB");
            }
        });

        np.setText("Insert New Patron");
        np.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Test NP");
            }
        });

        sb.setText("Search Books");
        sb.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Test SB");
            }
        });

        sp.setText("Search Patrons");
        sp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Test");
            }
        });

        done.setText("Done");
        done.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Test done");
            }
        });

        VBox root = new VBox(50, nb, np, sb, sp, done);

        root.setAlignment(Pos.BASELINE_CENTER);
        root.setStyle("-fx-padding: 18;");

        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }
}
