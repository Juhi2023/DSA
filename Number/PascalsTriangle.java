//https://leetcode.com/problems/pascals-triangle/description/

import java.util.*;
class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1= new ArrayList<>();
        l1.add(1);
        result.add(l1);

        for(int i=1; i<numRows; i++){
            int k=1;
            List<Integer> l= new ArrayList<>();
            l.add(1);
            while(k<=i-1){
                l.add(result.get(i-1).get(k-1)+result.get(i-1).get(k));
                k++;
            }
            l.add(1);
            result.add(l);
        }
        return result;
    }

    public static void main(String [] args){
        List<List<Integer>> result  = generate(5);
        for(List<Integer>  row : result){
            for(Integer col : row){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}