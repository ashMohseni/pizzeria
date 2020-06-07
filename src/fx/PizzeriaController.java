
package fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import model.Drinks;
import model.PizzaOrder;
import model.Toppings;

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
    
    // an int variable used by pizzaSize() method to access the PizzaSize enums
    private int pizzaChoice = -1;
    private int drinkChoice = -1;
    
    // instance of PizzaOrder class
    PizzaOrder order = new PizzaOrder(); 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void confirm(ActionEvent event) {
        calculation(); 
        // To clear the arrayList after submiting Confirm button
        order.getToppingList().clear();
        order.getDrinkList().clear();
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
    private int calculation(){
        
        if (pizzaSize() >= 0 && drinkType() >= 0 ) {
        PizzaOrder order = new PizzaOrder(pizzaSize(), pizzaNum(), topping(), toppingCalc(), drinks(), drinkCalc(), drinkNum(), drinkType());
       receipt.setText(order.toString() );
        } 

        return 0;
    }
     
      /**
      * Returns "pizzaChoice" variable based on which size of pizza is being selected.
      * @return pizzaChoice 
      */
    private int pizzaSize(){
        if(small.isSelected()){
            pizzaChoice = 0;
        }
        if (medium.isSelected()) {
            pizzaChoice = 1;
        }
        if (large.isSelected()) {
            pizzaChoice = 2;
        }
        return pizzaChoice;
    }

      /**
      * Returns "number" an Integer variable as the number of pizzas being purchased
      * @return number  
      */
    private int pizzaNum(){
        int number = -1;
        try{
            number = Integer.parseInt(pizzaNum.getText().trim());            
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return number;
    }
    
      /**
      * A method that adds the drinks ordered to the arrayList<Drinks> in PizzaOrder class
      * @return  order.getDrinkList() - an array indicating the ordered drinks
      */
        public ArrayList<Drinks> drinks(){
        if (coke.isSelected()) {
           order.drink(Drinks.COKE);
        }
        if (juice.isSelected()) {
            order.drink(Drinks.JUICE);
        }
        if (chocolate_milk.isSelected()) {
           order.drink(Drinks.CHOCOLATE_MILK);
        }
        return order.getDrinkList();
    }
        
        // To check for exceptions later
       private int drinkType(){
        if(coke.isSelected()){
            drinkChoice = 0;
        }
        if (juice.isSelected()) {
            drinkChoice = 1;
        }
        if (chocolate_milk.isSelected()) {
            drinkChoice = 2;
        }
        return drinkChoice;
    }
       
      /**
      * A method that calculates the total of drinks order and returns "drinkCalc" variable
      * @return drinkCalc - the sum of drinks
      */
       private double drinkCalc(){
        double drinkCalc = 0.0;
        
        if (coke.isSelected()) {
            drinkCalc +=  drinkNum() * Drinks.COKE.getPrice();
        }  if (juice.isSelected()){
             drinkCalc +=  drinkNum() * Drinks.JUICE.getPrice();
        }  if (chocolate_milk.isSelected()){
            drinkCalc += drinkNum() * Drinks.CHOCOLATE_MILK.getPrice();
        } 
        
        return drinkCalc;
    }

       /**
      * Returns "number" an Integer variable as the number of Drinks being purchased
      * @return number  
      */
    private int drinkNum(){
        int number = -1;
        try{
            number = Integer.parseInt(drinkNum.getText().trim());            
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return number;
    }
    

    
      /**
      * A method that adds the toppings ordered to the arrayList<Topping> in PizzaOrder class
      * @return order.getToppingList() - an array indicating the ordered toppings
      */
    public ArrayList<Toppings> topping(){
        if (cheese.isSelected()) {
           order.topping(Toppings.CHEESE);
        }
        if (pepperoni.isSelected()) {
            order.topping(Toppings.PEPPERONI);
        }
        if (mushrooms.isSelected()) {
           order.topping(Toppings.MUSHROOMS);
        }
        if (olives.isSelected()) {
            order.topping(Toppings.OLIVES);
        } 
        return order.getToppingList();
    }
    
      /**
      * A method that calculates the toppings order and returns "toppingOrder" variable
      * @return toppingOrder - the sum of toppings
      */
    private double toppingCalc(){
        double toppingCalc = 0.0;
        
        if (cheese.isSelected()) {
            toppingCalc +=  pizzaNum() * Toppings.CHEESE.getPrice();
        }  if (pepperoni.isSelected()){
             toppingCalc +=  pizzaNum() * Toppings.PEPPERONI.getPrice();
        }  if (mushrooms.isSelected()){
            toppingCalc += pizzaNum() * Toppings.MUSHROOMS.getPrice();
        }  if (olives.isSelected()){
            toppingCalc += pizzaNum() * Toppings.OLIVES.getPrice();
        }
        
        return toppingCalc;
    }
    
    
}
