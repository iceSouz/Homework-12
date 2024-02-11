package vendingmachine;

public interface DrinkPreparer {
    void prepareCoffee(DrinksMachine coffee);
    void prepareTea(DrinksMachine tea);
    void prepareMojito(DrinksMachine mojito);
    void prepareLemonade(DrinksMachine lemonade);
    void prepareMineralWater(DrinksMachine mineralWater);
    void prepareCocaCola(DrinksMachine cocaCola);
}
