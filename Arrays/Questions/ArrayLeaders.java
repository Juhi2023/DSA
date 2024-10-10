//https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array

import java.util.*;

public class ArrayLeaders{

    public static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=n-1;
        list.add(arr[i]);
        int max=arr[i];
        i--;
        while(i>=0){
            if(arr[i]>=max){
                max=arr[i];
                list.add(arr[i]);
            }
            i--;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {10,4,2,4,1};

        System.out.println(leaders(arr.length, arr));
    }
}