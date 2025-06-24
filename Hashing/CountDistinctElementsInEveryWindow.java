import java.util.*;

class CountDistinctElementsInEveryWindow{

    //Brute Force
    //Time complexity: O(n*k*k)
    //Space complexity: O(1)
    static int windows(int arr[], int num,int k){
        int count = 0;

        for (int i = num; i <num+k; i++) {
        
            int j;
            for (j = num; j <num+k; j++)
                if (arr[i] == arr[j])
                    break;
            if (j == i)
                count++;
        }
        return count;
    }
    static void countDistinct(int arr[], int n, int k)
    {
    
        for (int i = 0; i <= n - k; i++)
            System.out.print(windows(arr,i, k)+" ");
    }

    //HashMap
    //Time complexity: O(n)
    //Space complexity: O(n)
    static int windowsByMap(int arr[], int num,int k){
        ArrayList<Integer> ans=new ArrayList<>(); 
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0,i=0;
        while(j<n)
        {
           map.put(A[j], map.getOrDefault(A[i],0)+1);
            
            if(j-i+1==k)
            {
                ans.add(map.size());
                map.put(A[i],map.get(A[i])-1);
                if(map.get(A[i])==0)
                    map.remove(A[i]);
                i++;
            }
            j++;
        }
       for(int x: ans)
        System.out.print(x+" ");
    }




    public static void main(String args[])
    {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
        int n = arr.length;
        countDistinct(arr, n, k);
        
    }
}