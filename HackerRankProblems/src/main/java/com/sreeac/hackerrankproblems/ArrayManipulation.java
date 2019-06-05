/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author achu
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long largest = 0;

        long[] array = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1];
            int k = queries[i][2];

            array[a] += k;
            if (b < n) {
                array[b] += -k;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                array[i] += array[i - 1];
            }
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StopWatch watch = new StopWatch();
        watch.start();
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        scanner = new Scanner(Paths.get("/home/achu/Softwares/hackerrank", "ArrayManipulation_Test07.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        //  bufferedWriter.write(String.valueOf(result));
        //   bufferedWriter.newLine();
        //   bufferedWriter.close();
        scanner.close();
        watch.stop();

//result : 398714// 07 out: 2497169732
        System.out.println("result:" + String.valueOf(result));
        System.out.println("time taken:" + watch.toString());
    }
}
