class GCD{
    
    // Time Complexity: O(min(a,b)) 
    // Auxiliary Space: O(1)
    public static int getGCD(int a, int b){
        // Find Minimum of a and b
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }

    // Time Complexity: O(log(min(a,b)))
    // Auxiliary Space: O(1)
    public  static int getGCD2(int a, int b)
    {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    public static void main(String []args){
        System.out.println(getGCD2(30, 40));
    }
}