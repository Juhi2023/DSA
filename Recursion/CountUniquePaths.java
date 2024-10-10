//Find the number of ways to reach e from s.

class CountUniquePaths{
    
    public static int getNoOfPaths(int start, int end){
        if(start==end)
            return 1;

        if(start>end)
            return 0;
            
        int count=0;
        for(int i=1; i<=6; i++){
            count += getNoOfPaths(start+i, end);
        }

        return count;
    }

    public static void main(String []args){
        System.out.println(getNoOfPaths(0, 3));
    }
}