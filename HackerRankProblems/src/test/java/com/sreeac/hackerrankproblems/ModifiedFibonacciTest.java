/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.math.BigDecimal;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author achu
 */
public class ModifiedFibonacciTest {

    public ModifiedFibonacciTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findNextNumberInSeries method, of class ModifiedFibonacci.
     */
    @Test
    public void testFindNextNumberInSeries() {
        System.out.println("findNextNumberInSeries");
        BigDecimal t1 = new BigDecimal(0);
        BigDecimal t2 = new BigDecimal(1);
        BigDecimal big1 = new BigDecimal(3);
        BigDecimal expResult = new BigDecimal(1);
        BigDecimal result = ModifiedFibonacci.findNextNumberInSeries(big1, t1, t2);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindNextNumberInSeries_5() {
        System.out.println("findNextNumberInSeries5");
        BigDecimal t1 = new BigDecimal(0);
        BigDecimal t2 = new BigDecimal(1);
        BigDecimal big1 = new BigDecimal(5);
        BigDecimal expResult = new BigDecimal(5);
        BigDecimal result = ModifiedFibonacci.findNextNumberInSeries(big1, t1, t2);
        assertEquals(expResult, result);
    }

}
