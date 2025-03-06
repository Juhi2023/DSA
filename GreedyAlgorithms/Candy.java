import java.util.*;
class Candy{

    //Time Complexity: O(3N)
    //Space Complexity: O(2N)
    public static int getMinimumCandies(int []rating){
        int n = rating.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = 1;
        right[n-1]=1;

        int totalCookies=0;
        
        for(int i=1; i<n; i++){
            if(rating[i-1]<rating[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(rating[i+1]<rating[i]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }

        for(int i=0; i<n; i++){
            totalCookies+= Math.max(left[i], right[i]);
        }

        return totalCookies;
    }
    
    //Greedy Approach
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int getMinimumCandiesByGreedy(int []rating){
        int n = rating.length;
        int totalCookies=1;
        int i=1;
        while(i<n){
            if(rating[i]==rating[i-1]){
                totalCookies++;
                i++;
                continue;
            }  

            int peak=1;
            while(i<n && rating[i-1] < rating[i]){
                peak++;
                totalCookies += peak;
                i++;
            }
            int down=1;
            while(i<n && rating[i-1] > rating[i]){
                totalCookies+=down;
                down++;
                i++;
            }
            if(down > peak){
                totalCookies += (down-peak);
            }
        }

        return totalCookies;
    }

    public static void main(String[] args) {
        int[] rating = {4, 2, 1, 2, 1, 3};
        System.out.println(getMinimumCandies(rating));
    }
}