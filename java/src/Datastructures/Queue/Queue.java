package Datastructures.Queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    /**
     * A simple generic Queue implementation
     * Queues use FIFO (First-in First-out) ordering so that
     * the items are read in the order that they are added
     */
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    /**
     * add new item to the end of the queue
     * @param item
     */
    public void add(T item) {
        QueueNode<T> newItem = new QueueNode<T>(item);
        if (last != null) {
            last.next = newItem;
        }
        last = newItem;
        // new item is first, b/c current queue is empty
        if (first == null) {
            first = last;
        }
    }

    /**
     * remove and return the oldest item added to queue
     * @return item at front of the queue
     */
    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    /**
     * return the oldest item added to the queue
     * without changing the queue
     * @return
     */
    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        System.out.println("Testing queue implementation...");
        Queue<String> q = new Queue<String>();
        q.add("a");
        q.add("b");
        q.add("c");
        String firstItem = q.peek();
        System.out.println("peek 1st item of queue, should be a, is: " + firstItem);
        firstItem = q.remove();
        System.out.println("remove 1st item of queue, should be a, is: " + firstItem);
        firstItem = q.peek();
        System.out.println("peek 1st item of queue, should be b, is: " + firstItem);
    }
}