/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import java.math.BigDecimal;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author derusc
 */
public class DrinkMoneyTest {
    
    public DrinkMoneyTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void enoughMoney() throws NegativeAmountException{
        double insertedMoney = 1;
        ConsumerOrder order;
        order = new ConsumerOrder(Drink.Coffe,1,insertedMoney,false);
        Packet pkt = Protocol.generateCommand(order);
        assertEquals("Enough money","C:1:0",pkt.getMessage());
    }
    
    @Test 
    public void notEnoghMoney() throws NegativeAmountException{
        double insertedMoney = 0;
        ConsumerOrder order;
        order = new ConsumerOrder(Drink.Coffe,1,insertedMoney,false);
        Packet pkt = Protocol.generateCommand(order);
        BigDecimal missingMoney = new BigDecimal(Drink.Coffe.getPrice()-insertedMoney);
        assertEquals("Not enough money","M:Insert " + missingMoney.doubleValue() + " more.",pkt.getMessage());
    }
}