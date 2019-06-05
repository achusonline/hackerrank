/*
 * https://www.hackerrank.com/challenges/morgan-and-a-string
 */
package com.sreeac.hackerrankproblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author achu
 */
public class SmallestStringFromTwoStacks {

    private static Map<String, String> validatedStringsB = new HashMap<>();

    public static String smallestStringFromStacks(String stackA,
                                                  String stackB) {
        if (stackA.isEmpty()) {
            return stackB;
        }
        if (stackB.isEmpty()) {
            return stackA;
        }
        int[] suffixArrayA = createSuffixArray(stackA);
        int[] suffixArrayB = createSuffixArray(stackB);

        int i = 0, j = 0;

        String smallestString = "";
        while (i < stackA.length() && j < stackB.length()) {
            char nextAElement = stackA.charAt(i);
            char nextBElement = stackB.charAt(j);

            //System.out.println("smallestString:" + smallestString);
            if (nextAElement < nextBElement) {
                smallestString += nextAElement;
                i++;
            } else if (nextBElement < nextAElement) {
                smallestString += nextBElement;
                j++;
            } else {
                if (suffixArrayA[i] < suffixArrayB[j]) {
                    smallestString += nextAElement;
                    i++;
                } else if (suffixArrayA[i] > suffixArrayB[j]) {
                    smallestString += nextBElement;
                    j++;
                } else {
                    int suffixDifferencePoint = compareSuffixArrayFromPoint(suffixArrayA, suffixArrayB, i, j);
                    if (suffixDifferencePoint == 0) {
                        smallestString += nextAElement;
                        i++;
                    } else if (suffixDifferencePoint < 0) {
                        suffixDifferencePoint = -1 * suffixDifferencePoint;
                        smallestString += stackA.substring(i, i + suffixDifferencePoint);
                        i = i + suffixDifferencePoint;
                    } else {
                        smallestString += stackB.substring(j, j + suffixDifferencePoint);
                        j = j + suffixDifferencePoint;
                    }
                }
            }
        }
        if (i < stackA.length()) {
            smallestString += stackA.substring(i);
        } else if (j < stackB.length()) {
            smallestString += stackB.substring(j);
        }
        return smallestString;
    }

    public static int compareSuffixArrayFromPoint(int[] arrayA, int[] arrayB,
                                                  int startIndexA,
                                                  int startIndexB) {

        for (int i = startIndexA, j = startIndexB; i < arrayA.length && j < arrayB.length; i++, j++) {
            if (arrayA[i] != arrayB[j]) {
                if (arrayA[i] < arrayB[j]) {
                    return startIndexA - i - 1;
                } else {
                    return j - startIndexB + 1;
                }
            }
        }

        return 0;
    }

    public static int[] createSuffixArray(String inputString) {
        int[] suffixArray = new int[inputString.length()];
        suffixArray[(inputString.length() - 1)] = 'A' - inputString.length();

        for (int index = inputString.length() - 2; index >= 0; index--) {
            int currentSuffixValue = inputString.charAt(index + 1) - ('A' - 1);
            suffixArray[index] = currentSuffixValue;
        }
        return suffixArray;
    }

}
