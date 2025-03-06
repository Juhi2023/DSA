//similar to break words
import java.util.*;

class Program 
{

//Time Complexity: O(no. of good keywords * length of review *no of reviews)

public static class TrieNode {
	public boolean eow;
	public TrieNode[] arr;

	public TrieNode() {
        eow = false;
        arr = new TrieNode[26];
	}

	public TrieNode(boolean bul) {
        eow = bul;
        arr = new TrieNode[26];
	}
}


public static void add(String s, TrieNode trie) {
	int n = s.length();
	for (int i = 0; i < n; i++) {
        int index = s.charAt(i) - 'a';

        if (trie.arr[index] == null) {
            trie.arr[index] = new TrieNode();
        }
        trie = trie.arr[index];
	}
	trie.eow = true;
}


public static boolean search(String s, TrieNode trie) {

	for (int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        if (trie.arr[index] == null) {
            return false;
        }
        trie = trie.arr[index];
	}
	return trie.eow;
}

public static void convert(StringBuilder str) {
	for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '_') {
            str.setCharAt(i, ' ');
        }
	}
}


public static void sortArr(String good, List<String> review) {
	StringBuilder goodBuilder = new StringBuilder(good);
	convert(goodBuilder);
	TrieNode trie = new TrieNode();
	String[] words = goodBuilder.toString().split(" ");

	for (String word : words) {
                add(word, trie);
	}
	int n = review.size();

	int rating[][]= new int[review.size()][2];
	for (int i = 0; i < n; i++) {
        StringBuilder reviewBuilder = new StringBuilder(review.get(i));
        convert(reviewBuilder);
        words = reviewBuilder.toString().split(" ");
        int k = 0;
        for (String word : words) {
            if (search(word, trie)) {
                k++;
            }
        }
        rating[i][0]=i;        
        rating[i][1]=k;
	}

	Arrays.sort(rating, Comparator.comparing(o-> (int)(-o[1])));

	for (int j[] : rating) {
	    System.out.println(review.get(j[0]));
	}
}

public static void main(String[] args) {
        String good = "geeks_for_geeks_is_great";
        List<String> review = Arrays.asList("geeks_are_geeks", "geeks_dont_lose", "geeks_for_geeks_is_love");
        sortArr(good, review);
    }
}
