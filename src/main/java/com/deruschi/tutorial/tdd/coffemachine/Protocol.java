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
public class Protocol {
    
    private final static String SEP = ":";
    private final static String MESSAGE = "M";
    private final static String WITH_STICK = "0";
    private final static String EXTRA_HOT = "h";
    public static Packet generateCommand(ConsumerOrder order){
        
       return checkMoney(order);
        
    }
    
    public static Packet generateMessage(String message){
        return new Packet(MESSAGE+SEP+message);
    }

    private static Packet checkMoney(ConsumerOrder order) {
        
        BigDecimal missingMoney = new BigDecimal(order.getDrink().getPrice()).subtract(order.getAmount());
        if(missingMoney.compareTo(BigDecimal.ZERO) <=0 ){
            return generatePacket(order);
        }else{
            return generateMessage("Insert " + missingMoney.doubleValue() + " more.");
        }
    }

    private static Packet generatePacket(ConsumerOrder order) {
        
        DrinkStats.incrementStat(order.getDrink());
        
        String cmd = order.getDrink().getDrinkCode();        
        if(order.isExtraHot() && order.getDrink()!=Drink.OrangeJuice){
            cmd += EXTRA_HOT;
        }
        
        cmd+= SEP;
        if(order.isWithSugar() && order.getDrink()!=Drink.OrangeJuice){
            cmd+= order.getSugar();
            cmd+= SEP;
            cmd+= WITH_STICK;
        }else
            cmd+=SEP;
        return new Packet(cmd);
    }
    
}
