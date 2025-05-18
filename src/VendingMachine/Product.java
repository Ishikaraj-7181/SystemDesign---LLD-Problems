package VendingMachine;

public class Product {
    private final String name;
    private double price;
    public Product(String name,double price)
    {
        this.name = name;
        this.price = price;
    }
    public String getProductName() {
        return this.name;
    }
    public double getProductPrice()
    {
        return this.price;
    }
}
