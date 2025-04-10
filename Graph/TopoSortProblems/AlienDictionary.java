import java.util.*;

class AlienDictionary {

    
    static String topologicalSort(List<List<Integer>> adj, boolean[] exists, int V) {
        int indegree[] = new int[V];
        for(int i=0; i<26; i++){
            for(int x: adj.get(i)){
                indegree[x]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<26; i++){
            if(indegree[i]==0 && exists[i]){
                q.offer(i);
            }

        }
        String s="";
        while(!q.isEmpty()){
            int n = q.poll();
                s +=(char)(n+'a');
            for(int x: adj.get(n)){
                indegree[x]--;
                if(indegree[x]==0)
                    q.offer(x);
            }
        }
        if (s.length() != countExistsCharacters(exists)) {
            return "";  // Cycle detected, no valid order
        }
        return s;
    }
    
    private static int countExistsCharacters(boolean[] exists) {
        int count = 0;
        for (boolean e : exists) {
            if (e) count++;
        }
        return count;
    }
    
    public static String findOrder(String[] words) {
        int V=26;
        boolean[] exists = new boolean[26];
        for(String word : words) {
            for(char ch : word.toCharArray()) {
            exists[ch - 'a'] = true;
            }
            
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            int len= Math.min(w1.length(), w2.length());
            for(int j=0; j<len; j++){
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    break;
                }
            }
            
        }

        //topossort
        String s= topologicalSort(adj, exists, V);
        
        return s;
    }

    
    public static void main(String[] args) {
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        int k = 4;
        String ans = findOrder(arr);
        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
    }
}
