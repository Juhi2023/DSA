class InclusionExclusionPrinciple{
    
    public  static int getNumberOfNumberDivisilbleByAOrB(int n, int a, int b)
    {
        int c1=n/a;
        int c2=n/b;
        int c3=n/(a*b);
        return c1+c2-c3;
    }

    public static void main(String []args){
        System.out.println(getNumberOfNumberDivisilbleByAOrB(50, 3, 4));
    }
}