/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sreeac.hackerrankproblems;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopViewTree {
    /*

     class Node
     int data;
     Node left;
     Node right;
     */

    private static Map<Integer, Integer> resultMap = new TreeMap<>();

    public static void topView(Node root) {
        resultMap.put(0, root.data);

        traverseLeftTree(root.left, -1);

        traverseRightTree(root.right, 1);

        for (Integer mapEntry : resultMap.values()) {
            System.out.print(mapEntry + " ");
        }

    }

    private static void traverseLeftTree(Node root, int currentLevel) {
        if (root == null) {
            return;

        }

        if (!resultMap.containsKey(currentLevel) && (currentLevel < 0)) {
            resultMap.put(currentLevel, root.data);
        }

        traverseLeftTree(root.left, currentLevel - 1);
        traverseLeftTree(root.right, currentLevel + 1);

    }

    private static void traverseRightTree(Node root, int currentLevel) {
        if (root == null) {
            return;
        }
        if (!resultMap.containsKey(currentLevel) && (currentLevel > 0)) {
            resultMap.put(currentLevel, root.data);
        }

        traverseRightTree(root.left, currentLevel - 1);
        traverseRightTree(root.right, currentLevel + 1);

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner("116\n"
                + "37 23 108 59 86 64 94 14 105 17 111 65 55 31 79 97 78 25 50 22 66 46 104 98 81 90 68 40 103 77 74 18 69 82 41 4 48 83 67 6 2 95 54 100 99 84 34 88 27 72 32 62 9 56 109 115 33 15 91 29 85 114 112 20 26 30 93 96 87 42 38 60 7 73 35 12 10 57 80 13 52 44 16 70 8 39 107 106 63 24 92 45 75 116 5 61 49 101 71 11 53 43 102 110 1 58 36 28 76 47 113 21 89 51 19 3");
        //1 2 4 14 23 37 108 111 115 116 83 84 85
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println("Expected output: 1 2 4 14 23 37 108 111 115 116 83 84 85");
        topView(root);
    }
}
