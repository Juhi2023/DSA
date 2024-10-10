// /https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1

class Consecutive1NotAllowed{
        public static int countStrings(int n) {
            int zeroEnd =1;
            int oneEnd=1;
            int sum = zeroEnd + oneEnd;
            
            if(n==1)
                return sum;
            
            for(int i=2; i<=n; i++){
                oneEnd = zeroEnd %1000000007;
                zeroEnd = sum %1000000007 ;
                sum = (zeroEnd + oneEnd) %1000000007;
            }
            
            return sum;
        }

        public static void main(String [] args){
            System.out.println(countStrings(3));
        }
}