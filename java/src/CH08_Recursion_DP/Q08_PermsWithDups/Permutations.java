package CH08_Recursion_DP.Q08_PermsWithDups;

import java.util.ArrayList;
import java.util.HashMap;

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

    private static ArrayList<String> findPermutations(String inputStr) {
        ArrayList<String> permutations = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(inputStr);
        findPermutationsHelper(map, "", inputStr.length(), permutations);
        return permutations;
    }

    private static void findPermutationsHelper(HashMap<Character,Integer> map, String prefix,
                                                int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                findPermutationsHelper(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }

    }

    private static HashMap<Character, Integer> buildFreqTable(String dupStr) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : dupStr.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println("Testing Permutations With Dups...");
        String str = "aabbbbc";
        ArrayList<String> outputPerms = findPermutations(str);
        System.out.println("Input string: " + str + " has permutations: " + outputPerms);
    }
}