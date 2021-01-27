package Datastructures.Trees;

import java.util.ArrayList;

public class MinHeap {
    /*
    MinHeap: a complete binary tree (filled except for right side of last level)
            where each node is smaller than its children. So the root node is the min node
            in the tree.

     Hint: binary heap typically represented as an array
     Source: https://www.geeksforgeeks.org/binary-heap/
     */
    public int[] data;
    public int capacity;
    public int numItems;

    public MinHeap(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.numItems = 0;
    }

//    public int getParent(int i) {
//        return
//    }

    /*
    insert takes a number that a new node will represent as input and
    inserts that node into the heap. function will insert at the rightmost
    position to maintain completeness property, and recurisvely swap new node
    with parent until it satisfies min heap property. Takes O(log n) time because
    the height of the tree is the max # of swaps
     */
    public void insert(int d) {

    }

//    public void visit() {
//
//    }

//    public void inOrderTraversal() {
//
//    }

    public static void main(String[] args) {
        System.out.println("Testing TreeNode traversal...");
        ArrayList<String> vals = new ArrayList<String>();
//        MinHeapNode root = new MinHeapNode(4);
//        root.insert(50);
//        root.insert(7);

        System.out.println("Binary tree values are: ");
//        root.inOrderTraversal();
    }

}




