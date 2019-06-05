/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author achu
 */
public class FindAbsolutePermutationTest {

    public FindAbsolutePermutationTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAbsolutePermutation method, of class FindAbsolutePermutation.
     */
    @Test
    public void testGetAbsolutePermutation() {
        System.out.println("testGetAbsolutePermutation");
        int length = 3;
        int difference = 0;
        Set<Integer> expResult = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> result = FindAbsolutePermutation.getAbsolutePermutation(length, difference, new LinkedHashSet<Integer>());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAbsolutePermutation_Simple() {
        System.out.println("testGetAbsolutePermutation_Simple");
        int length = 2;
        int difference = 1;
        Set<Integer> expResult = new LinkedHashSet<>(Arrays.asList(2, 1));
        Set<Integer> result = FindAbsolutePermutation.getAbsolutePermutation(length, difference, new LinkedHashSet<Integer>());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAbsolutePermutation_NoResult() {
        System.out.println("testGetAbsolutePermutation_NoResult");
        int length = 3;
        int difference = 2;
        Set<Integer> expResult = new LinkedHashSet<>(Arrays.asList(-1));
        Set<Integer> result = FindAbsolutePermutation.getAbsolutePermutation(length, difference, new LinkedHashSet<Integer>());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAbsolutePermutation_BoundaryResult() {
        System.out.println("testGetAbsolutePermutation_BoundaryResult");
        int length = 8;
        int difference = 2;
        Set<Integer> expResult = new LinkedHashSet<>(Arrays.asList(3, 4, 1, 2, 7, 8, 5, 6));
        Set<Integer> result = FindAbsolutePermutation.getAbsolutePermutation(length, difference, new LinkedHashSet<Integer>());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAbsolutePermutation_BigResult() {
        System.out.println("testGetAbsolutePermutation_BigResult");
        int length = 10;
        int difference = 1;
        Set<Integer> expResult = new LinkedHashSet<>(Arrays.asList(2, 1, 4, 3, 6, 5, 8, 7, 10, 9));
        Set<Integer> result = FindAbsolutePermutation.getAbsolutePermutation(length, difference, new LinkedHashSet<Integer>());
        assertEquals(expResult, result);
    }

}
