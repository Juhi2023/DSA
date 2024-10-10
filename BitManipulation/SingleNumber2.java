public class SingleNumber2{

    public static boolean getBit(int n, int i){
        return (n & (1<<i)) !=0;
    }
    public static int setBit(int n, int i){
        return n | (1<<i);
    }
    public static int getUniqueNumber(int []nums){
        int result=0;
        for(int i=0; i<32; i++){
            int sum=0;
            for(int j=0; j<nums.length; j++){
                if(getBit(nums[j], i))
                    sum++;
            }

            if(sum%3 !=0)
                result = setBit(result, i);
        }
        return result;
    }

    public static void main(String [] args){
        int [] arr = {2,3,4,2,6,7,4,3,6, 2,3,4,6};
        int result = getUniqueNumber(arr);
        System.out.println(result);
    }
}