import java.util.*;

class DuplicateParentheses{

    public static boolean hasDupulicate(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==')'){
                if(st.peek()=='(')
                    return true;
                while(st.peek()!='('){
                    st.pop();
                }
                st.pop();
            }else{
                st.push(c);
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(hasDupulicate("(((a+(b)))+(c+d))"));
    }
}