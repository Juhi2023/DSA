import java.util.*;

public class MinimumNumberOfPlatformsRequiredForRailway{

    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    public static int findPlatform(int[] arr, int[] dep, int n) {
        int ans=1; 
        for(int i=0;i<=n-1;i++){
            int count=1; 
            for(int j=i+1;j<=n-1;j++)
            {
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i])){
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }

    // Time Complexity: O(n * log n)
    // Auxiliary Space: O(1)
    public static int findPlatformByGreedy(int[] arr, int[] dep, int n) {
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            }else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 

            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
    }


    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length; 
        System.out.println(findPlatform(arr,dep,n));
    }
}