package vendingmachine;


import java.util.Scanner;

public class CustomerService {
    private Order order = new Order();
    private DrinkPreparer drinkPreparer = new DrinkMaker();
    private Scanner scanner = new Scanner(System.in);

    public void chooseOrder() {
        System.out.printf("Please select a beverage: coffee = %.1f; tea = %.1f; lemonade = %.1f; mojito = %.1f; " +
                        "mineral water = %.1f; coca cola = %.1f. " +
                        "\nIf you choose 'Exit', please complete your order.\n",
                DrinksMachine.COFFEE.getPrice(), DrinksMachine.TEA.getPrice(), DrinksMachine.LEMONADE.getPrice(),
                DrinksMachine.MOJITO.getPrice(), DrinksMachine.MINERAL_WATER.getPrice(),
                DrinksMachine.COCA_COLA.getPrice()
        );
        boolean isOrder = offerChoice("Select the next beverage, or complete your order.", true);

        if (!isOrder) {
            return;
        }

        System.out.printf("You have placed an order totaling = %.1f. " +
                        "If you wish to cancel any beverage, please specify its name: %s. Otherwise, write 'Exit'\n",
                order.getTotalPrice(), order.getOrdersInString()
        );
        boolean isCancel = offerChoice("Do you wish to cancel any other beverage?", false);

        if (!isCancel) {
            return;
        }

        Order.setFinalPrice(order.getTotalPrice());

        if (isPaid()) {
            printPreparationProcess();
        }
    }

    public void closedScanner() {
        scanner.close();
    }

    private void printPreparationProcess() {
        for (DrinksMachine drinksMachine : order.getOrder()) {
            try {
                switch (drinksMachine) {
                    case COCA_COLA:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareCocaCola(drinksMachine);
                        break;
                    case TEA:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareTea(drinksMachine);
                        break;
                    case MOJITO:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareMojito(drinksMachine);
                        break;
                    case MINERAL_WATER:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareMineralWater(drinksMachine);
                        break;
                    case COFFEE:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareCoffee(drinksMachine);
                        break;
                    case LEMONADE:
                        order.addDrink(drinksMachine);
                        drinkPreparer.prepareLemonade(drinksMachine);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported drink: " + drinksMachine);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Error " + iae.getMessage());
            }
        }
    }

    private boolean offerChoice(String makeChoice, boolean modifyOrder) {
        String choice = scanner.nextLine();

        while (!choice.equalsIgnoreCase("exit")) {
            DrinksMachine drink = DrinksMachine.getInstance(choice);
            if (modifyOrder) {
                if (drink == null) {
                    System.out.printf("'%s' is not a valid choice. Please choose one of the options: %s or 'exit'\n",
                            choice, DrinksMachine.getAllDrinksMachineAsString());
                } else {
                    order.addDrink(drink);
                    System.out.println(makeChoice);
                }
            } else {
                if (drink == null || !order.getOrder().contains(drink)) {
                    System.out.printf("'%s' is not a valid choice or it's not in your order. " +
                                    "Please choose one of the options: %s or 'exit'\n",
                            choice, order.getOrdersInString());
                } else {
                    order.cancelDrink(drink);
                    if (order.getOrder().isEmpty()) {
                        System.out.println("You have completely canceled your order!");
                        return false;
                    }
                    System.out.println(makeChoice);
                }
            }

            choice = scanner.nextLine();
        }

        if (order.getOrder().isEmpty()) {
            System.out.println("You haven't ordered anything!");
        }

        return !order.getOrder().isEmpty();
    }

    private boolean isPaid() {
        System.out.printf("The final price of the order is: %.1f\n", Order.getFinalPrice());
        System.out.println("Select 'Yes' if you wish to pay, or 'No' if you are canceling the order.");

        while (true) {
            String payment = scanner.nextLine();
            if (payment.equalsIgnoreCase("yes")) {
                return true;
            }

            if (payment.equalsIgnoreCase("no")) {
                return false;
            }

            System.out.println("You have selected a non-existent option. Please choose again!");
        }
    }
}
