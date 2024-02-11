package vendingmachine;

public class DrinkMaker implements DrinkPreparer {

    @Override
    public void prepareCoffee(DrinksMachine coffee) {
        System.out.printf("Start the machine, grind %s, " +
                "initiate brewing process, and complete the brewing cycle.\n", coffee.getName()
        );
        waitForPreparationProcess(coffee.getName());
    }

    @Override
    public void prepareTea(DrinksMachine tea) {
        System.out.printf("Start the hot water dispenser, steep %s.\n", tea.getName());
        waitForPreparationProcess(tea.getName());
    }

    @Override
    public void prepareMojito(DrinksMachine mojito) {
        System.out.println("Mix ingredients, muddle mint and lime, add rum, ice, and soda water and stir");
        waitForPreparationProcess(mojito.getName());
    }

    @Override
    public void prepareLemonade(DrinksMachine lemonade) {
        System.out.println("Squeeze lemons, mix with water and sugar, stir add ice");
        waitForPreparationProcess(lemonade.getName());
    }

    @Override
    public void prepareMineralWater(DrinksMachine mineralWater) {
        System.out.printf("Dispense %s and serve\n", mineralWater.getName());
    }

    @Override
    public void prepareCocaCola(DrinksMachine cocaCola) {
        System.out.printf("Dispense %s and serve\n", cocaCola.getName());
    }

    private void waitForPreparationProcess(String nameDrink) {
        try {
            Thread.sleep(1500);
            System.out.println("Loading...");
            Thread.sleep(2000);
            System.out.printf("%s preparation is complete.\n", nameDrink);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
