/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author achu
 */
public class ArrayManipulationTest {

    public ArrayManipulationTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of arrayManipulation method, of class ArrayManipulation.
     */
    @Test
    public void testArrayManipulation() {
        System.out.println("arrayManipulation");
        int n = 5;
        int[][] queries = new int[][]{new int[]{1, 2, 100}, new int[]{2, 5, 100},
        new int[]{3, 4, 100}};

        long expResult = 200L;
        long result = ArrayManipulation.arrayManipulation(n, queries);

        assertEquals(expResult, result);
    }

}
