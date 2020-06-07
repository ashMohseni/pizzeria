package model;

import java.util.ArrayList;

/**
 *
 * @author ashkan mohseni
 */
public class PizzaOrder {

    private int pizzaChoice;
    private int drinkType;
    private int drinkNum;
    private int pizzaNum;
    private double pizzaCost;
    private double drinksCost;
    private double toppingsCost;
    private PizzaSize size;
    private Drinks drinks;
    private ArrayList<Toppings> toppingList = new ArrayList<>();
    private ArrayList<Drinks> drinkList = new ArrayList<>();

    public PizzaOrder() {
    }

    public PizzaOrder(int pizzaSize, int pizzaNum, ArrayList<Toppings> topping, double toppingCalc,
            ArrayList<Drinks> drink, double drinkCalc, int drinkNum, int drinkType) {
        setPizza(pizzaSize);
        setPizzaChoice(pizzaSize);
        setPizzaCost(pizzaNum);
        setPizzaNum(pizzaNum);
        setToppingList(topping);
        setToppingsCost(toppingCalc);
        setDrinkList(drink);
        setDrinksCost(drinkCalc);
        setDrinkNum(drinkNum);
        setDrinkType(drinkType);
    }

    public void setPizzaCost(int pizzaNum) { 
        if (pizzaNum == -1) {
              this.pizzaCost = pizzaCost;
        } else {
        pizzaCost = pizzaNum * size.getPrice();
        }
    }

    public void setPizzaChoice(int pizzaChoice) {
        this.pizzaChoice = pizzaChoice;
    }

    public void setDrinksCost(double drinksCost) {
        this.drinksCost = drinksCost;
    }

    public void setToppingsCost(double toppingsCost) {
        this.toppingsCost = toppingsCost;
    }

    public ArrayList<Toppings> getToppingList() {
        return toppingList;
    }

    public void setPizza(int pizzaChoice) {
        if (pizzaChoice == -1) {
            this.pizzaChoice = pizzaChoice;
        } else{
        size = PizzaSize.values()[pizzaChoice];
        }
    }
    public void setDrinkType(int drinkType) {
        if (!(drinkType >=0) ) {
            this.drinkType = drinkType;
        } else{
        drinks = Drinks.values()[drinkType];
        }
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

    public void setDrinkList(ArrayList<Drinks> drinkList) {
        this.drinkList = drinkList;
    }

    public void drink(Drinks drinks) {
        drinkList.add(drinks);
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }

    public void setPizzaNum(int pizzaNum) {
        this.pizzaNum = pizzaNum;
    }

    public void setPizzaCost(double pizzaCost) {
        this.pizzaCost = pizzaCost;
    }

    public ArrayList<Drinks> getDrinkList() {
        return drinkList;
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
            toppingOrder += String.format("\t%n  \t%s %s%n\t%n", numberOfPizzas, toppingList.get(i));
        }

        return toppingOrder;
    }

    /**
     * A method that calculates the pizza order and returns "finalPizza"
     * variable
     *
     * @return finalPizza - the sum of pizza + toppings
     */
    public String PizzaOrder() {
        String PizzaTitle = " ";
        String pizzaOrder = " ";
        String toppingOrder = " ";

        if (size != null) {
            pizzaOrder += String.format("Pizzas:\t%40.2f%n\n  \t%s %s%n \nToppings:\t%32.2f%n",
                    pizzaCost, pizzaNum, PizzaSize.values()[pizzaChoice], toppingsCost);

            for (int i = 0; i < toppingList.size(); i++) {
                toppingOrder += String.format("\t%n  \t%s %s%n\t%n", pizzaNum, toppingList.get(i));
            }

        }
        String finalPizza = pizzaOrder + toppingOrder;
        return finalPizza;
    }

    /**
     * A method that calculates the Drinks ordered and returns "finalDrink"
     * variable
     *
     * @return finalDrink - the sum of drinks
     */
    public String DrinkOrder() {
        String drinksTitle = " ";
        String drinksOrder = " ";

        drinksTitle = String.format("Drinks:\t%40.2f%n ", drinksCost);

        for (int i = 0; i < drinkList.size(); i++) {
            drinksOrder += String.format("%n \t%s %s%n", drinkNum, drinkList.get(i));
        }
        String finalDrink = drinksTitle + drinksOrder;
        return finalDrink;
    }

    public String toString() {
        String finalPrint = " ";
        
        // when everything has been ordered
        if (pizzaChoice >= 0 && drinkType >= 0  ) {
            finalPrint = PizzaOrder() + DrinkOrder();
        } else if (pizzaChoice >= 0 && toppingsCost ==0){
            finalPrint = "\t**ERROR**\nYou should at least choose one topping";
        } else if (pizzaChoice >= 0 ) {
            finalPrint = PizzaOrder();
        } else if (drinkType >= 0 ) {
            finalPrint = DrinkOrder();
        } 

        
        
        return finalPrint;
    }

}
