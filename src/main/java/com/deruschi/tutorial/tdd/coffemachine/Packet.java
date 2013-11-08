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
class Packet {
     
    private String msg;
    
    Packet(String msg){
        this.msg = msg;
    }
    
    public String getMessage(){
        return this.msg;
    }
}
