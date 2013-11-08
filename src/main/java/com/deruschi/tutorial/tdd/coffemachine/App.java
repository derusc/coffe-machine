package com.deruschi.tutorial.tdd.coffemachine;

import com.deruschi.tutorial.tddcoffemachine.exception.NegativeAmountException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Test Driven Development Example" );
        try {
            ConsumerOrder order = new ConsumerOrder(Drink.Coffe, 0, 4, true);
        } catch (NegativeAmountException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
