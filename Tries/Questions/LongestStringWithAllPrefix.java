//https://leetcode.com/problems/longest-word-in-dictionary/

import java.util.*;

class Trie{
    public static class  Node{
        Node children[] = new Node[26];
        boolean eow;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            eow=false;
        }
    }

    public static void insert(Node root, String str){
        Node curr=root;
        for(int i=0; i< str.length(); i++){
            int index= str.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }

    // Time Complexity: O(N * M)
    // Space Space: O(26 * N * M)
    
    public static String longestStringWithAllPrefix(Node root, String words []){
        int n=words.length;
        String longest="";
        Node curr = root;
        for(int i=0; i<n; i++){
            curr=root;
            boolean flag=true;
            for(char c : words[i].toCharArray()){
                if(curr.children[c-'a'] ==null){
                    flag=false;
                    break;
                }                    
                curr = curr.children[c-'a'];
                flag = flag & curr.eow;                    //***************** IMP step
            }
            
            if(flag && (words[i].length() > longest.length() || (words[i].length() == longest.length() && words[i].compareTo(longest)<0))){
                longest = words[i];
            }
        }

        return longest;
    }
    

    //other way for lexographically
    // public static String longestStringWithAllPrefix(Node root, String pre){

    //     if (root == null) {
    //         return pre;
    //     }
    //     String longest = pre;
    //     for (int i = 0; i < 26; i++) {
    //         if (root.children[i] != null && root.children[i].eow == true) {

    //             String s = pre + (char)(i + 'a');
    //             String curr = longestStringWithAllPrefix(root.children[i], s);
    //             if (curr.length() > longest.length()) {
    //                 longest = curr;
    //             }
    //         }
    //     } 
    //     return longest;
    // }

    public static void main(String args[]){
        Node root = new Node();
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for (String s : words) {
            insert(root, s);
        }
        System.out.println(longestStringWithAllPrefix(root, words));

    }
}