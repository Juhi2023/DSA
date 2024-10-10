public class Operations{
    //bitMask : operation that we will perform with n
    
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) ==0)
            return 0;
        return 1;
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit){
        // if(newBit== 0){
        //     return clearBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n,i);
        return n | (newBit <<i);
    }

    public static int clearLastIthBits(int n, int i){
        int bitMask = -1<<i;
        return n & bitMask;
    }

    public static int clearRangeBits(int n, int i, int j){
        int a = (-1)<<(j+1);
        int b = ~(-1 << (i+1)); //OR  (1<<i) -1 
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String [] args){
        System.out.println(getIthBit(5, 2));
        System.out.println(setIthBit(5, 2));
        System.out.println(clearIthBit(5, 2));
        System.out.println(updateIthBit(5, 2, 1));
        System.out.println(clearLastIthBits(5, 2)); //100
        System.out.println(clearRangeBits(10, 2, 4));

    }
}