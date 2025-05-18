package VendingMachine;
import VendingMachine.Money.Coin;
import VendingMachine.Money.Note;

public class IdleState implements VendingMachineState {
    private final VendingMachine VendingMachineInstance;
    public IdleState(VendingMachine vm)
    {
        VendingMachineInstance=vm;
    }
    @Override
    public void selectProduct(Product p){
        if(VendingMachineInstance.getInventory().isAvailable(p))
        {
            VendingMachineInstance.setProduct(p);
            VendingMachineInstance.setState(VendingMachineInstance.getPaymentState());
        }
        else
        {
            System.out.println(p.getProductName() + " is not available.");
        }
    }
    @Override
    public void insertCoin(Coin coin){
        System.out.println("Please select the product first.");
    }
    @Override
    public void insertNote(Note note){
        System.out.println("Please select the product first.");
    }
    @Override
    public void dispenseProduct(){
        System.out.println("Please select the product first and make payment.");
    }
    @Override
    public void returnChange(){
        System.out.println("No change to return.");
    }
    @Override
    public void CancelTransaction(){
       // VendingMachineInstance.setState(VendingMachineInstance.getIdleState());
        VendingMachineInstance.setProduct(null);
    }
}
