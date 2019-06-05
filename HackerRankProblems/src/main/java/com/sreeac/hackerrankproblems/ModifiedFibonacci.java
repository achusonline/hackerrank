/*
 https://www.hackerrank.com/challenges/fibonacci-modified
 */
package com.sreeac.hackerrankproblems;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author achu
 */
public class ModifiedFibonacci {

    private static final BigDecimal BIG_DECIMAL_TWO = new BigDecimal(2);

    private static final Map<BigDecimal, BigDecimal> alreadyFoundValuesMap = new HashMap<>();

    public static BigDecimal findNextNumberInSeries(BigDecimal big1,
                                                    BigDecimal t1, BigDecimal t2) {
        if (big1.equals(BigDecimal.ONE)) {
            return t1;
        }
        if (big1.equals(BIG_DECIMAL_TWO)) {
            return t2;
        }
        if (alreadyFoundValuesMap.containsKey(big1)) {
            System.out.println("Found in map" + big1);
            return alreadyFoundValuesMap.get(big1);
        }

        BigDecimal output = findNextNumberInSeries(big1.subtract(BIG_DECIMAL_TWO), t1, t2)
                .add(findNextNumberInSeries(big1.subtract(BigDecimal.ONE), t1, t2)
                        .multiply(findNextNumberInSeries(big1.subtract(BigDecimal.ONE), t1, t2)));
        System.out.println("put in map" + big1 + "output:" + output);
        alreadyFoundValuesMap.put(big1, output);
        return output;
    }

}
