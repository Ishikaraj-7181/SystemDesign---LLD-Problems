package VendingMachine;
import VendingMachine.Money.*;

public class PaymentState implements VendingMachineState {
    private final VendingMachine VendingMachineInstance;
    public PaymentState(VendingMachine vm)
    {
        VendingMachineInstance=vm;
    }
    @Override
    public void selectProduct(Product p){
           System.out.println(p.getProductName() + " is selected, please make a payment now.");
    }
    @Override
    public void insertCoin(Coin coin){
        VendingMachineInstance.addCoin(coin);
        checkPaymentStatus();
    }
    @Override
    public void insertNote(Note note){
        VendingMachineInstance.addNote(note);
        checkPaymentStatus();
    }
    @Override
    public void dispenseProduct(){}
    @Override
    public void returnChange(){}
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

    private void checkPaymentStatus()
    {
        if(VendingMachineInstance.getCurrentAmount()>=VendingMachineInstance.getSelectedProduct().getProductPrice())
        {
            VendingMachineInstance.setState(VendingMachineInstance.getDispenseState());
        }
    }

}
