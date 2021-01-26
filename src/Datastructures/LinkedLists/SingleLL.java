package Datastructures.LinkedLists;

public class SingleLL {
    public Node head;

    public SingleLL(int data) {
        this.head = new Node(data);
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNode(int d) {
        Node n = this.head;
        if (n.data == d) {
            // if delete head, have to make next head
            this.head = n.next;
            return n;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return this.head;
    }

    @Override
    public String toString() {
        String str = "";
        Node n = this.head;
        while (n.next != null) {
            str += n.data + " -> ";
            n = n.next;
        }
        str += n.data;
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Testing singlelinked list...");
        SingleLL linkList = new SingleLL(2);
        linkList.appendToTail(5);
        linkList.appendToTail(7);
        linkList.appendToTail(10);
        System.out.println("linked list has values: " + linkList.toString());
        linkList.deleteNode(7);
        System.out.println("after deleting 7, linked list has values: " + linkList.toString());
        linkList.deleteNode(2);
        System.out.println("after deleting 2, linked list has values: " + linkList.toString());
    }

}