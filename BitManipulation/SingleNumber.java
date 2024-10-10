public class SingleNumber{

    public static int getUniqueNumber(int []nums){
        int xor=0;
        for(int i=0; i< nums.length; i++){
            xor^=nums[i];
        }
        return xor;
    }

    public static void main(String [] args){
        int [] arr = {2,3,4,2,6,7,4,3,6};
        System.out.println(getUniqueNumber(arr));
    }
}