package model;

/**
 *
 * @author ashkanmohseni
 */
public enum Dippings {

    RANCH("Ranch", 1.50),
    GARLIC("Garlic", 1.50),
    MARINARA("Marinara", 1.50),
    BBQ("BBQ", 1.50),
    HOT("Hot", 1.50),
    CHIPOTLE("Chipotle", 1.50);

    private String name;
    private Double price;

    private Dippings(String name, Double price) {
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
