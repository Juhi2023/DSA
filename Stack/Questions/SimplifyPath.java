import java.util.*;
class SimplifyPath {

    //Using Stack
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<path.length(); i++){
            char c=path.charAt(i);
            if(c=='/'){
                if(!st.isEmpty() && st.peek().equals("/"))
                    continue;
                else
                    st.push("/");
            }else{
                int start=i;
                while(i<path.length() && path.charAt(i) !='/'){
                    i++;
                }
                i--;
                String substr = path.substring(start, i+1);
                if(substr.equals("..")){
                    if(st.size()>2){
                        st.pop();
                        st.pop();
                    }
                }else if(!substr.equals(".")){
                    st.push(substr);
                }
            }
        }

        String ans="";
        if(st.peek().equals("/"))
            st.pop();

        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }

        if(ans.equals(""))
            ans+="/";
        return ans;
    }

    public static void main(String args[]){
        System.out.println(simplifyPath("/home///./..user/Documents/../Pictures"));
    }
}