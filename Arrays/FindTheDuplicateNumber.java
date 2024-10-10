import java.util.*;

class FindTheDuplicateNumber{
    public static int[] findBySumAndMath(int [] arr) {
        int n = arr.length;
        int ans[]= new int[2];
        ans[1] = (n * (n+1))/2;   //Missing
      
        for (int i = 0; i < n; i++) {
            int absVal = Math.abs(arr[i]);
            if (arr[absVal - 1] < 0) {
                ans[0] = absVal; 
            } else {
                arr[absVal - 1] *= -1;
            }
        }
        
        for(int i=0; i<n; i++){
            if(arr[i]>0) 
                ans[1] = i+1;
        }

        return ans;
    }

    //without changing array
    public static int[] findBySlowAndFastPointer(int [] arr) {
        int n = arr.length;
        int ans[]= new int[2];
        ans[1] = (n * (n+1))/2;   //Missing
      
        for (int i = 0; i < n; i++) {
            int absVal = Math.abs(arr[i]);
            if (arr[absVal - 1] < 0) {
                ans[0] = absVal; 
            } else {
                arr[absVal - 1] *= -1;
            }
        }
        
        for(int i=0; i<n; i++){
            if(arr[i]>0) 
                ans[1] = i+1;
        }

        return ans;
    }

    public static void main(String []args){
        int arr []= {3,1,3,4,2};
        System.out.print(findBySlowAndFastPointer(arr));
    }
}