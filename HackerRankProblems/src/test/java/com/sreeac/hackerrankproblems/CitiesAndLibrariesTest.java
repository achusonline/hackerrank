/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for CitiesAndLibraries
 *
 * @author achu
 */
public class CitiesAndLibrariesTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testRoadsAndLibraries_3Cities() {
        int[][] cities = new int[3][2];
        cities[0][0] = 1;
        cities[0][1] = 2;

        cities[1][0] = 3;
        cities[1][1] = 1;

        cities[2][0] = 2;
        cities[2][1] = 3;

        int c_road = 1;

        int c_lib = 2;

        int n = 3;

        long result = CitiesAndLibraries.roadsAndLibraries(n, c_lib, c_road, cities);

        assertEquals(4L, result);
    }

    /*
     6 6 2 5
     1 3
     3 4
     2 4
     1 2
     2 3
     5 6
     */
    @Test
    public void testRoadsAndLibraries_6Cities() {
        int c_road = 5;
        int c_lib = 2;
        int n = 6;

        int[][] cities = new int[6][2];
        cities[0][0] = 1;
        cities[0][1] = 3;

        cities[1][0] = 3;
        cities[1][1] = 4;

        cities[2][0] = 2;
        cities[2][1] = 4;

        cities[3][0] = 1;
        cities[3][1] = 2;

        cities[4][0] = 2;
        cities[4][1] = 3;

        cities[5][0] = 5;
        cities[5][1] = 6;

        long result = CitiesAndLibraries.roadsAndLibraries(n, c_lib, c_road, cities);

        assertEquals(12L, result);
    }
}
