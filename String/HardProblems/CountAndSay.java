import java.util.*;
class CountAndSay {
    public static String countAndSay(int n) {
        if(n==0) return "";
        String result="1";
        for(int i=1; i<n; i++){
            StringBuilder st = new StringBuilder("");
            int cnt=1;
            char c = result.charAt(0);
            
            for(int j=1; j<result.length(); j++){
                if(c==result.charAt(j)){
                    cnt++;
                }else{
                    st.append(cnt).append(c);
                    cnt=1;
                    c = result.charAt(j);
                }
            }
            st.append(cnt).append(c);
            result = st.toString();
            
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(countAndSay(6));
    }
}