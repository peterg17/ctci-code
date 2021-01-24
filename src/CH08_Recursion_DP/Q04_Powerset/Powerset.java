package CH08_Recursion_DP.Q04_Powerset;

import java.util.ArrayList;

public class Powerset {

    /*
    Problem: Write a method to return all subsets of a set

    {a,b} = {{}, {a}, {b}, {a,b}}
    {a,b,c} = {{}, {a}, {b}, {a,b}, {c}, {a,c}, {b,c}, {a,b,c}}
            = {power({a,b})..., {c}, {a,c}, {b,c}, {a,b,c}}
            = {power({a,b})..., power({a,b}) + {c}}

    Case n == 0: return {}
    Case n == 1: return {}, {a}
    Case n == 2: return {}, {a}, {b}, {a,b}
    Case n == 3: return Powerset(input[:3]) + {c}
     */

    private static ArrayList<ArrayList<String>> GetSubsets(ArrayList<String> inputSet, int idx) {
        ArrayList<ArrayList<String>> allSubsets;
        if (inputSet.size() == idx) {
            allSubsets = new ArrayList<ArrayList<String>>();
            allSubsets.add(new ArrayList<String>());
        } else {
            allSubsets = GetSubsets(inputSet, idx + 1);
            String currItem = inputSet.get(idx);
            ArrayList<ArrayList<String>> newSubsets = new ArrayList<ArrayList<String>>();
            for (ArrayList<String> subset : allSubsets) {
                ArrayList<String> nextSubset = new ArrayList<String>();
                nextSubset.addAll(subset);
                nextSubset.add(currItem);
                newSubsets.add(nextSubset);
            }
            allSubsets.addAll(newSubsets);
        }
        return allSubsets;
    }


    public static void main(String[] args) {
        System.out.println("Testing powerset code...");
        ArrayList<String> inputSet = new ArrayList<String>();
        inputSet.add("a");
        inputSet.add("b");
        inputSet.add("c");
        ArrayList<ArrayList<String>> outputSet = GetSubsets(inputSet, 0);
        System.out.println("Test1 output: " + outputSet);

    }
}




