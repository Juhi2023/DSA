import java.util.*;

class Trie{
    public static class  Node{
        Node children[] = new Node[26];
        int freq;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq=0;
        }
    }

    //Brute Force
    //Time Complexity: O(n² * m)
    //Space Complexity: O(1)

    //Time Complexity: O(n * L)
    //Space Complexity: O(n * L)
    public static void insert(Node root, String str){
        Node curr=root;
        for(int i=0; i< str.length(); i++){
            int index= str.charAt(i)-'a';
            if(curr.children[index]==null)
                curr.children[index] = new Node();
            curr.children[index].freq++;
            curr = curr.children[index];
        }
    }

    public static List<String> getUniquePrefix(Node root, String words[]){
        List<String> ans = new ArrayList<>();
        for(int i=0; i< words.length; i++){
            Node curr=root;
            StringBuilder prefix = new StringBuilder();
        
            for (char c : words[i].toCharArray()) {
                prefix.append(c);
                curr = curr.children[c-'a'];
                if (curr.freq == 1) {
                    ans.add(prefix.toString());
                    break;
                }
            }
        }
        return ans;
    }

    

    public static void main(String args[]){
        Node root= new Node();
        String str[] = {"addy", "addition", "addiction", "there", "do"};
        for(String s: str){
            insert(root, s);
        }
        System.out.println(getUniquePrefix(root, str));

    }
}