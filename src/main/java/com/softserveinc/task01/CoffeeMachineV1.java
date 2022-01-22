package com.softserveinc.task01;

public class CoffeeMachineV1 extends AbstractCoffeeMachine {

    public CoffeeMachineV1(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
    }


    @Override
    public boolean makeEspresso() {
        return super.makeCoffee(22, 30);
    }

    @Override
    public boolean makeAmericano() {
        return super.makeCoffee(22, 100);
    }
}
