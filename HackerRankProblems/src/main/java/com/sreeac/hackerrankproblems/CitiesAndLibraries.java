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
     * @param c_lib cost of libraryExist
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

        for (CityNode city : cities) {
            traverseAndAddLibraries(city, 0, c_road, c_lib);
        }

        long totalCost = 0L;
        for (CityNode city : cities) {
            totalCost = totalCost + ((city.getTraversalCost() != 0L) ? city.getTraversalCost() : c_lib);
            System.out.println("City :" + city.getCityCardinal() + ", Total cost so far:" + totalCost);
        }

        return totalCost;
    }

    private static void traverseAndAddLibraries(CityNode currentNode,
                                                long traversalCost,
                                                int roadCost,
                                                int libraryCost) {
        System.out.println("Reached " + currentNode);
        if (traversalCost < libraryCost
                && ((traversalCost != 0 && traversalCost < currentNode.getTraversalCost())
                || (traversalCost == 0 && libraryCost < currentNode.getTraversalCost()))) {
            currentNode.setHasLibrary(true);
            currentNode.setTraversalCost(traversalCost);
            traversalCost = 0;
        }
        if (libraryCost < traversalCost) {
            return;
        }

        for (CityNode connectedCity : currentNode.getRoads()) {
            if ((traversalCost + roadCost) < connectedCity.getTraversalCost()) {
                traverseAndAddLibraries(connectedCity, traversalCost + roadCost, roadCost, libraryCost);
            }
        }
        System.out.println("Leaving " + currentNode);
    }

    private static class CityNode {

        int cityCardinal;

        long traversalCost = Long.MAX_VALUE;

        boolean libraryExist = false;

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

        public boolean hasLibrary() {
            return libraryExist;
        }

        public void setHasLibrary(boolean libraryExist) {
            this.libraryExist = libraryExist;
        }

        public List<CityNode> getRoads() {
            return roads;
        }

        public long getTraversalCost() {
            return traversalCost;
        }

        public void setTraversalCost(long traversalCost) {
            this.traversalCost = traversalCost;
        }

        @Override
        public String toString() {
            return "CityNode{" + "cityCardinal=" + cityCardinal + ", traversalCost=" + traversalCost + ", libraryExist=" + libraryExist + '}';
        }

    }
}
