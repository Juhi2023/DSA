class CountUniquePathsInMaze{
    
    //Time Complexity: O(2^n+m)
    public static int getWays(int i, int j, int n, int m){
        if(i==n-1 || j==m-1)
            return 1;
        
        int w1 = getWays(i+1, j, n, m);
        int w2 = getWays(i, j+1, n, m);
        return w1+w2;
    }

    //Using Math : permutation
    // Permutation of (n-1+m-1)
    //(n-1+m-1)!/(n-1)! (m-1)! (repeating)

    public static void main(String []args){
        System.out.println(getWays(0,0, 3, 5));
    }
}