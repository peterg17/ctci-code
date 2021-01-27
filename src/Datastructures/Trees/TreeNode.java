package Datastructures.Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class TreeNode {
    public String name;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String val) {
        this.name = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(ArrayList<String> vals, int count) {
        if (count == vals.size()) {
            return;
        }

        String currStr = vals.get(count);
        this.name = currStr;
        if (count % 2 == 0) {
            this.left = new TreeNode(vals, count+1);
        } else {
            this.right = new TreeNode(vals, count+1);
        }
    }

    public TreeNode addRight(String val) {
        this.right = new TreeNode(val);
        return this.right;
    }

    public TreeNode addLeft(String val) {
        this.left = new TreeNode(val);
        return this.left;
    }

}