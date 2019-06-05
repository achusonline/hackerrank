/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for @link {EvenTree}
 *
 * @author achu
 */
public class EvenTreeTest {

    public EvenTreeTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of numberOfEdgesRemovedToObtainForest method, of class EvenTree.
     */
    @Test
    public void testNumberOfEdgesRemovedToObtainForest() {
        System.out.println("numberOfEdgesRemovedToObtainForest");
        Map<Integer, Integer> vertices = new LinkedHashMap<>();
        vertices.put(2, 1);
        vertices.put(3, 1);
        vertices.put(4, 3);
        vertices.put(5, 2);
        vertices.put(6, 1);
        vertices.put(7, 2);
        vertices.put(8, 6);
        vertices.put(9, 8);
        vertices.put(10, 8);

        Integer expResult = 2;
        Integer result = EvenTree.numberOfEdgesRemovedToObtainForest(vertices);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfEdgesRemovedToObtainForest2() {
        System.out.println("testNumberOfEdgesRemovedToObtainForest2");
        Map<Integer, Integer> vertices = new LinkedHashMap<>();
        vertices.put(2, 1);
        vertices.put(3, 1);
        vertices.put(4, 3);
        vertices.put(5, 2);
        vertices.put(6, 1);
        vertices.put(7, 2);
        vertices.put(8, 6);
        vertices.put(9, 8);
        vertices.put(10, 5);

        Integer expResult = 4;
        Integer result = EvenTree.numberOfEdgesRemovedToObtainForest(vertices);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfEdgesRemovedToObtainForest3() {
        System.out.println("testNumberOfEdgesRemovedToObtainForest3");
        Map<Integer, Integer> vertices = new LinkedHashMap<>();
        vertices.put(2, 1);

        Integer expResult = 0;
        Integer result = EvenTree.numberOfEdgesRemovedToObtainForest(vertices);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfEdgesRemovedToObtainForest4() {
        System.out.println("testNumberOfEdgesRemovedToObtainForest4");
        Map<Integer, Integer> vertices = new LinkedHashMap<>();
        vertices.put(2, 1);
        vertices.put(3, 2);
        vertices.put(4, 3);
        vertices.put(5, 2);
        vertices.put(6, 4);
        vertices.put(7, 4);
        vertices.put(8, 1);
        vertices.put(9, 5);
        vertices.put(10, 4);
        vertices.put(11, 4);
        vertices.put(12, 8);
        vertices.put(13, 2);
        vertices.put(14, 2);
        vertices.put(15, 8);
        vertices.put(16, 10);
        vertices.put(17, 1);
        vertices.put(18, 17);
        vertices.put(19, 18);
        vertices.put(20, 4);
        vertices.put(21, 15);
        vertices.put(22, 20);
        vertices.put(23, 2);
        vertices.put(24, 12);
        vertices.put(25, 21);
        vertices.put(26, 17);
        vertices.put(27, 5);
        vertices.put(28, 27);
        vertices.put(29, 4);
        vertices.put(30, 25);

        Integer expResult = 11;
        Integer result = EvenTree.numberOfEdgesRemovedToObtainForest(vertices);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfEdgesRemovedToObtainForest5() {
        System.out.println("testNumberOfEdgesRemovedToObtainForest5");
        Map<Integer, Integer> vertices = new LinkedHashMap<>();
        vertices.put(2, 1);
        vertices.put(3, 1);
        vertices.put(4, 2);
        vertices.put(5, 2);
        vertices.put(6, 4);
        vertices.put(7, 6);
        vertices.put(8, 5);
        vertices.put(9, 1);
        vertices.put(10, 9);
        vertices.put(11, 4);
        vertices.put(12, 6);
        vertices.put(13, 12);
        vertices.put(14, 1);
        vertices.put(15, 5);
        vertices.put(16, 2);
        vertices.put(17, 8);
        vertices.put(18, 7);
        vertices.put(19, 3);
        vertices.put(20, 18);
        vertices.put(21, 3);
        vertices.put(22, 9);
        vertices.put(23, 6);
        vertices.put(24, 18);
        vertices.put(25, 13);
        vertices.put(26, 11);
        vertices.put(27, 18);
        vertices.put(28, 27);
        vertices.put(29, 13);
        vertices.put(30, 25);
        vertices.put(31, 30);
        vertices.put(32, 24);
        vertices.put(33, 12);
        vertices.put(34, 11);
        vertices.put(35, 12);
        vertices.put(36, 3);
        vertices.put(37, 31);
        vertices.put(38, 21);
        vertices.put(39, 27);
        vertices.put(40, 12);
        vertices.put(41, 22);
        vertices.put(42, 14);
        vertices.put(43, 42);
        vertices.put(44, 33);
        vertices.put(45, 1);
        vertices.put(46, 24);
        vertices.put(47, 22);
        vertices.put(48, 30);
        vertices.put(49, 22);
        vertices.put(50, 43);

        Integer expResult = 12;
        Integer result = EvenTree.numberOfEdgesRemovedToObtainForest(vertices);
        assertEquals(expResult, result);
    }

}
