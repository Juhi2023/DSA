import java.util.*;

public class AsteroidCollision{
    
    public static String asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack<>();
        
        for(int i=0; i<asteroids.length; i++){
            int value = asteroids[i];
            if(value>0)
                st.push(value);
            else{
                while(!st.isEmpty() && st.peek()>0 && -value> st.peek()){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }

                if(st.peek()== -value)
                    st.pop();
            }
        }

        String res="";

        while(!st.isEmpty()) {
            res = st.pop()+", "+res;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(asteroidCollision(new int[]{5,10,-5}));
    }
}