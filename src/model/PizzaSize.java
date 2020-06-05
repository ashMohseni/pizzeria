
package model;

/**
 *
 * @author ashkanmohseni
 */
public enum PizzaSize {
     
    SMALL("Small",5.25),
    MEDIUM("Medium",7.50),
    LARGE("Large",9.95);
    
    private String name;
    private Double price;
    
    private PizzaSize(String name, Double price){
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
