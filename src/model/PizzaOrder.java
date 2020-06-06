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

    public PizzaOrder(int productchoice, int numProduct, int pizzaordrink,
            ArrayList<Toppings> toppingList) {

        if (pizzaordrink == 0) {
            drinksCost = 0;
            setPizza(productchoice);
            setPizzaCost(numProduct);
            setToppingList(toppingList);
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

    public Double setToppingsCost() {
        double toppingsCost = 0;
        if (toppingList != null) {
            for (int i = 0; i <= toppingList.size(); i++) {
                toppingsCost += toppingList.get(i).getPrice();
            }
        } else {
            toppingsCost = 0;
        }
        return toppingsCost;
    }

    public ArrayList<Toppings> getToppingList() {
        return toppingList;
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

    public void topping(Toppings topping) {
        toppingList.add(topping);
    }

    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }
    
      /**
      * A method that calculates the toppings order and returns "toppingOrder" 
      * variable
      * 
      * @return toppingOrder - the sum of toppings
      */
    public String toppingOrder(int numberOfPizzas) {
        String toppingOrder = " ";
        for (int i = 0; i < toppingList.size(); i++) {
            toppingOrder = String.format("\t%n  \t%s %s%n\t%n\n", numberOfPizzas, toppingList.get(i));
        }

        return toppingOrder;
    }
    
    public String toString(int pizzaChoice, int numberOfPizzas, double toppingCalc) {
        String pizzaOrder = " ";
        String finalOrder = " ";

        if (size != null) {
            pizzaOrder = String.format("Pizzas:\t%40.2f%n\n  \t%s %s%n \nToppings:\t%32.2f%n",
                    pizzaCost, numberOfPizzas, PizzaSize.values()[pizzaChoice], toppingCalc);

        }
        finalOrder = pizzaOrder + toppingOrder(numberOfPizzas);
        return finalOrder;
    }

}
