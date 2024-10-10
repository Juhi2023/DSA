import java.util.*;

public class CountingSort{

    //for positive only
    public static void sort(int arr[]){
            //for positive only

            // int n=arr.length, max=0;
            // for(int i=0; i< n; i++){
            //     if(arr[i]>max){
            //         max=arr[i];
            //     }
            // }
            // int count[] = new int[max+1];
            // for(int i=0; i<n; i++){
            //     count[arr[i]]++;
            // }

            // int j=0;
            // for(int i=0; i<max+1; i++){
            //     while(count[i]>0){
            //         arr[j]=i;
            //         count[i]--;
            //         j++;
            //     }
            // }

            //for both
            int n=arr.length, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

            for(int i=0; i< n; i++){
                if(arr[i]>max){
                    max=arr[i];
                }
                if(arr[i]<min){
                    min=arr[i];
                }
            }

            //min=-5 max=2 --> n=8
            //2 --> 7
            //1 --> 6
            //0 --> 5
            //-1 --> 4
            //-2 --> 3

            //Number saving in form -5, -4, - -- 0, 1, 2

            int count[] = new int[max-min+1];
            for(int i=0; i<n; i++){
                count[arr[i]-min]++;  //max-a[i] Number saving in form  2, 1, 0, -1, -2
            }

            

            int j=0;
            for(int i=0; i<max-min+1; i++){
                while(count[i]>0){
                    arr[j]=i+min;   //max-i
                    count[i]--;
                    j++;
                }
            }


        for(int i=0; i< n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String [] arg){
        int arr[]={5,2,3,1};
        sort(arr);
    }
}