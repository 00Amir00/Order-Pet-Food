package ghasemia;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * Program : Developing a class that models a ordering pet food
 *
 * This class name is ghasemia, and it contains the main method.
 *
 * @author Amirmahdi Ghasemi, 2020
 */
/**
 * The default constructor which extends Application class
 */
public class ghasemia extends Application {

    /**
     * The main method, and the main method will launch the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    // The start method which takes a stage as its parameter, and it throws exception
    public void start(Stage stage) throws Exception {
        // The next line will show how the FXMLLoader will find the fxml file and will load the fxml file
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPetFood.fxml"));
        // The program will make a scene for our root variable
        Scene scene = new Scene(root);
        // The program will put the scene into the stage
        stage.setScene(scene);
        // The program will set title of the stage which is Custom Order
        stage.setTitle("Custom Order");
        // The last step which is showing the stage to the user
        stage.show();
    }

}
