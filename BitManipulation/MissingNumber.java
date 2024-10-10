public class MissingNumber{

    public static int getNumber(int []nums){
        int xor1 = 0, xor2 = 0;
        int N = nums.length;
        // XOR of all elements in the array
        for (int i = 0; i < N; i++) {
            xor2 = xor2 ^ nums[i];
        }
        // XOR of all numbers from 1 to N
        for (int i = 1; i <= N; i++) {
            xor1 = xor1 ^ i;
        }

        return (xor1 ^ xor2);
    }

    public static void main(String [] args){
        int [] arr= {0,1,2,3,5,6};
        System.out.println(getNumber(arr));
    }
}