import java.util.* ;
class CountNumberOfSubstrings{

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public static int getCountByBruteForce(String str, int k) {

        if(str.length()==0)
            return 0;
        int ans=0;
        for (int i = 0; i < str.length(); i++) 
        {
            int visited[]= new int[26];
            int count=0;
            for (int j = i; j < str.length(); j++){
                int ind = str.charAt(j) - 'a';
                if (visited[ind]==0) {
                    count++;
                }
                visited[ind]++;
                if(count==k){
                    ans++;
                }else if(count>k){
                    break;
                }
            }
        }
        return ans;
    }

    //Time Complexity: O(2N)
    //Space Complexity: O(1) //26
    public static int getCountBySlidingWindow(String str, int k) {

        if(str.length()==0)
            return 0;

        int ans=0;
        int l=0, r=0;
        int count=0;
        int freq[]= new int[26];

        while(r<str.length()){
            int ind = str.charAt(r) - 'a';
            freq[ind]++;
            if(freq[ind]==1){
                count++;
            }

            while(count>k){
                int chIndex = str.charAt(l)-'a';
                freq[chIndex]--;
                if(freq[chIndex]==0){
                    count--;
                }
                l++;
            }
            
            ans+= r-l+1;
            r++;
        }
        
        return ans;
    }


    public static void main(String [] arg){
        System.out.print(getCountBySlidingWindow("ecbaddce", 3));
    }
}