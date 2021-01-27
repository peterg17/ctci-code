package Datastructures.Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

class TraverseInfo {
    String name;
    int level;
    int offset;
    String from;

    public TraverseInfo(String name, int level, int offset, String from) {
        this.name = name;
        this.level = level;
        this.offset = offset;
        this.from = from;
    }
}

public class Traversals {
    //                      a
    //                    /   \
    //                   b     d
    //                    \
    //                     c
    //
    public static void visit(TreeNode node, int level, String from) {
        if (node.name != null) {
            System.out.println("The node at level: " + level + " from: " + from
                                + " and has data: " + node.name);
        }
    }

    public static void inOrderTraversal(TreeNode node, int level, String from) {
        if (node != null) {
            inOrderTraversal(node.left, level+1, "left");
            visit(node, level, from);
            inOrderTraversal(node.right, level+1, "right");
        }
    }

    public static void preOrderTraversalList(ArrayList<TraverseInfo> traverses, TreeNode node, int level, int offset, String from) {
        if (node != null) {
            TraverseInfo out = new TraverseInfo(node.name, level, offset, from);
            traverses.add(out);
            preOrderTraversalList(traverses, node.left, level+2, offset-1, "left");
            preOrderTraversalList(traverses, node.right, level+2, offset+1, "right");
        }
    }



    public static void printTraverseList(ArrayList<TraverseInfo> traverses) {
        String out = "";
        String[][] levels = new String[6][50];
        for (int i=0; i < levels.length; i++) {
            for (int j=0; j < levels[0].length; j++) {
                levels[i][j] = " ";
            }
        }
        for (TraverseInfo t : traverses) {
            if (t.from.equals("left")) {
                levels[t.level][t.offset] = "/";
                levels[t.level+1][t.offset] = t.name;
            } else if (t.from.equals("right")) {
                levels[t.level][t.offset] = "\\";
                levels[t.level+1][t.offset] = t.name;
            } else if (t.from.equals("root")) {
                levels[t.level][t.offset] = t.name;
            }
            System.out.println("Traverse at level: " + t.level + " has data: " + t.name
                            + " has offset: " + t.offset + " and is from: " + t.from);

        }
        out = stringArrayJoin(levels);
        System.out.println(out);
    }

    public static String stringArrayJoin(String[][] arr) {
        String str = "";
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++) {
                str += arr[i][j];
            }
            str += "\n";
        }
        return str;
    }

//    public static void preOrderTraversal(TreeNode node) {
//        if (node != null) {
//            visit(node);
//            preOrderTraversal(node.left);
//            preOrderTraversal(node.right);
//        }
//    }
//
//    public static void postOrderTraversal(TreeNode node) {
//        if (node != null) {
//            postOrderTraversal(node.left);
//            postOrderTraversal(node.right);
//            visit(node);
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Testing TreeNode traversal...");
        ArrayList<String> vals = new ArrayList<String>();
//        vals.add("b");
//        vals.add("c");
//        vals.add("a");
//        vals.add("d");
        TreeNode root = new TreeNode("a");
        TreeNode left = root.addLeft("b");
        left.addRight("c");
        TreeNode right = root.addRight("d");
//        TreeNode root = new TreeNode(vals, 0);
        System.out.println("Binary tree values are: ");
        ArrayList<TraverseInfo> traverses = new ArrayList<TraverseInfo>();
        preOrderTraversalList(traverses, root, 0, 20, "root");
        printTraverseList(traverses);

        //        preOrderTraversal(root);
//        postOrderTraversal(root);
    }
}