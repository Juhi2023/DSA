import java.util.*;
class ReverseStringUsingStack{

    public static void main(String args[]){
        Stack<Character> s = new Stack<>();
        String str = "Hello";
        StringBuilder newStr = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }

        while(!s.isEmpty()){
            newStr.append(s.pop());
        }
        System.out.println(newStr.toString());
    }
}