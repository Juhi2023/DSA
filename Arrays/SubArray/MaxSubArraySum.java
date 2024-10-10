import java.util.*;

public class MaxSubArraySum{

    public static void maxSubArraySumByBruteForce(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            int start=i;
            
            for(int j=i; j<arr.length ; j++){
                int end=j, sum=0;
                
                for(int k=start; k<=end; k++){
                    sum+=arr[k];
                }

                if(maxSum<sum){
                    maxSum=sum;
                }
            }
        }

        System.out.println("Max Sum: "+ maxSum);

    }

    public static void maxSubArraySumByBruteForce2(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            int sum=0;
            
            for(int j=i; j<arr.length ; j++){
                sum+=arr[j];

                if(maxSum<sum){
                    maxSum=sum;
                }
            }
        }

        System.out.println("Max Sum: "+ maxSum);

    }

    public static void maxSubArraySumByPrefix(int arr[]){
        if(arr.length==0)
            return;
              
        int prefixSum[] = new int[arr.length];
        int maxSum=Integer.MIN_VALUE;

        //calculate prefix array
        prefixSum[0]=arr[0];
        for(int i=1; i< arr.length; i++){
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        //find
        for(int i=0; i< arr.length; i++){
            int start=i;

            for(int j=i; j<arr.length ; j++){
                int end=j;

                int currSum= start==0 ? prefixSum[end] : prefixSum[end]-prefixSum[start-1];

                if(currSum>maxSum)
                    maxSum=currSum;
            }
        }

        System.out.println("Max Sum: "+ maxSum);

    }

    public static void maxSubArraySumByKadanes(int arr[]){
        if(arr.length==0)
            return;

        //check if array contain only negative number
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int start=0, end=0, s=0;

        for(int i=0; i<arr.length; i++){
            currSum += arr[i];

            if(maxSum<currSum){
                maxSum=currSum;
                start = s;
                end = i;
            }

            if(currSum<0){
                currSum=0;
                s=i+1;
            }
        }
        

        System.out.println("Max Sum: "+ maxSum);
        System.out.println("Start Index: "+ start);
        System.out.println("End Index: "+ end);

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        maxSubArraySumByKadanes(arr);
    }
}