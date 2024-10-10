
import java.util.*;
public class NumberOfNGEsToTheRight{

    public static void countInversion(List<List<Integer>> list, int s, int e, int ans[]){
        if(s>=e)
            return;

        int mid = (s+e)/2;
        
        countInversion(list, s, mid, ans);
        countInversion(list, mid+1, e, ans);
        merge(list, s, mid, e, ans);
    }

    public static void merge (List<List<Integer>> list, int s, int mid, int e, int ans[]){
        List<List<Integer>> temp = new ArrayList<>();
        //iterator
        int l=s;
        int r=mid+1;
        

        while(l<=mid && r<=e){
            if(list.get(l).get(0) <list.get(r).get(0)){
                temp.add(Arrays.asList(list.get(l).get(0), list.get(l).get(1)));
                ans[list.get(l).get(1)] += (e-r+1);
                l++;

            }else{
                temp.add(Arrays.asList(list.get(r).get(0), list.get(r).get(1)));
                r++;
            }

        }

        while(l<=mid){
            temp.add(Arrays.asList(list.get(l).get(0), list.get(l).get(1)));
            l++;
        }
        while(r<=e){
            temp.add(Arrays.asList(list.get(r).get(0), list.get(r).get(1)));
            r++;
        }

        for(int i=s; i-s<temp.size(); i++){

            list.set(i, Arrays.asList(temp.get(i-s).get(0), temp.get(i-s).get(1)));
        }
        // for(int x : ans){
        //     System.out.print(x+" ");
        // }

        // System.out.println();
    }

    public static void main(String [] arg){
        int arr[]={3, 4, 2, 7, 5, 8, 10, 6};
        int ans[] = new int [arr.length];

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(Arrays.asList(arr[i], i));
        }

        countInversion(list, 0, arr.length-1, ans);

        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}