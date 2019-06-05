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
public class ConsecutivePositiveDivisorsTest {

    public ConsecutivePositiveDivisorsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of numberOfConsecutiveNumbersWIthSamePositiveDivisorsCount method,
     * of class EulerConsecutivePositiveDivisors.
     */
    @Test
    public void testNumberOfConsecutiveNumbersWIthSamePositiveDivisorsCount() {
        System.out.println("testNumberOfConsecutiveNumbersWIthSamePositiveDivisorsCount4");
        int maxValue = 10000000;

        int expResult = 986262;
        int result = ConsecutivePositiveDivisors.consecutiveNumbersWIthSamePositiveDivisorsCount(maxValue);
        assertEquals(expResult, result);

        expResult = 2;
        result = ConsecutivePositiveDivisors.consecutiveNumbersWIthSamePositiveDivisorsCount(15);
        assertEquals(expResult, result);

        expResult = 15;
        result = ConsecutivePositiveDivisors.consecutiveNumbersWIthSamePositiveDivisorsCount(100);
        assertEquals(expResult, result);

        expResult = 10585;
        result = ConsecutivePositiveDivisors.consecutiveNumbersWIthSamePositiveDivisorsCount(100000);
        assertEquals(expResult, result);

    }

}
