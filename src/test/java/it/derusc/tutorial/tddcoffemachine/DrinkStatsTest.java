/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.derusc.tutorial.tddcoffemachine;

import it.derusc.tutorial.tddcoffemachine.exception.NegativeAmountException;
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
public class DrinkStatsTest {

    public DrinkStatsTest() {
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
        DrinkStats.resetStat();
    }

    @Test
    public void firstCoffeStat() throws NegativeAmountException {
        Protocol.generateCommand(new ConsumerOrder(Drink.Coffe, 0, 100, false));
        int count = DrinkStats.getStat(Drink.Coffe);
        assertEquals("First coffe", 1, count);
    }

    @Test
    public void firstTeaStat() throws NegativeAmountException{
        Protocol.generateCommand(new ConsumerOrder(Drink.Tea, 0, 100, true));
        int count = DrinkStats.getStat(Drink.Tea);
        assertEquals("First tea", 1, count);
    }

    @Test
    public void firstChocolate() throws NegativeAmountException{
        Protocol.generateCommand(new ConsumerOrder(Drink.Chocolate, 0, 100, true));
        int count = DrinkStats.getStat(Drink.Chocolate);
        assertEquals("First chocolate", 1, count);
    }

    @Test
    public void firstOrangeJuice() throws NegativeAmountException{
        Protocol.generateCommand(new ConsumerOrder(Drink.OrangeJuice, 0, 100, false));
        int count = DrinkStats.getStat(Drink.OrangeJuice);
        assertEquals("First orange juice", 1, count);
    }

    @Test
    public void nForType() throws NegativeAmountException{
        int n = 4;
        for (Drink drink : Drink.values()) {
            for (int i = 0; i < n; i++) {
                Protocol.generateCommand(new ConsumerOrder(drink, 0, 100, true));
            }
        }
        for (Drink drink : Drink.values()) {
            int count = DrinkStats.getStat(drink);
            assertEquals("N for drink " + drink.name(), n, count);
        }
    }

    @Test
    public void totalIncome() throws NegativeAmountException{
        int n = 4;
        double expectedTotal = 0;
        for (Drink drink : Drink.values()) {
            for (int i = 0; i < n; i++) {
                Protocol.generateCommand(new ConsumerOrder(drink, 0, 100, true));
                expectedTotal += drink.getPrice();
            }
        }

        double total = DrinkStats.getTotal();
        assertEquals(expectedTotal, total, 0);

    }

}
