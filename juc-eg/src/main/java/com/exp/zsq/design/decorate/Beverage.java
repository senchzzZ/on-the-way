package com.exp.zsq.design.decorate;

/**
 * 抽象组件
 */
public abstract class Beverage {
    String desciption = "Unknown Beverage";

    public String getDescription(){
        return desciption;
    }
    public abstract double cost();
}
