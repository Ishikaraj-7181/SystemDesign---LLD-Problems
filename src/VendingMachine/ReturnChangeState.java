package VendingMachine;
import VendingMachine.Money.*;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine VendingMachineInstance;
    public ReturnChangeState(VendingMachine vm)
    {
        VendingMachineInstance=vm;
    }
    @Override
    public void selectProduct(Product p){

    }
    @Override
    public void insertCoin(Coin coin){}
    @Override
    public void insertNote(Note note){}
    @Override
    public void dispenseProduct(){}
    @Override
    public void returnChange(){
        double value = VendingMachineInstance.getCurrentAmount()-VendingMachineInstance.getSelectedProduct().getProductPrice();
        if(value>0)
        {
            System.out.println(value +" change is returned.");
        }
        else {
            System.out.println("No change to return.");
        }
        VendingMachineInstance.setState(VendingMachineInstance.getIdleState());
    }
    @Override
    public void CancelTransaction(){
        System.out.println("Transaction cannot be cancelled now.");
    }
}
