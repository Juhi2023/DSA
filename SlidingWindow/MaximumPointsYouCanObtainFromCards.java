//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

import java.util.* ;
class MaximumPointsYouCanObtainFromCards{


    //Time Complexity: O(2k)
    //Space Complexity: O(1)
    public static int maxScore(int[] cardPoints, int k) {
        int max=0;
        int sum =0;
        int l=0;
        while(l<k){
            sum+=cardPoints[l];
            l++;
        }
        l--;
        max=Math.max(max, sum);

        int r = cardPoints.length-1;
        while(l>=0){
            sum-=cardPoints[l];
            sum+=cardPoints[r];
            max=Math.max(max, sum);
            l--;
            r--;
        }
        return max;
    }


    public static void main(String [] arg){
        int cardPoints [] = {1,2,3,4,5,6,1};
        System.out.print(maxScore(cardPoints, 3));
    }
}