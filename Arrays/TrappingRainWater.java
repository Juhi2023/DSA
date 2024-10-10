import java.util.*;

public class TrappedRainWater{

    //Using Auxilary array
    //Time Complexity: O(3n)
    //Space Complexity: O(n)
    public static void trappedRainWater(int height[]){
        int n=height.length;

        /// auxialry array
        //calcuate left  max boundary array
        int leftMax[] = new int[n];
        leftMax[0]=height[0];
        for(int i=1; i< n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //calcuate right  max boundary array
        int rightMax[] = new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int trappedWater=0;
        //loop
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater+=waterLevel-height[i];
        }

        System.out.println("Trapped Water: "+trappedWater);
    }


    //Using Two Pointer
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static void trappedRainWaterByTwoPointer(int height[]){
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int[] arr = {4, 2, 0, 6, 3, 2, 5};
        trappedRainWater(arr);
    }
}