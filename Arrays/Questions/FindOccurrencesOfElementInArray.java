import java.util.*;
public class FindOccurrencesOfElementInArray{
    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> freq = new ArrayList<>();
        int ans[] = new int [queries.length];
        for(int i=0; i< nums.length; i++){
            if(nums[i]==x){
                freq.add(i);
            }
        }

        for(int i=0; i< queries.length; i++){
            if(queries[i]<=freq.size()){
                ans[i]=freq.get(queries[i]-1);
            }else{
                ans[i]=-1;
            }
        }

        return ans;
    }

    public static void main(String []arg){
        int[] arr = {1,3,1,7};
        int queries[] = {1,3,2,4};
        int ans[] = occurrencesOfElement(arr, queries, 1);
        for(int n: ans){
            System.out.print(n+" ");
        }
    }
}
