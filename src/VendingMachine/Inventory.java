package VendingMachine;

import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class Inventory {
    private final Map<Product, Integer> products;
    public Inventory()
    {
        products = new ConcurrentHashMap<>();
    }
    public void addProduct(Product p,int quantity)
    {
        products.put(p,products.getOrDefault(p,0)+quantity);
    }
    public void removeProduct(Product p)
    {
        if(products.containsKey(p) && products.get(p)>=1)
        {
            int value = products.get(p)-1;
            if(value>0)
            {
                products.put(p,value);
            }
            else
            {
                products.remove(p);
            }
            System.out.println("Dispensed product "+p.getProductName());
            return;
        }
        System.out.println("Product is not available.");

    }
    public void updateProduct(Product p,int quantity)
    {
        products.put(p,quantity);
    }
    public int getProductQuantity(Product p)
    {
        return products.get(p);
    }
    public boolean isAvailable(Product p)
    {
        int value = 0;
        if(products.containsKey(p))
        {
           value = products.get(p);
        }
        return value>0;
    }
}
