import java.util.*;

class FirstRepeatingElementIndex{
    public static int getFirstRepeatingElementIndex(int nums[]){
        int store[] = new int[nums.length+1];
        Arrays.fill(store, -1);

        for(int i=0; i<nums.length; i++){
            if(store[nums[i]]==-1){
                store[nums[i]]=i;
            }else{
                return store[nums[i]];
            }
        }

        return -1;
    }

    public static void main(String []args){
        int arr []= {1,4,5,6,7,5,4};
        System.out.print(getFirstRepeatingElementIndex(arr));
    }
}