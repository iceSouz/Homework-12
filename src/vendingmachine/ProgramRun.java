package vendingmachine;


public class ProgramRun {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        customerService.chooseOrder();
        customerService.closedScanner();
    }
}
