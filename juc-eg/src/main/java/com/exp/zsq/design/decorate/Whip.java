package com.exp.zsq.design.decorate;

public class Whip extends CondimentDecorator{
    Beverage beverage;
    Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return 0.3 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }
}
