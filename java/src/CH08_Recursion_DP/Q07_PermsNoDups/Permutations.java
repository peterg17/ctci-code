package CH08_Recursion_DP.Q07_PermsNoDups;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutations {

    /*
    Problem: Write a method to compute all permutations of
    a string of unique characters

    "a" (1! = 1) -> ["a"]
    "ab" (2! = 2) -> ["ab", "ba"]
    "abc" (3! = 6) -> ["abc", "acb", "bac", "bca", "cab", "cba"]

    How many permutations of a string are there?
    n!
     */

    private static ArrayList<String> findPermutations(String inputString) {
        if (inputString == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<String>();
        if (inputString.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = inputString.charAt(0);
        String restString = inputString.substring(1);
        ArrayList<String> allPerms = findPermutations(restString);
        for (String perm : allPerms) {
            for (int j=0; j <= perm.length(); j++) { // index until end because can place char after string
                String s = insertCharAtIdx(perm, firstChar, j);
                permutations.add(s);
            }
        }

        return permutations;
    }

    private static String insertCharAtIdx(String str, char c, int idx) {
        String start = str.substring(0, idx);
        String end = str.substring(idx);
        return start + c + end;
    }

    public static void main(String[] args) {
        System.out.println("Testing Permutations Without Dups...");
        String str = "abc";
        ArrayList<String> outputPerms = findPermutations(str);
        System.out.println("Input string: " + str + " has permutations: " + outputPerms);
    }
}