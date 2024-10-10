public class MinimumBitFlipsToConvertNumber{

    public static void getCount(int start, int goal){
        int count=0;
        while(start>0 || goal>0){
            if(((start & 1)==1 && ((goal & 1)==0)) || ((goal & 1)==1 && ((start & 1)==0))){
                count++;
            }
            start=start>>1;
            goal=goal>>1;
        }
        System.out.println(count);

    }

    public static void main(String [] args){
        getCount(5, 7);
    }
}