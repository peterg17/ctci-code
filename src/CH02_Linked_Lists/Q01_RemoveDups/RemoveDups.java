package CH02_Linked_Lists.Q01_RemoveDups;

import Datastructures.LinkedLists.SingleLL;
import Datastructures.LinkedLists.Node;
import java.util.HashSet;

public class RemoveDups {

    private static SingleLL dedupLL(SingleLL linkedList) {
        int firstItem = linkedList.head.data;
        SingleLL newLL = new SingleLL(firstItem);
        HashSet<Integer> dupLookupTable = new HashSet<Integer>();
        dupLookupTable.add(firstItem);
        Node n = linkedList.head;
        while (n.next != null) {
            n = n.next;
            if (!dupLookupTable.contains(n.data)) {
                newLL.appendToTail(n.data);
                dupLookupTable.add(n.data);
            }
        }
        return newLL;
    }


    public static void main(String[] args) {
        System.out.println("Testing linked list remove dups...");
        SingleLL linked = new SingleLL(2);
        linked.appendToTail(2);
        linked.appendToTail(2);
        linked.appendToTail(3);
        linked.appendToTail(3);
        linked.appendToTail(5);
        linked.appendToTail(7);
        System.out.println("before removing dups, LL is: " + linked);
        SingleLL dedupLinked = dedupLL(linked);
        System.out.println("after removing dups, LL is: " + dedupLinked);
    }
}

