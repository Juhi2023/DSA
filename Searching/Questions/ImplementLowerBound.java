//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array

import java.util.*;

//The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal to the given number.
public class ImplementLowerBound{

    public static int findFloor(long arr[], int n, long x) {
        int index=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid =(start+end)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
                index=mid;
            }
        }
        return index;
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        long[] arr = {1,2,8,10,11,12,19};

        System.out.println(findFloor(arr, arr.length, 5));
    }
}