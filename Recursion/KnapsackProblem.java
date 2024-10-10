//Find the number of ways to reach e from s.

class KnapsackProblem{
    
    public static int getMaxValue(int value[], int weight [], int n, int w){
        if(w==0  || n == value.length)
            return 0;

        if(w- weight[n] < 0)
            return 0;

        //on including
        int value1= value[n] + getMaxValue(value, weight, n+1, w- weight[n]);
        //not including
        int value2= getMaxValue(value, weight, n+1, w);

        return Math.max(value1, value2);
    }

    public static void main(String []args){
        int value[] = {100, 50, 150};
        int weight [] ={10, 20, 30};
        System.out.println(getMaxValue(value, weight, 0, 50));
    }
}