import java.util.*;

class WordLadder {
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
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Push all values of wordList into a set to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet < String > ();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        Queue < Pair > q = new LinkedList < > ();
        q.add(new Pair(startWord, 1));

        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
      
            if (word.equals(targetWord) == true) 
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };

        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
    }
}