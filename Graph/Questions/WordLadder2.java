import java.util.*;

class WordLadder2 {
    public static class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    //Time Complexity: O(N*M*26) 
    //Space Complexity: O(N*M)
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();
        for(String x: wordList){
            st.add(x);
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> arr = new ArrayList<>();
        arr.add(beginWord);
        q.offer(arr);
        List<List<String>> ans = new ArrayList<>();
        
        int level=0;        
        List<String> usedWords = new ArrayList<>();
        usedWords.add(beginWord);

        while(!q.isEmpty()){
            ArrayList<String> curr=q.poll();
            if(curr.size()>level){
                level++;
                for(String x: usedWords){
                    st.remove(x);
                }
            }
            String word = curr.get(curr.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0){
                    ans.add(curr);
                }else if(ans.get(0).size()==curr.size()){
                    ans.add(curr);
                }
            }
            for(int i=0; i<word.length(); i++){
                for(char j='a'; j<='z'; j++){
                    char ch[] = word.toCharArray();
                    if (ch[i] == j) continue;
                    ch[i]=j;
                    String s= new String(ch);
                    if(st.contains(s)){
                        curr.add(s);
                        ArrayList<String> temp = new ArrayList<>(curr);
                        q.offer(temp);
                        usedWords.add(word);
                        curr.remove(curr.size()-1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList = new ArrayList<>();
        wordList.add("des");
        wordList.add("der");
        wordList.add("dfr");
        wordList.add("dgt");
        wordList.add("dfs");

        List<List<String>> ans = findLadders(startWord, targetWord, wordList);
        System.out.print(ans);
    }
}