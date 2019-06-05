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
public class StrangeCounterTest {

    public StrangeCounterTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCounterValueAtTSecond method, of class StrangeCounter.
     */
    @Test
    public void testGetCounterValueAtTSecond() {
        System.out.println("getCounterValueAtTSecond");
        int tSecond = 4;

        long expResult = 6L;

        assertEquals(expResult, StrangeCounter.getCounterValueAtTSecond(tSecond));
        assertEquals(3L, StrangeCounter.getCounterValueAtTSecond(1L));
        assertEquals(1L, StrangeCounter.getCounterValueAtTSecond(21L));
        assertEquals(12L, StrangeCounter.getCounterValueAtTSecond(10L));
    }

    @Test
    public void testGetCounterValueAtTSecond_LargeTime() {
        System.out.println("getCounterValueAtTSecond");
        long tSecond = 999999766777L;

        long expResult = 649267674885L;
        assertEquals(expResult, StrangeCounter.getCounterValueAtTSecond(tSecond));
    }

}
