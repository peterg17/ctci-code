package Datastructures.Trees;

public class SampleNode {

    public int currIdx;
    public BTNode currNode;

    public static class BTNode {
        public int value;
        public BTNode left;
        public BTNode right;
        public BTNode(int val) {
            value = val;
        }
    }

    public BTNode sampleBTNode(BTNode root) {
        // find the total number of nodes by traversing the tree
        int numNodes = findBTLength(root);
        System.out.println("node has num children: " + numNodes);
        // traverse to the node using in-order traversal
//        int sampledIdx = (int) Math.floor(Math.random() * numNodes);
        int sampledIdx = 4;
        this.currIdx = sampledIdx;
        System.out.println("sampled idx in binary tree: " + sampledIdx);
//        BTNode sampledNode = sampleBTNodeHelper(root, sampledIdx);
        sampleBTNodeHelper(root);
        System.out.println("sample BT node has value: " + this.currNode.value);
        return this.currNode;
    }

    public int findBTLength(BTNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + findBTLength(root.left) + findBTLength(root.right);
        }
    }

    /*
      3
    /   \
    20   6
         / \
        22  8
   */
    public void sampleBTNodeHelper(BTNode root) {
//        if (this.currIdx == 0) {
//            return root;
//            this.currNode = root;
//        }
        if (root == null) {
            return;
        }
        // left child
//        int newIdx = sampledIdx - 1;
//        int numLeftChildren = findBTLength(root.left);
        sampleBTNodeHelper(root.left);
        this.currNode = root;
        if (currIdx == 0) return;
        this.currIdx -= 1;
        sampleBTNodeHelper(root.right);
//        if (left != null) {
//            return left;
//        } else if (right != null) {
//            return right;
//        } else {
//            return null;
//        }
    }



    public static void main(String[] args) {
        System.out.println("Testing SampleNode class...");
        BTNode root = new BTNode(3);
        root.left = new BTNode(20);
        BTNode right = new BTNode(6);
        right.left = new BTNode(22);
        right.right = new BTNode(8);
        root.right = right;
        SampleNode sn = new SampleNode();
        BTNode out = sn.sampleBTNode(root);
    }



}
