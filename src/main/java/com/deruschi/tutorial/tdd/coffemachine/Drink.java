/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

/**
 *
 * @author derusc
 */
public enum Drink {
    Coffe("C",0.6),
    Tea("T",0.4),
    Chocolate("H",0.5),
    OrangeJuice("O",0.6);
    
    Drink(String drinkCode,double price){
        this.drinkCode = drinkCode;
        this.price = price;
    }
    
    private String drinkCode;
    private double price;
    public String getDrinkCode(){
        return drinkCode;
    }
    
    public double getPrice(){
        return price;
    }
}
