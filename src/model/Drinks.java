
package model;

/**
 *
 * @author ashkanmohseni
 */
public enum Drinks {
     
     COKE("Coke",1.25),
     JUICE("Juice",1.95),
     PEPSI("Pepsi",1.95),
     FANTA("Fanta",1.95),
     RED_BULL("Red bull",1.95),
     SEVEN_UP("Seven Up",2.25);
     
    private String name;
    private Double price;
    
    private Drinks(String name, Double price){
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
