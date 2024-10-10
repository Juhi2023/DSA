class FibonnaciSeries{
    
    public static int getFibonnaciSeries(int n){
        if(n==0 || n==1)
            return n;
        int f1= getFibonnaciSeries(n-1);
        int f2= getFibonnaciSeries(n-2);

        return f1 + f2;
    }

    public static void main(String []args){
        System.out.println(getFibonnaciSeries(25));
    }
}