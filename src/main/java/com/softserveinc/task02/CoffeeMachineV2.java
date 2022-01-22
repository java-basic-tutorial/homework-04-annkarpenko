package com.softserveinc.task02;

import com.softserveinc.task01.CoffeeMachineV1;

public class CoffeeMachineV2 extends CoffeeMachineV1 {

    protected final int milkReservoirCapacity;
    private int milk;
    protected final int milkForCappuccino = 85;
    protected final int milkForLatte = 150;

    public CoffeeMachineV2(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity, int milkReservoirCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
        this.milkReservoirCapacity = milkReservoirCapacity;
    }

    public void addMilk(int milk) {
        this.milk = Math.min(milk + this.milk, milkReservoirCapacity);
    }

    public int getMilk() {
        return milk;
    }

    private boolean makeDrink(int milkRequired) {
        if (!super.makeEspresso()) {
            return false;
        }
        boolean makeDrink = milkRequired <= this.getMilk();
        if (makeDrink) {
            this.milk -= milkRequired;
        } else {
            System.err.println("Not enough milk");
        }
        return makeDrink;
    }

    public boolean makeCappuccino() {
        return  makeDrink(milkForCappuccino);
    }

    public boolean makeLatte() {
        return  makeDrink(milkForLatte);
    }
}
