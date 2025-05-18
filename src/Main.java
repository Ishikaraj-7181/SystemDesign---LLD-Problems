import VendingMachine.*;
import VendingMachine.Money.Coin;
import VendingMachine.Money.Note;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        VendingMachine vendingmachine=VendingMachine.getVMInstance();
        Product p1 = vendingmachine.addProduct("Coke",40,2);
        Product p2 = vendingmachine.addProduct("Lays",20,1);
        vendingmachine.selectProduct(p2);
        vendingmachine.insertCoin(Coin.QUARTER);
        vendingmachine.insertNote(Note.TWENTY);
        vendingmachine.insertNote(Note.ONE);
        vendingmachine.dispenseProduct();
        vendingmachine.returnChange();
    }
}