package Datastructures.Graph;


/*
Pointed-based graph
implementation.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.LinkedList;

class Node {
    public String name;
    public List<Node> children;
    public boolean visited;

    public Node(String val) {
        name = val;
        children = new ArrayList<Node>();
        visited = false;
    }

    public void visit(int level) {
        if (name != null) {
            System.out.println("Visited node: " + name + " at level: " + level);
        }
    }

    public void searchDFS(int level) {
        if (this == null) return;
//        if (!visited.contains(this.name)) {
//            this.visit();
//            visited.add(this.name);
//        } else {
//            return;
//        }
        this.visit(level);
        this.visited = true;

        for (Node n : children) {
            if (n.visited == false) {
                n.searchDFS(level+1);
            }
        }
    }
}

public class PointerGraph {
    public List<Node> nodes;
    public Node root;

    public PointerGraph() {
        root = null;
        nodes = new ArrayList<Node>();
    }

    public void addNode(String name) {
        root = new Node(name);
        nodes.add(root);
    }

    public void addNode(String sourceName, String targetName) throws NoSuchElementException {
        Node sourceNode = null;
        Node targetNode = null;
        for (Node n : nodes) {
            if (n.name == sourceName) {
                sourceNode = n;
                // TODO: check if target is in graph, b/c
                // need to add a pointer to that to keep them up-to-date
            } else if (n.name == targetName) {
                targetNode = n;
            }
        }
        if (sourceNode == null) {
            throw new NoSuchElementException("can't find source node");
        }
        if (targetNode == null) {
            targetNode = new Node(targetName);
            nodes.add(targetNode);
        }
        sourceNode.children.add(targetNode);
    }

    public void searchDFS() {
        this.root.searchDFS(0);
    }

    public void searchBFS() {
        LinkedList<Node> queue = new LinkedList<Node>();
        int level = 0;
        root.visited = true;
        queue.add(root); // Add to the end of the queue

        while (!queue.isEmpty()) {
            Node r = queue.remove(); // remove from the front of the queue
//            level++;
            r.visit(level);
            for (Node n : r.children) {
                if (n.visited == false) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }

//    public void searchBFS() {
//        HashMap<Node,Integer> levels = new HashMap<Node,Integer>();
//        levels.put(root, 0);
//        HashMap<Node,Node> parents = new HashMap<Node,Node>();
//        parents.put(root, null);
//        int i = 1;
//        ArrayList<Node> frontier = new ArrayList<Node>();
//        frontier.add(root);
//        while (frontier.size() > 0) {
//            ArrayList<Node> next = new ArrayList<Node>();
//            for (Node u : frontier) {
//                for (Node v : u.children) {
//                    if ()
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println("Testing Graph implementation...");
        PointerGraph g = new PointerGraph();
        g.addNode("a");
        g.addNode("a", "b");
        g.addNode("a", "e");
        g.addNode("a", "f");
        g.addNode("b", "d");
        g.addNode("b", "e");
        g.addNode("d", "e");
        g.addNode("d", "c");
        g.addNode("c", "b");
        System.out.println("------------------");
        System.out.println("Running DFS on graph");
//        g.searchDFS();
        g.searchBFS();
    }

}