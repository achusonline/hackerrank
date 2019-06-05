/*
 * https://www.hackerrank.com/challenges/even-tree
 */
package com.sreeac.hackerrankproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 *
 * @author achu
 */
public class EvenTree {

    public static int numberOfEdgesRemovedToObtainForest(
            Map<Integer, Integer> vertices) {

        ArrayList<TreeNode> sortedLeafNodes = readTreeToGetSortedLeafNodes(vertices);

        System.out.println("Sorted leaf nodes:" + sortedLeafNodes);

        return getEdgesCountToRemoveForEvenTree(sortedLeafNodes);
    }

    private static int getEdgesCountToRemoveForEvenTree(
            List<TreeNode> sortedLeafNodes) {
        final AtomicReference<Integer> parentNodesCount = new AtomicReference<>(0);
        ListIterator<TreeNode> leafNodesIterator = sortedLeafNodes.listIterator();
        while (leafNodesIterator.hasNext()) {
            TreeNode leafNode = leafNodesIterator.next();
            System.out.println("Finding even parent for leafNode:" + leafNode);
            TreeNode<Integer> parentNode = leafNode.findNextEvenParent();
            if (parentNode != null) {
                TreeNode<Integer> grandParent = parentNode.parent;
                if (grandParent != null) {
                    parentNodesCount.set(parentNodesCount.get() + 1);
                    grandParent.children.remove(parentNode);
                    parentNode.parent = null;
                    System.out.println("Remove edge:" + parentNode + ":" + grandParent);
                    if (grandParent.children.isEmpty()) {
                        System.out.println("Found grandparent without anymore children: " + grandParent);
                        //System.out.println("sortedLeafNodes:" + sortedLeafNodes);
                        leafNodesIterator.add(grandParent);
                        leafNodesIterator.previous();
                    }
                }
            }
        };
        return parentNodesCount.get();
    }

    private static ArrayList<TreeNode> readTreeToGetSortedLeafNodes(
            Map<Integer, Integer> vertices) {
        Map<Integer, TreeNode> tree = new HashMap<>();
        Set<TreeNode> leafNodes = new TreeSet<>();
        for (Map.Entry<Integer, Integer> vertex : vertices.entrySet()) {
            //System.out.println("vertex:" + vertex);
            TreeNode<Integer> nodeA = tree.get(vertex.getKey());
            if (nodeA == null) {
                nodeA = new TreeNode(vertex.getKey());
                tree.put(vertex.getKey(), nodeA);
            }

            TreeNode<Integer> nodeB = tree.get(vertex.getValue());
            if (nodeB == null) {
                nodeB = new TreeNode(vertex.getValue());
                tree.put(vertex.getValue(), nodeB);
            }

            nodeB.addChild(nodeA);

            leafNodes.add(nodeA);
            leafNodes.remove(nodeB);

            //System.out.println("tree: " + tree);
            //System.out.println("leafNodes " + leafNodes);
            //System.out.println("");
        }
        ArrayList<TreeNode> sortedLeafNodes = new ArrayList<TreeNode>(leafNodes);
        Collections.sort(sortedLeafNodes, new Comparator<TreeNode>() {

            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.getNodeLevel(o2, 0) - o1.getNodeLevel(o1, 0);
            }
        });
        return sortedLeafNodes;
    }

    public static class TreeNode<T extends Comparable>
            implements Iterable<TreeNode<T>>, Comparable<TreeNode<T>> {

        T data;

        TreeNode<T> parent;

        List<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
            this.children = new LinkedList<>();
        }

        public TreeNode<T> addChild(T child) {
            TreeNode<T> childNode = new TreeNode<T>(child);
            childNode.parent = this;
            this.children.add(childNode);
            return childNode;
        }

        public TreeNode<T> addChild(TreeNode<T> child) {
            this.children.add(child);
            child.parent = this;
            return child;
        }

        public int getSubTreeSize() {
            if (children.isEmpty()) {
                return 0;
            }
            int subTreeSize = children.size();

            subTreeSize += children.stream()
                    .flatMapToInt(child -> IntStream.of(child.getSubTreeSize()))
                    .sum();

            return subTreeSize;
        }

        public TreeNode<T> findNextEvenParent() {
            if (this.parent == null) {
                return null;
            }
            System.out.println("this:" + this);
            System.out.println("subTreeSize:" + getSubTreeSize());
            if ((getSubTreeSize() + 1) % 2 == 0) {
                //System.out.println("Found even parent: " + this);
                return this;
            }
            return this.parent.findNextEvenParent();
        }

        public int getNodeLevel(TreeNode<Integer> originalNode,
                                int previousLevel) {
            if (this.parent == null) {
                return previousLevel + 1;
            } else {
                return this.parent.getNodeLevel(originalNode, ++previousLevel);
            }
        }

        @Override
        public Iterator<TreeNode<T>> iterator() {
            return children.iterator();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final TreeNode<T> other = (TreeNode<T>) obj;
            return data.equals(other.data);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + Objects.hashCode(this.data);
            return hash;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "data=" + data + "}";
            //, children.size=" + (children != null ? children.size() : null) + '}';
        }

        @Override
        public int compareTo(TreeNode<T> o) {
            return this.data.compareTo(o.data);
        }

    }
}
