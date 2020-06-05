
package model;

/**
 *
 * @author ashkanmohseni
 */
public enum Toppings {
    
     CHEESE("Cheese",1.00),
     PEPPERONI("Pepperoni",1.75),
     MUSHROOMS("Mushrooms",1.25),
     OLIVES("Olives",1.50);
         
    private String name;
    private Double price;
    
    private Toppings(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + " @ $" + getPrice();
    }
 
}
