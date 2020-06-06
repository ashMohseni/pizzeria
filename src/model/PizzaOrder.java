
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

    public PizzaOrder(int drinkNum, int pizzaNum, double pizzaCost, double drinksCost,
            double toppingsCost, PizzaSize size, Drinks drinks) {
        this.drinkNum = drinkNum;
        this.pizzaNum = pizzaNum;
        this.pizzaCost = pizzaCost;
        this.drinksCost = drinksCost;
        this.toppingsCost = toppingsCost;
        this.size = size;
        this.drinks = drinks;
    }  

    public void setPizzaCost(double pizzaCost) {
        this.pizzaCost = pizzaCost;
    }

    public void setDrinksCost(double drinksCost) {
        this.drinksCost = drinksCost;
    }

    public void setToppingsCost(double toppingsCost) {
        this.toppingsCost = toppingsCost;
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

    @Override
    public String toString() {
        return "PizzaOrder{" + '}';
    }

}
