
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
import model.Dippings;
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
    @FXML private RadioButton seven_up;
    @FXML private TextField drinkNum;
    @FXML private TextArea receipt;
    @FXML private Button confirm;
    @FXML private Button cancel;
    @FXML private Button exit;
    @FXML private ToggleGroup togglepizzas;
    @FXML private CheckBox tomato;
    @FXML private CheckBox bacon;
    @FXML private CheckBox onion;
    @FXML private CheckBox pineapple;
    @FXML private RadioButton pepsi;
    @FXML private RadioButton fanta;
    @FXML private RadioButton red_bull;
    @FXML private RadioButton ranch;
    @FXML private RadioButton garlic;
    @FXML private RadioButton marinara;
    @FXML private RadioButton bbq;
    @FXML private RadioButton hot;
    @FXML private RadioButton chipotle;
    @FXML private TextField dippingNum;
    
    // an int variable used by pizzaSize() method to access the PizzaSize enums
    private int pizzaChoice = -1;
    private int drinkChoice = -1;
    private int dippingChoice = -1;
    
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
        order.getDippingList().clear();
    }

    @FXML
    private void cancel(ActionEvent event) {
        receipt.setText("");
        small.setSelected(false);
        medium.setSelected(false);
        large.setSelected(false);
        cheese.setSelected(false);
        pepperoni.setSelected(false);
        olives.setSelected(false);
        mushrooms.setSelected(false);
        tomato.setSelected(false);
        bacon.setSelected(false);
        onion.setSelected(false);
        pineapple.setSelected(false);
        coke.setSelected(false);
        juice.setSelected(false);
        seven_up.setSelected(false);
        pepsi.setSelected(false);
        fanta.setSelected(false);
        red_bull.setSelected(false);
        ranch.setSelected(false);
        garlic.setSelected(false);
        marinara.setSelected(false);
        bbq.setSelected(false);
        hot.setSelected(false);
        chipotle.setSelected(false);
        dippingNum.setText("");
        pizzaNum.setText("");
        drinkNum.setText("");
    }

    @FXML
    private void exit(ActionEvent event) {
         System.exit(0);
    }
    
    private int calculation(){
         
//        if (pizzaChoice >= 0 && drinkChoice == -1) {
//             PizzaOrder order = new PizzaOrder(pizzaSize(), pizzaNum(), topping(), toppingCalc(), drinks(), 0, 0, -1);
//              receipt.setText(order.toString() );
//        }

         PizzaOrder order = new PizzaOrder(pizzaSize(), pizzaNum(), topping(), toppingCalc(), drinks(), drinkCalc(), 
                 drinkNum(), drinkType(), dippings(), dippingCalc(), dippingNum(), dippingType());
         
              receipt.setText(order.toString() );
        
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
        if (seven_up.isSelected()) {
           order.drink(Drinks.SEVEN_UP);
        }
        if (pepsi.isSelected()) {
           order.drink(Drinks.PEPSI);
        }
        if (fanta.isSelected()) {
           order.drink(Drinks.FANTA);
        }
        if (red_bull.isSelected()) {
           order.drink(Drinks.RED_BULL);
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
        if (seven_up.isSelected()) {
            drinkChoice = 2;
        }
        if (pepsi.isSelected()) {
            drinkChoice = 3;
        }
        if (fanta.isSelected()) {
            drinkChoice = 4;
        }
        if (red_bull.isSelected()) {
            drinkChoice = 5;
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
        }  if (seven_up.isSelected()){
            drinkCalc += drinkNum() * Drinks.SEVEN_UP.getPrice();
        } if (pepsi.isSelected()){
            drinkCalc += drinkNum() * Drinks.PEPSI.getPrice();
        } if (fanta.isSelected()){
            drinkCalc += drinkNum() * Drinks.FANTA.getPrice();
        } if (red_bull.isSelected()){
            drinkCalc += drinkNum() * Drinks.RED_BULL.getPrice();
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
        if (tomato.isSelected()) {
            order.topping(Toppings.TOMATO);
        }
        if (bacon.isSelected()) {
            order.topping(Toppings.BACON);
        }
        if (onion.isSelected()) {
            order.topping(Toppings.ONION);
        }
        if (pineapple.isSelected()) {
            order.topping(Toppings.PINEAPPLE);
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
        }  if (tomato.isSelected()){
            toppingCalc += pizzaNum() * Toppings.TOMATO.getPrice();
        }  if (bacon.isSelected()){
            toppingCalc += pizzaNum() * Toppings.BACON.getPrice();
        }  if (onion.isSelected()){
            toppingCalc += pizzaNum() * Toppings.ONION.getPrice();
        }  if (pineapple.isSelected()){
            toppingCalc += pizzaNum() * Toppings.PINEAPPLE.getPrice();
        }
        
        return toppingCalc;
    }
    
    public ArrayList<Dippings> dippings(){
        if (ranch.isSelected()) {
           order.setDippings(Dippings.RANCH);
        }
        if (garlic.isSelected()) {
           order.setDippings(Dippings.GARLIC);
        }
        if (marinara.isSelected()) {
           order.setDippings(Dippings.MARINARA);
        }
        if (bbq.isSelected()) {
           order.setDippings(Dippings.BBQ);
        }
        if (hot.isSelected()) {
           order.setDippings(Dippings.HOT);
        }
        if (chipotle.isSelected()) {
           order.setDippings(Dippings.CHIPOTLE);
        }
        return order.getDippingList();
    }
        
       private int dippingType(){
        if(ranch.isSelected()){
            dippingChoice = 0;
        }
        if (garlic.isSelected()) {
            dippingChoice = 1;
        }
        if (marinara.isSelected()) {
            dippingChoice = 2;
        }
        if (bbq.isSelected()) {
            dippingChoice = 3;
        }
        if (hot.isSelected()) {
            dippingChoice = 4;
        }
        if (chipotle.isSelected()) {
            dippingChoice = 5;
        }
        return dippingChoice;
    }
       
      /**
      * A method that calculates the total of dips order and returns "dippingCalc" variable
      * @return DippingCalc - the sum of dips
      */
       private double dippingCalc(){
        double dippingCalc = 0.0;
        
        if (ranch.isSelected()) {
            dippingCalc +=  dippingNum() * Dippings.RANCH.getPrice();
        }  if (garlic.isSelected()){
             dippingCalc +=  dippingNum() * Dippings.GARLIC.getPrice();
        }  if (marinara.isSelected()){
            dippingCalc += dippingNum() * Dippings.MARINARA.getPrice();
        } if (bbq.isSelected()){
            dippingCalc += dippingNum() * Dippings.BBQ.getPrice();
        } if (hot.isSelected()){
            dippingCalc += dippingNum() * Dippings.HOT.getPrice();
        } if (chipotle.isSelected()){
            dippingCalc += dippingNum() * Dippings.CHIPOTLE.getPrice();
        } 
        
        return dippingCalc;
    }

       /**
      * Returns "number" an Integer variable as the number of dips being purchased
      * @return number  
      */
    private int dippingNum(){
        int number = -1;
        try{
            number = Integer.parseInt(dippingNum.getText().trim());            
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return number;
    }
    
    
    
   
}
