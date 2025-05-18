package VendingMachine;
import VendingMachine.Money.*;

public class DispenseState implements VendingMachineState {
    private final VendingMachine VendingMachineInstance;
    public DispenseState(VendingMachine vm)
    {
        VendingMachineInstance=vm;
    }
    @Override
    public void selectProduct(Product p){
        System.out.println(p.getProductName() + " is selected, and payment is made please dispense the product.");
    }
    @Override
    public void insertCoin(Coin coin){
        System.out.println("Payment is made please dispense the product.");
    }
    @Override
    public void insertNote(Note note){
        System.out.println("Payment is made please dispense the product.");
    }
    @Override
    public void dispenseProduct(){
        VendingMachineInstance.setState(VendingMachineInstance.getReturnChangeState());
        System.out.println("Please collect the product.");
    }
    @Override
    public void returnChange(){
        System.out.println("Please collect the dispensed product first.");
    }
    @Override
    public void CancelTransaction(){
        if(VendingMachineInstance.getCurrentAmount()>0)
        {
            System.out.println("Please collect the inserted money." + VendingMachineInstance.getCurrentAmount());
            VendingMachineInstance.ResetCurrentAmount();
        }
        VendingMachineInstance.setState(VendingMachineInstance.getIdleState());
        System.out.println("Transaction cancelled successfully.");
    }
}
