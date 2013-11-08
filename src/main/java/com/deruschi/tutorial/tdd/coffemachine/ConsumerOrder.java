/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import java.math.BigDecimal;

/**
 *
 * @author derusc
 */
class ConsumerOrder {
    
    private Drink drink;
    private int sugar;
    private BigDecimal amount;
    private boolean extraHot;
    
    ConsumerOrder(Drink drink, int sugar,double amount, boolean extraHot) throws NegativeAmountException{
        this.drink = drink;
        setSugar(sugar);
        setAmount(new BigDecimal(amount));
        this.extraHot = extraHot;
        
    }
    
    public Drink getDrink(){
        return drink;
    }
    
    public int getSugar(){
        return sugar;
    }
    
    public BigDecimal getAmount(){
        return amount;
    }
    
    public boolean isWithSugar(){
       if( 0!= getSugar())
           return true;
       else
           return false;
    }
    
    public boolean isExtraHot(){
        return extraHot;
    }
    
    private void setSugar(int sugar){
        if(sugar>2)
            sugar=2;
        else if(sugar<0)
            sugar=0;
        this.sugar=sugar;
    }
    
    private void setAmount(BigDecimal amount) throws NegativeAmountException  {
        this.amount = amount;
        if(amount.signum()<0){
            throw new NegativeAmountException();
        }
        
        
    }
}
