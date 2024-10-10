import java.util.*;
class DecodeString {

    //Using Stack
    public static String decode(String s) {
        Stack<Character> st = new Stack<>();
        String ans="";
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(c!=']'){
                st.push(c);
            }else{
                String num="";
                String inner="";

                while(st.peek()!='['){
                    inner=st.pop()+inner;
                }

                st.pop();

                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num = st.pop()+num;
                }
                int n = Integer.parseInt(num);
                String subAns="";
                while(n>0){
                    subAns+=inner;
                    n--;
                }
                for(int j=0; j<subAns.length();j++){
                    st.push(subAns.charAt(j));
                }
            }
        }
        while(!st.isEmpty()){
            ans= st.pop()+ans;
        }

        return ans;
    }

    public static void main(String args[]){
        System.out.println(decode("3[a]2[b5[c]]"));
    }
}