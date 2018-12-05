package com.exp.zsq.design.decorate;

/**
 * 装饰者
 */
public class Moca extends CondimentDecorator{
    Beverage beverage;
    public Moca(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Moca";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
