//Alternate Question: Number of NGEs to the right

import java.util.*;
public class CountInversions{

    public static int countInversion(int arr[], int s, int e){
        if(s>=e)
            return 0;

        int mid = (s+e)/2;
        
        int leftCount = countInversion(arr, s, mid);
        int rightCount = countInversion(arr, mid+1, e);

        return leftCount + rightCount + merge(arr, s, mid, e);
    }

    public static int merge (int arr[], int s, int mid, int e){
        int temp [] = new int [e-s+1];
        //iterator
        int l=s;
        int r=mid+1;
        int k=0;
        int count=0;

        while(l<=mid && r<=e){
            if(arr[l]<arr[r]){
                temp[k]=arr[l];
                l++;
            }else{
                temp[k]=arr[r];
                r++;
                count += mid-l+1;
            }
                k++;
        }

        while(l<=mid){
            temp[k++]= arr[l++];
        }
        while(r<=e){
            temp[k++]= arr[r++];
        }

        //copy temp to arr
        for(int i=s; i-s<temp.length; i++){
            arr[i] = temp[i-s];
        }

        return count;
    }

    public static void main(String [] arg){
        int arr[]={5,3,2,1,4};
        System.out.print(countInversion(arr, 0, arr.length-1));
    }
}