package com.exp.zsq.design.decorate;

/**
 * 具体组件
 */
public class HouseBlend extends Beverage{
    public HouseBlend(){
        desciption = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return 1.09;
    }
}

