package VendingMachine;
import VendingMachine.Money.*;

public class VendingMachine {
    private static volatile VendingMachine VendingMachineInstance;
    private Inventory inventory;
    private VendingMachineState currentState;
    private double currentAmount;
    private Product SelectedProduct;
    private final IdleState idlestate;
    private final DispenseState dispensestate;
    private final PaymentState paymentstate;
    private final ReturnChangeState returnchangestate;
    private VendingMachine()
    {
        this.inventory = new Inventory();
        this.idlestate = new IdleState(this);
        this.dispensestate = new DispenseState(this);
        this.paymentstate = new PaymentState(this);
        this.returnchangestate = new ReturnChangeState(this);
        this.currentAmount = 0.0;
        this.currentState = idlestate;
        this.SelectedProduct = null;
    }
    public static synchronized VendingMachine getVMInstance()
    {
        if(VendingMachineInstance==null)
        {
            VendingMachineInstance = new VendingMachine();
        }
        return VendingMachineInstance;
    }
    public Product addProduct(String name,double price,int quantity)
    {
        Product p = new Product(name,price);
        this.inventory.addProduct(p,quantity);
        return p;
    }
    public void selectProduct(Product p)
    {
        currentState.selectProduct(p);
    }
    public void insertCoin(Coin coin)
    {
        currentState.insertCoin(coin);
    }
    public void insertNote(Note note)
    {
        currentState.insertNote(note);
    }
    public void dispenseProduct()
    {
        currentState.dispenseProduct();
    }
    public void returnChange()
    {
        currentState.returnChange();
    }
    public void CancelTransaction()
    {
        currentState.CancelTransaction();
    }
    Product getSelectedProduct() {
        return SelectedProduct;
    }
    void setProduct(Product p)
    {
        SelectedProduct=p;
    }
    void setState(VendingMachineState state)
    {
        this.currentState=state;
    }
    double getCurrentAmount() {
        return currentAmount;
    }
    void ResetCurrentAmount()
    {
        currentAmount=0.0;
    }

    Inventory getInventory()
    {
        return inventory;
    }
    void addCoin(Coin coin)
    {
        this.currentAmount+=coin.getValue();
    }
    void addNote(Note note)
    {
        this.currentAmount+=note.getValue();
    }
    VendingMachineState getIdleState()
    {
        return this.idlestate;
    }
    VendingMachineState getDispenseState()
    {
        return this.dispensestate;
    }
    VendingMachineState getPaymentState()
    {
        return this.paymentstate;
    }
    VendingMachineState getReturnChangeState()
    {
        return this.returnchangestate;
    }
}
