public class SingleNumber3{

    public static int[] getUniqueNumber(int []nums){
        int[] result = new int[2];
        int xor = 0;

        // Step 1: Compute XOR of all elements in the array
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // Step 2: Find the rightmost set bit in xor
        int pos = 0;
        int tempXOR= xor;
        while ((xor & 1) != 1) {  // can't give greater than 0 condition otherwise will not consider negative number 
            xor >>= 1;
            pos++;
        }

        // Step 3: Separate numbers into two groups based on the bit at 'pos'
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> pos) & 1) == 1) {
                result[0] ^= nums[i];
            }
        }

        // Step 4: Calculate the second number
        result[1] = tempXOR ^ result[0];

        return result;
    }

    public static void main(String [] args){
        int [] arr = {2,3,4,2,6,7,4,3,6, 10};
        int result [] = getUniqueNumber(arr);
        for(int x: result){
            System.out.println(x);
        }
    }
}