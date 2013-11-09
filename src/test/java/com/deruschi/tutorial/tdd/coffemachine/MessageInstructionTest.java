/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deruschi.tutorial.tdd.coffemachine;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author derusc
 */
public class MessageInstructionTest {
    
    public MessageInstructionTest() {
    }
    
    @Test
    public void messageToInterface(){
        Packet message = Protocol.generateMessage("Message");
        assertEquals("message to Interface","M:Message",message.getMessage());
    }
}
