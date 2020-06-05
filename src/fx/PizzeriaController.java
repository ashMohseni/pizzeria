
package fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author ashkanmohseni
 */
public class PizzeriaController implements Initializable {

    @FXML private Menu close;
    @FXML private Menu clear;
    @FXML private Menu about;
    @FXML private RadioButton small;
    @FXML private RadioButton medium;
    @FXML private RadioButton large;
    @FXML private TextField pizzaNum;
    @FXML private CheckBox cheese;
    @FXML private CheckBox pepperoni;
    @FXML private CheckBox mushrooms;
    @FXML private CheckBox olives;
    @FXML private RadioButton coke;
    @FXML private RadioButton juice;
    @FXML private RadioButton chocolate_milk;
    @FXML private TextField drinkNum;
    @FXML private TextArea receipt;
    @FXML private Button confirm;
    @FXML private Button cancel;
    @FXML private Button exit;
    @FXML private ToggleGroup togglepizzas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void confirm(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
}
