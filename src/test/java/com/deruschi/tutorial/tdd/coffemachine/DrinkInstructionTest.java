/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tdd.coffemachine.Drink;
import com.deruschi.tutorial.tdd.coffemachine.Packet;
import com.deruschi.tutorial.tdd.coffemachine.ConsumerOrder;
import com.deruschi.tutorial.tdd.coffemachine.Protocol;
import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author derusc
 */
public class DrinkInstructionTest {

    @Test
    public void coffeDrink() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,0,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("Coffe request","C::",message.getMessage());
        
    }
    
    @Test
    public void teaDrink() throws NegativeAmountException{
                
        ConsumerOrder order = new ConsumerOrder(Drink.Tea,0,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("Tea request","T::",message.getMessage());
    }
    
    @Test
    public void chocolateDrink() throws NegativeAmountException{
                
        ConsumerOrder order = new ConsumerOrder(Drink.Chocolate,0,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("Chocolate request","H::",message.getMessage());
    }
    
    @Test
    public void orangeJuiceDrink() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.OrangeJuice,0,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("Orange juice request","O::",message.getMessage());
    }
    
    
    @Test
    public void noSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,0,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("no Sugar request","C::",message.getMessage());
    }
    
    @Test
    public void oneSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,1,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("one Sugar request", "C:1:0", message.getMessage());
    }
    
    @Test 
    public void twoSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,2,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("two Sugar request", "C:2:0", message.getMessage());
    }
    
    @Test 
    public void negativeSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,-1,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("negative Sugar request", "C::", message.getMessage());
    }
    
    @Test 
    public void overTwoSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,3,100,false);
        Packet message = Protocol.generateCommand(order);
        assertEquals("over two Sugar request", "C:2:0", message.getMessage());
    }
    
    @Test
    public void messageToInterface() throws NegativeAmountException{
        Packet message = Protocol.generateMessage("Message");
        assertEquals("message to Interface","M:Message",message.getMessage());
    }
   
    @Test
    public void coffeExtraHot() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Coffe,0,100,true);
        Packet message = Protocol.generateCommand(order);
        assertEquals("coffe Extra Hot", "Ch::", message.getMessage());
    }
    
    @Test
    public void teaExtraHot() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Tea,1,100,true);
        Packet message = Protocol.generateCommand(order);
        assertEquals("tea Extra Hot", "Th:1:0", message.getMessage());
    }
    
    @Test
    public void chocolateExtraHot() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.Chocolate,2,100,true);
        Packet message = Protocol.generateCommand(order);
        assertEquals("chocolate Extra Hot", "Hh:2:0", message.getMessage());
    }
    
    @Test
    public void orangeExtraHotWithSugar() throws NegativeAmountException{
        ConsumerOrder order = new ConsumerOrder(Drink.OrangeJuice,2,100,true);
        Packet message = Protocol.generateCommand(order);
        assertEquals("oragne juice Extra Hot with Sugar", "O::", message.getMessage());
    }
}
