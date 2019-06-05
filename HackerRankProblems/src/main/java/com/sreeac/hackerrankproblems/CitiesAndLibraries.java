/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.util.ArrayList;
import java.util.List;

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

        long totalCost = 0L;
        for (CityNode city : cities) {
            if (!city.hasLibrary()) {
                int totalNodes = traverseAndAddLibraries(city, 0, c_road, c_lib, 1);
                totalCost += c_lib;
                if (c_lib > c_road) {
                    totalCost += c_road * (totalNodes - 1);
                } else {
                    totalCost += c_lib * (totalNodes - 1);
                }
            }

            System.out.println("City :" + city.getCityCardinal() + ", Total cost so far:" + totalCost);
        }

        return totalCost;
    }

    private static int traverseAndAddLibraries(CityNode currentNode,
                                               long traversalCost,
                                               int roadCost,
                                               int libraryCost, int totalCities) {
        System.out.println("Reached " + currentNode);
        currentNode.setHasLibrary(true);

        for (CityNode connectedCity : currentNode.getRoads()) {
            if (!connectedCity.hasLibrary()) {
                totalCities = traverseAndAddLibraries(connectedCity, traversalCost + roadCost, roadCost, libraryCost, totalCities + 1);
            }
        }
        System.out.println("Leaving " + currentNode);
        return totalCities;
    }

    private static class CityNode {

        int cityCardinal;

        boolean libraryExist = false;

        List<CityNode> roads = new ArrayList<>();

        CityNode(int cityCardinal) {
            this.cityCardinal = cityCardinal;
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

        @Override
        public String toString() {
            return "CityNode{" + "cityCardinal=" + cityCardinal + ", libraryExist=" + libraryExist + '}';
        }

    }
}
