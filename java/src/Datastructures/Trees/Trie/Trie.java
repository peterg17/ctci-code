package Datastructures.Trees.Trie;

class TrieNode {
    char value;
    boolean isTerminal;
    TrieNode[] children;

    TrieNode(char v, boolean isTerm) {
        value = v;
        isTerminal = isTerm;
        children = new TrieNode[26];
    }
}

public class Trie {

    TrieNode root;

    /**
     * Trie API:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */


    public Trie() {
        root = new TrieNode(' ', false);
    }

    public void insert(String word) {
        int count = 0;
        TrieNode currNode = root;
        while (count < word.length()) {
            char currLetter = word.charAt(count);
            int charVal = currLetter - 'a'; // should be between 0 and 25
            if (currNode.children[charVal] != null) {
                currNode = currNode.children[charVal];
            } else {
                TrieNode newNode = new TrieNode(currLetter, false);
                currNode.children[charVal] = newNode;
                currNode = newNode;
            }
            count++;
        }
        currNode.isTerminal = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i=0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int charVal = c - 'a';
            if (currNode.children[charVal] != null) {
                currNode = currNode.children[charVal];
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charVal = c - 'a';
            if (currNode.children[charVal] != null) {
                currNode = currNode.children[charVal];
            } else {
                return false;
            }
        }
        if (currNode.isTerminal) {
            return true;
        }
        return false;
    }

    public static void traverse(TrieNode node) {
        if (node == null) {
            return;
        }
        System.out.println("trie node has value: " + node.value + " is terminal node: " + node.isTerminal);
        for (int i=0; i < node.children.length; i++) {
            TrieNode childNode = node.children[i];
            if (childNode != null) {
                traverse(childNode);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing trie implementation...");

        Trie trie = new Trie();

        trie.insert("apple");
        boolean res1 = trie.search("apple");   // returns true
        boolean res2 = trie.search("app");     // returns false
        boolean res3 = trie.startsWith("app"); // returns true
        trie.insert("app");
        boolean res4 = trie.search("app");     // returns true
        System.out.println("test1 is if apple search is in trie, should be true is: " + res1);
        System.out.println("test2 is if app search is in trie, should be false is: " + res2);
        System.out.println("test3 is if app prefix is in trie, should be true is: " + res3);
        System.out.println("test4 is if app search is now in trie after inserting should be true is: " + res4);
        System.out.println("-----------------------");
        traverse(trie.root);
    }
}