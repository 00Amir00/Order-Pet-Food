package ghasemia;

import ghasemia.models.Flavours;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Assignment 4
 *
 * FXML Controller class
 *
 * Program : Developing a class that models a ordering pet food
 *
 * This class name is PetFoodController, and it contains the controllers of the
 * program.
 *
 * @author Amirmahdi Ghasemia, 2020
 */
public class PetFoodController implements Initializable {

    /**
     * These are the Labels that were entered from FXMLPetFood, and they are
     * private, they will be used by referring to them by their names.
     */
    @FXML
    private Label lblKg, lblChooseFalvour;
    /**
     * These are the TextFields that were entered from FXMLPetFood, and they are
     * private, they will be used by referring to them by their names.
     */
    @FXML
    private TextField txtKgField, txtCustomNameField;
    /**
     * These are the CheckBoxes that were entered from FXMLPetFood, and they are
     * private, they will be used by referring to them by their names.
     */
    @FXML
    private CheckBox chkCustomName;
    /**
     * These are the Button that were entered from FXMLPetFood, and they are
     * private, it will be used by referring to them by its name.
     */
    @FXML
    private Button btnCalculate, btnExit;
    /**
     * These are the RadioButtons that were entered from FXMLPetFood, and they
     * are private, they will be used by referring to them by their names.
     */
    @FXML
    private RadioButton optDuck, optHalibut, optBison;
    /**
     * This is the TextArea that were entered from FXMLPetFood, and they are
     * private, it will be used by referring to them by its name.
     */
    @FXML
    private TextArea txtOutPut;

    /**
     * This method takes one parameter which is event, and it will calculate the
     * price for us.
     *
     * @param event
     */
    @FXML
    private void calculate(ActionEvent event) {
        // The condition is the text which user will type has to be valid
        if (!txtKgField.getText().matches("-?\\d+")) {
            // The error text will be setted by the program
            txtOutPut.setText(String.format("Error: Kilograms must be a valid number."));
            /*Here the text that user has typed will be selected,
            so the user can delete the whole text by one click*/
            txtKgField.requestFocus();
            /*The text that user has typed will be parse into double,
            and it will be check if it is greater than 0*/
        } else if (Double.parseDouble(txtKgField.getText()) <= 0) {
            // The error text will be setted by the program
            txtOutPut.setText(String.format("Error: Kilgrams must be greater than 0."));
            /*Here the text that user has typed will be selected,
            so the user can delete the whole text by one click*/
            txtKgField.requestFocus();
        } else {
            // If everything went well, the text will be parsed into a double number
            double kgAmount = Double.parseDouble(txtKgField.getText());
            // The subTotal is a double variable, and its value is zero.
            double subTotal = 0;
            /*
            The program will check the radio button 
            to find which one has been selected by the user.
             */
            // Checks if Duck has been selected
            if (optDuck.isSelected()) {
                /*The next line will calculate the subTotal 
                by the number which the user has entered and
                the radio button which the user has been selected, 
                the program will get the price of the user choice of food */
                subTotal = kgAmount * Flavours.DUCK.getPrice();
                // Checks if Halibut has been selected
            } else if (optHalibut.isSelected()) {
                /*The next line will calculate the subTotal 
                by the number which the user has entered and
                the radio button which the user has been selected, 
                the program will get the price of the user choice of food */
                subTotal = kgAmount * Flavours.HALIBUT.getPrice();
                // Checks if Duck and Halibut has not been selected, therefore it must be Bison.
            } else {
                /*The next line will calculate the subTotal 
                by the number which the user has entered and
                the radio button which the user has been selected, 
                the program will get the price of the user choice of food */
                subTotal = kgAmount * Flavours.BISON.getPrice();
            }
            // If the user wants to customise the name of the order, so he/she has to pay 200 dollar more
            if (chkCustomName.isSelected()) {
                subTotal = subTotal + 200;
            }
            // Here the program will set the text and the subTotal value in the TextArea
            txtOutPut.setText(String.format("Sub Total :  "
                    + "%.2f\n", subTotal));
            // The next line will calculate the hstAmount
            double hstAmount = 0.13 * subTotal;
            // the program will set the text and the hstAmount value in the TextArea
            txtOutPut.appendText(String.format("HST Amt :     "
                    + "%.2f\n", hstAmount));
            // The next line wil calculate the finalTotal by adding the hstAmount and subTotal together
            double finalTotal = hstAmount + subTotal;
            // the program will set the text and the finalTotal value in the TextArea
            txtOutPut.appendText(String.format("Final Total : "
                    + "%.2f", finalTotal));
            // This line will change the font and size of the font in the TextArea
            txtOutPut.setFont(Font.font("Times New Roman (Headings CS)",
                    15));
        }
    }

    /**
     * This method takes one parameter which is event, and it will enable the
     * the checkbox for us, so the user can enter their preferred name.
     *
     * @param event
     */
    @FXML
    private void check(ActionEvent event) {
        txtCustomNameField.setEditable(chkCustomName.isSelected());
        txtCustomNameField.clear();
    }

    /**
     * This method takes one parameter which is event, and it will close the the
     * window and program whenever the user press the exit button.
     *
     * @param event
     */
    @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
