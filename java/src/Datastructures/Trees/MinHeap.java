package Datastructures.Trees;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;

public class MinHeap {
    /*
    MinHeap: a complete binary tree (filled except for right side of last level)
            where each node is smaller than its children. So the root node is the min node
            in the tree.

     Hint: binary heap typically represented as an array
     Source: https://www.geeksforgeeks.org/binary-heap/
     */
    public int[] heapArray;
    public int capacity;
    public int heapSize;

    public MinHeap(int capacity) {
        this.heapArray = new int[capacity];
        this.capacity = capacity;
        this.heapSize = 0;
    }

    public int getParent(int i) {
        return (i-1)/2;
    }

    public int getLeftChild(int i) {
        return (2*i + 1);
    }

    public int getRightChild(int i) {
        return (2*i + 2);
    }

    /*
    insert takes a number that a new node will represent as input and
    inserts that node into the heap. function will insert at the rightmost
    position to maintain completeness property, and recurisvely swap new node
    with parent until it satisfies min heap property. Takes O(log n) time because
    the height of the tree is the max # of swaps
     */
    public void insert(int d) throws SizeLimitExceededException {
        if (this.heapSize == this.capacity) {
            throw new SizeLimitExceededException("Could not insert new key into heap, heap full");
        }

        // insert new key at the end (right-most node in the leaf level)
        this.heapSize++;
        int i = heapSize - 1;
        this.heapArray[i] = d;

        // fix min property
        while (i >= 0 && heapArray[i] < heapArray[getParent(i)]) {
            heapSwap(i, getParent(i));
            i = getParent(i);
        }
    }

    private void heapSwap(int i, int j) {
        int temp = this.heapArray[i];
        this.heapArray[i] = this.heapArray[j];
        this.heapArray[j] = temp;
    }

    public void inOrderTraversal() {
        // TODO: print structure of heap like binary tree printer
        for (int i=0; i < heapSize; i++) {
            System.out.println("Min heap node at i: " + i
                    + " has value: " + heapArray[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing TreeNode traversal...");
        ArrayList<String> vals = new ArrayList<String>();
        MinHeap heap = new MinHeap(100);
        try {
            heap.insert(4);
            heap.insert(50);
            heap.insert(7);
            heap.insert(55);
            heap.insert(90);
            heap.insert(87);
            heap.inOrderTraversal();
            System.out.println("-------------------------");
            heap.insert(2);
            // new traversal should show that root is now 2
            // original root (4) and right child (7) have been pushed down
            heap.inOrderTraversal();
        } catch (Exception e) {
            System.out.println("heap operations failed with exception: "
                    + e);
        }
    }

}




