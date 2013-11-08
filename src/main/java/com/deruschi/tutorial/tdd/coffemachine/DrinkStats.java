/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import java.math.BigDecimal;

/**
 *
 * @author derusc
 */
public class DrinkStats {
    
    private static int [] count = new int[Drink.values().length];
    private static double total = 0;
    
    public static void incrementStat(Drink drink){
        count[drink.ordinal()] = count[drink.ordinal()] + 1; 
        total += drink.getPrice();
        
    }
    
    public static int getStat(Drink drink){
        return count[drink.ordinal()];
    }
    
    public static double getTotal(){
        return total;
    }
    
    public static void resetStat(){
        count = new int[Drink.values().length];
        total= 0;
    }
}
