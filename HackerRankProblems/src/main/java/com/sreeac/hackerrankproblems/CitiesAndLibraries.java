/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 *
 * @author achu
 */
public class CitiesAndLibraries {

    /**
     * Complete the roadsAndLibraries function below.
     *
     * @param n number of cities
     * @param c_lib cost of library
     * @param c_road cost of road
     * @param citiesWithRoads Each row has two columns which represents two
     * cities between which road is possible
     * @return
     */
    public static long roadsAndLibraries(int n, int c_lib, int c_road,
                                         int[][] citiesWithRoads) {

        List<CityNode> cities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cities.add(new CityNode(i + 1));
        }

        for (int i = 0; i < citiesWithRoads.length; i++) {
            int cityNumber1 = citiesWithRoads[i][0];
            int cityNumber2 = citiesWithRoads[i][1];
            CityNode city1 = cities.get(cityNumber1 - 1);
            CityNode city2 = cities.get(cityNumber2 - 1);
            city1.getRoads().add(city2);
            city2.getRoads().add(city1);
        }

        if (citiesWithRoads.length * c_road > n * c_lib) {
            return n * c_lib;
        }

        return 0L;
    }

    static class CityNode {

        int cityCardinal;

        boolean hasLibrary = false;

        List<CityNode> roads = new ArrayList<>();

        CityNode(int cityCardinal) {
            this.cityCardinal = cityCardinal;
        }

        @Override
        public boolean equals(Object another) {
            if (another == null && this != null) {
                return false;
            }
            if (!(another instanceof CityNode)) {
                return false;
            }

            CityNode other = (CityNode) another;
            return new EqualsBuilder().append(cityCardinal, other.cityCardinal).isEquals();
        }

        public int getCityCardinal() {
            return cityCardinal;
        }

        public void setCityCardinal(int cityCardinal) {
            this.cityCardinal = cityCardinal;
        }

        public boolean isHasLibrary() {
            return hasLibrary;
        }

        public void setHasLibrary(boolean hasLibrary) {
            this.hasLibrary = hasLibrary;
        }

        public List<CityNode> getRoads() {
            return roads;
        }

    }
}
