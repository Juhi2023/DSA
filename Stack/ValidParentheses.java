import java.util.*;
class ValidParentheses{

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char p = st.peek();
                 if((p=='(' && c==')') || (p=='{' && c=='}') || (p=='[' && c==']')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String args[]){
        String str = "()[]{}";
        
        System.out.println(isValid(str));
    }
}