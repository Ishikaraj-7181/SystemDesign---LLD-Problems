package VendingMachine;
import VendingMachine.Money.*;

public interface VendingMachineState {
    void selectProduct(Product p);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
    void CancelTransaction();
}
