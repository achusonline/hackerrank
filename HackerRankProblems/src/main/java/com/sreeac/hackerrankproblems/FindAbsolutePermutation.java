/*
 * https://www.hackerrank.com/challenges/absolute-permutation
 */
package com.sreeac.hackerrankproblems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author achu
 */
public class FindAbsolutePermutation {

    public static Set<Integer> getAbsolutePermutation(int length, int difference,
                                                      Set<Integer> permutation) {
        for (int nextCount = (difference + 1);; nextCount++) {
            if (permutation.contains(nextCount)) {
                continue;
            }
            System.out.println("Checking " + nextCount);

            /*
             This complex check is to go back only when the modulus difference of a number
             which we skipped earlier now equals the difference.
             For example, for a difference of 2,
             3,4,1,2
             After 4 you need to consider 1 instead of 5 to get the smallest next number
             whose difference with the position equals 2
             */
            if (difference != 0 && (nextCount - 2 * difference) > 0
                    && !permutation.contains((nextCount - 2 * difference))
                    && Math.abs((nextCount - 2 * difference) - (permutation.size() + 1)) == difference) {
                nextCount = nextCount - (2 * difference + 1);
                continue;
            } else if (nextCount > length) {
                break;
            }

            System.out.println("Added " + nextCount);
            permutation.add(nextCount);
            System.out.println(permutation);
        }

        if (permutation.size() == length) {
            return permutation;
        } else {
            //else no valid permurations found, add only -1 to set and return
            permutation = new HashSet<>();
            permutation.add(-1);
            return permutation;
        }

    }

}
