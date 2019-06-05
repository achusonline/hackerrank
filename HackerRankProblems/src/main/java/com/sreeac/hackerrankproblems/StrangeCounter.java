/*
 *https://www.hackerrank.com/challenges/strange-code
 */
package com.sreeac.hackerrankproblems;

/**
 *
 * @author achu
 */
public class StrangeCounter {

    public static long getCounterValueAtTSecond(long tSecond) {
        long counterTime = 1L;
        long currentCounterValue = 3L;

        while (true) {
            if ((counterTime + currentCounterValue) > tSecond) {
                currentCounterValue = currentCounterValue - (tSecond - counterTime);
                break;
            } else {
                counterTime += currentCounterValue;
                currentCounterValue = 2 * currentCounterValue;
            }
        }

        return currentCounterValue;
    }
}
