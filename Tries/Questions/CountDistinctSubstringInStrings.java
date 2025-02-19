import java.util.*;

class Trie{
    public static class  Node{
        Node children[] = new Node[26];
        int ewo;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            ewo=0;
        }
    }

    //Brute Force: Using hashset
    //Time Complexity: O(n²)
    //Space Complexity: O(n²)

    //Using Trie
    //Time Complexity: O(n²)
    //Space Complexity: O(n²)

    public static int countDistinctSubstringInStrings(Node root, String word){
        int n=word.length();
        int cnt=0;
        Node curr;

        for(int i=0; i<n; i++){
            curr=root;
            for(int j=i; j<n; j++){
                int index = word.charAt(j)-'a';
                if(curr.children[index]==null){
                    curr.children[index]=new Node();
                    cnt++;
                }
                curr=curr.children[index];                
            }
        }
        return cnt+1; // Added 1 for empty string
    }

    public static void main(String args[]){
        Node root= new Node();
        System.out.println(countDistinctSubstringInStrings(root, "abab"));

    }
}