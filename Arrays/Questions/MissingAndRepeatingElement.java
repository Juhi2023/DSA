//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

import java.util.*;

public class MissingAndRepeatingElement{

    // Time Complexity: O(n)
    // Auxiliary Space: O(n)
    public static int[] findByByExtraSpace(int [] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];
        int ans[]= new int[2];
      
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[arr[i]]) {
                ans[0] = arr[i];  //repeating
            }
            else {
                visited[arr[i]] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ans[1] = i;    //missing
                break;
            }
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)

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

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {4,1,3,5,3};
        int ans[] = findBySumAndMath(arr);

        System.out.println("Repeating : " + ans[0]);
        System.out.println("Missing : " + ans[1]);
    }
}