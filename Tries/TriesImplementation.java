import java.util.*;

class Trie{
    public static class  Node{
        Node children[] = new Node[26];
        boolean endOfWord=false;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    //Time Complexity: O(L)
    //Space ime Complexity: O(L)
    public static void insert(Node root, String str){
        Node curr=root;
        for(int i=0; i< str.length(); i++){
            int index= str.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    //Time Complexity: O(L)
     public static boolean search(Node root, String word) {
        Node curr=root;
        for(int i=0; i< word.length(); i++){
            int index= word.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return curr.endOfWord == true;
    }

    //Time Complexity: O(Length of prefix)
    public static boolean prefix(Node root, String prefix) {
        Node curr=root;
        for(int i=0; i< prefix.length(); i++){
            int index= prefix.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String args[]){
        Node root= new Node();
        String str[] = {"add", "addition", "addiction", "there", "do"};
        for(String s: str){
            insert(root, s);
        }
        System.out.println(search(root, "do"));
        System.out.println(prefix(root, "add"));

    }
}