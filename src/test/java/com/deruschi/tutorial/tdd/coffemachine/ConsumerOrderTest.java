/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author derusc
 */
public class ConsumerOrderTest {
    
    public ConsumerOrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDrink() throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(Drink.Coffe,0,Drink.Coffe.getPrice(),false);
        assertEquals(Drink.Coffe, instance.getDrink());        
    }

    @Test
    public void testGetSugarOne() throws NegativeAmountException {       
        ConsumerOrder instance = new ConsumerOrder(null,1,100,true);
        assertEquals(1, instance.getSugar());
    }

    @Test
    public void testGetSugarZero()throws NegativeAmountException{
        ConsumerOrder instance = new ConsumerOrder(null,0,100,true);
        assertEquals(0, instance.getSugar());
    } 
    
    @Test
    public void testGetSugarTwo()throws NegativeAmountException{
        ConsumerOrder instance = new ConsumerOrder(null,2,100,true);
        assertEquals(2, instance.getSugar());
    }
   
    @Test
    public void testGetSugarThree()throws NegativeAmountException{
        ConsumerOrder instance = new ConsumerOrder(null,3,100,true);
        assertEquals(2, instance.getSugar());
    }
    
    @Test
    public void testGetSugarNegative()throws NegativeAmountException{
        ConsumerOrder instance = new ConsumerOrder(null,-1,100,true);
        assertEquals(0, instance.getSugar());
    }
    
    @Test
    public void testGetAmount() throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(null,0,100,true);
        assertEquals(new BigDecimal(100), instance.getAmount());
    }

    @Test(expected = NegativeAmountException.class)
    public void testGetAmountNegative() throws NegativeAmountException {
       new ConsumerOrder(null,0,-100,true);
    }

    
    @Test
    public void testIsWithSugar() throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(null,1,100,true);
        assertTrue(instance.isWithSugar());
    }
    @Test
    public void testIsWithSugarFalse() throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(null,0,100,true);
        assertFalse(instance.isWithSugar());
    }
    @Test
    public void testIsExtraHot()  throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(null,0,100,true);
        assertTrue(instance.isExtraHot());
    }
    @Test
    public void testIsExtraHotFalse()  throws NegativeAmountException {
        ConsumerOrder instance = new ConsumerOrder(null,0,100,false);
        assertFalse(instance.isExtraHot());
    }
}
