import java.util.*;
class InfixToPostfixConversion{

    public static int precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix (String s){
        Stack<Character> st = new Stack<>();
        String ans="";
        
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans+= c;
            }else if(c=='('){
                st.push(c);
            }else if(c==')'){
                while(!st.isEmpty() && st.peek()!='(')
                    ans+= st.pop();
                st.pop();
            }else{
                while(!st.isEmpty() && precedence(c)<=precedence(st.peek())){
                    ans+= st.pop();
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(')
                return "Invalid Expression";
            ans += st.pop();
        }


        return ans;
    }

    public static void main(String args[]){
        String str = "(A+B)*C-D+F^Z^s ";
        
        System.out.println(infixToPostfix(str));
    }
}