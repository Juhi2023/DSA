import java.util.*;

class Trie{
    public static class  Node{
        Node children[] = new Node[26];
        int cntEndWith;
        int cntPrefix;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            cntEndWith=0;
            cntPrefix=0;
        }

        void increaseEnd() {
            cntEndWith++;
        }

        void increasePrefix() {
            cntPrefix++;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        void reducePrefix() {
            cntPrefix--;
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
            curr.increasePrefix();
        }
        curr.increaseEnd();
    }

    public static int countWordsEqualTo(Node root, String word) {
        Node curr=root;
        for(int i=0; i< word.length(); i++){
            int index= word.charAt(i)-'a';
            if(curr.children[index]!=null)
                curr = curr.children[index];
            else   
                return 0;
        }
        return curr.cntEndWith;
    }

    public static int countWordsStartingWith(Node root, String word) {
        Node curr=root;
        for(int i=0; i< word.length(); i++){
            int index= word.charAt(i)-'a';
            if(curr.children[index]!=null)
                curr = curr.children[index];
            else   
                return 0;
        }
        return curr.cntPrefix;
    }

    public static void erase(Node root, String word) {
        Node curr=root;
        for(int i=0; i< word.length(); i++){
            int index= word.charAt(i)-'a';
            if(curr.children[index]!=null){
                curr = curr.children[index];
                curr.reducePrefix();
            }
            else   
                return;
        }
        curr.deleteEnd();
    }

    public static void main(String args[]){
        Node root= new Node();
        String str[] = {"add", "addition", "add", "there", "do"};
        for(String s: str){
            insert(root, s);
        }
        System.out.println(countWordsEqualTo(root, "add"));
        System.out.println(countWordsStartingWith(root, "add"));
        erase(root, "add");
        System.out.println(countWordsEqualTo(root, "add"));
    }
}