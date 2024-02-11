package vendingmachine;

import java.util.StringJoiner;

public enum DrinksMachine {
    COFFEE(46.0, "coffee"),
    TEA(20.5, "tea"),
    LEMONADE(30.0, "lemonade"),
    MOJITO(55.5, "mojito"),
    MINERAL_WATER(25.0, "mineral water"),
    COCA_COLA(30.0, "coca cola");

    private final double price;
    private final String name;

    DrinksMachine(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static String getAllDrinksMachineAsString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (DrinksMachine value : DrinksMachine.values()) {
            stringJoiner.add(value.getName());
        }

        return stringJoiner.toString();
    }

    public static DrinksMachine getInstance(String drink) {
        for (DrinksMachine value : DrinksMachine.values()) {
            if (value.getName().equalsIgnoreCase(drink)) {
                return value;
            }
        }

        return null;
    }
}
