package com.exp.zsq.design.decorate;

/**
 * 具体组件
 */
public class Espresso extends Beverage{
    public Espresso(){
        desciption = "Espresso";
    }
    @Override
    public double cost() {
        return 1.09;
    }
}
