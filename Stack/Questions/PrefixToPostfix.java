import java.util.*;
class PrefixToPostfixConversion{

    public static String prefixToPostfix (String s){
        Stack<String> st = new Stack<>();
        String ans="";
        
        for(int i=s.length()-1; i>=0; i--){
            char c= s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String a = st.pop();
                String b = st.pop();
                st.push(a+b+c);
                System.out.println(st.peek());
            }
        }

        return st.pop();
    }

    public static void main(String args[]){
        String str = "+-*-+AByCD^^FZs";
        System.out.println(prefixToPostfix(str));
    }
}