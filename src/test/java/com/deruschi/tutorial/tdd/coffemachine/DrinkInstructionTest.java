/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import java.math.BigDecimal;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
        
/**
 *
 * @author derusc
 */
public class DrinkInstructionTest {

    ConsumerOrder mockedOrder;
    @Before
    public void setUP(){
        mockedOrder = mock(ConsumerOrder.class);
    }
    
    @After
    public void tearDown(){
        mockedOrder = null;
    }
    
    @Test
    public void coffeDrinkInstruction() {
        when(mockedOrder.getDrink()).thenReturn(Drink.Coffe);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);

        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("Coffe request","C::",message.getMessage());
        
    }
    
    @Test
    public void teaDrinkInstruction(){
                
        when(mockedOrder.getDrink()).thenReturn(Drink.Tea);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);        
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("Tea request","T::",message.getMessage());
    }
    
    @Test
    public void chocolateDrinkInstruction() throws NegativeAmountException{
                
        when(mockedOrder.getDrink()).thenReturn(Drink.Chocolate);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("Chocolate request","H::",message.getMessage());
    }
    
    @Test
    public void orangeJuiceDrinkInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.OrangeJuice);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("Orange juice request","O::",message.getMessage());
    }
    
    
    @Test
    public void noSugarInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Coffe);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("no Sugar request","C::",message.getMessage());
    }
    
    @Test
    public void oneSugarInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Coffe);
        when(mockedOrder.getSugar()).thenReturn(1);
        when(mockedOrder.isWithSugar()).thenReturn(true);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("one Sugar request", "C:1:0", message.getMessage());
    }
    
    @Test 
    public void twoSugarInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Coffe);
        when(mockedOrder.getSugar()).thenReturn(2);
        when(mockedOrder.isWithSugar()).thenReturn(true);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(false);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("two Sugar request", "C:2:0", message.getMessage());
    }
   
    @Test
    public void coffeExtraHotInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Coffe);
        when(mockedOrder.getSugar()).thenReturn(0);
        when(mockedOrder.isWithSugar()).thenReturn(false);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(true);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("coffe Extra Hot", "Ch::", message.getMessage());
    }
    
    @Test
    public void teaExtraHotInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Tea);
        when(mockedOrder.getSugar()).thenReturn(1);
        when(mockedOrder.isWithSugar()).thenReturn(true);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(true);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("tea Extra Hot", "Th:1:0", message.getMessage());
    }
    
    @Test
    public void chocolateExtraHotInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.Chocolate);
        when(mockedOrder.getSugar()).thenReturn(2);
        when(mockedOrder.isWithSugar()).thenReturn(true);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(true);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("chocolate Extra Hot", "Hh:2:0", message.getMessage());
    }
    
    @Test
    public void orangeExtraHotWithSugarInstruction() throws NegativeAmountException{
        when(mockedOrder.getDrink()).thenReturn(Drink.OrangeJuice);
        when(mockedOrder.getSugar()).thenReturn(2);
        when(mockedOrder.isWithSugar()).thenReturn(true);
        when(mockedOrder.getAmount()).thenReturn(new BigDecimal(100));        
        when(mockedOrder.isExtraHot()).thenReturn(true);
        Packet message = Protocol.generateCommand(mockedOrder);
        assertEquals("oragne juice Extra Hot with Sugar", "O::", message.getMessage());
    }
}
