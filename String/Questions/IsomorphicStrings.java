import java.util.*;

public class IsomorphicStrings{

    //Time Complexity: O(n)
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int [] sIndex = new int [200];
        int [] tIndex= new int [200];

        for(int i=0; i<s.length(); i++){

            if(sIndex[s.charAt(i)] != tIndex[t.charAt(i)])
                return false;
            
            sIndex[s.charAt(i)] = i+1;
            tIndex[t.charAt(i)]  = i+1;
        }
        return true;
    }

    public static void main (String args[]){
        System.out.println(isIsomorphic("eat", "ate"));
    }
}