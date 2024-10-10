import java.util.*;

public class Combination3{

    //recusrion approach
    //Time complexity: O(2^n * k)
    //Space Complexity: O(k)
    // k: average size of combination and X: number of combination
    public static void getCombination(List<Integer> combination,List<List<Integer>> ans, int n, int k, int i) {
        if (n==0 && k==0) {
            ans.add(new ArrayList < > (combination));
            return;
        }

        if(i>9){
            return;
        }

        combination.add(i);
        getCombination(combination, ans, n-i, k-1, i+1);
        combination.remove(combination.size() - 1);
        getCombination(combination, ans, n, k, i+1);

    }

   
    public static void main(String [] args){
        List<List<Integer>> result = new ArrayList<>();
        getCombination(new ArrayList<>(), result, 7, 3, 1);
        System.out.print(result);
    }
}