
package model;

import java.util.ArrayList;

/**
 *
 * @author ashkan mohseni
 */
public class PizzaOrder {
    
     private int drinkNum;
     private int pizzaNum;
     private double pizzaCost;
     private double drinksCost;
     private double toppingsCost;
     private PizzaSize size;
     private Drinks drinks;
     private ArrayList<Toppings> toppingList = new ArrayList<>();

    public PizzaOrder() {
    }
    
     public PizzaOrder(int productchoice, int numProduct, int pizzaordrink) {
          if (pizzaordrink == 0) {
               drinksCost = 0;
               setPizza(productchoice);
               setPizzaCost(numProduct);
          } else {
               pizzaCost = 0;
               setPizzaCost(productchoice);
               setDrinksCost(numProduct);
          }
     }

    public void setPizzaCost(int pizzaNum) {
        this.pizzaCost = pizzaCost;
        pizzaCost = pizzaNum * size.getPrice();
    }

    public void setDrinksCost(double drinksCost) {
        this.drinksCost = drinksCost;
    }

    public void setToppingsCost(double toppingsCost) {
        this.toppingsCost = toppingsCost;
    }
      
    public void setPizza(int pizzaChoice) {
          size = PizzaSize.values()[pizzaChoice];
     }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    public String toString( int pizzaChoice, int numberOfPizzas) {
        String pizzaOrder = " ";
        
        if (size != null) {
            pizzaOrder = String.format("Pizzas:\t%40.2f%n  \t%s %s%n Toppings:\t%n",
                       pizzaCost, numberOfPizzas + " " , PizzaSize.values()[pizzaChoice]);
        }
        return pizzaOrder;
    }

}
