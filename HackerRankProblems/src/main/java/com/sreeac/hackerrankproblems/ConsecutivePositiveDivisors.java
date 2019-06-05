/*
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler179/problem
 */
package com.sreeac.hackerrankproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author achu
 */
public class ConsecutivePositiveDivisors {

//    static LocalDateTime oldTime = LocalDateTime.now();
    public static final List<Integer> answerCounts = new ArrayList<>();

    public static int consecutiveNumbersWIthSamePositiveDivisorsCount(
            int maxValue) {
        if (answerCounts.size() >= maxValue) {
            return answerCounts.get(maxValue);
        }

        int[] divisorCounts = new int[maxValue + 1];
        for (int i = 2; i <= (maxValue / 2); i++) {
            for (int j = i * 2; j <= maxValue; j += i) {
                divisorCounts[j]++;
            }
        }

        answerCounts.add(0);
        answerCounts.add(0);
        answerCounts.add(0);
        for (int i = 2; i < (divisorCounts.length - 1); i++) {
            int prevCount = answerCounts.get(i);
            if (divisorCounts[i] == divisorCounts[i + 1]) {
                prevCount++;
            }
            answerCounts.add(prevCount);
        }
        return answerCounts.get(maxValue);
    }
}
