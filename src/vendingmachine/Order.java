package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Order {
    private static double finalPrice;
    private List<DrinksMachine> orders;

    public Order() {
        this.orders = new ArrayList<>();
    }

    public static double getFinalPrice() {
        return finalPrice;
    }

    public static void setFinalPrice(double finalPrice) {
        Order.finalPrice = finalPrice;
    }

    public void addDrink(DrinksMachine drink) {
        orders.add(drink);
    }

    public void cancelDrink(DrinksMachine drink) {
        orders.remove(drink);
    }

    public double getTotalPrice() {
        double price = 0;
        for (DrinksMachine drinksMachine : orders) {
            price += drinksMachine.getPrice();
        }

        return price;
    }

    public List<DrinksMachine> getOrder() {
        return new ArrayList<>(orders);
    }

    public String getOrdersInString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (DrinksMachine drink : orders) {
            stringJoiner.add(drink.getName());
        }

        return stringJoiner.toString();
    }
}
