// n = number of products
// m = length of searchWord
// L = average product length

//Brute
//TIme Complexity: O(n log n + m × n × L)
//Space Complexty: O(N)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;

            List<String> temp = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    temp.add(product);
                    if (temp.size() == 3) break;  // only need top 3
                }
            }

            result.add(temp);
        }

        return result;
    }
}



//Heap
//TIme Complexity: O(m × n × log 3)
//Space Complexty: O(N)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;

            PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    maxHeap.offer(product);
                    if (maxHeap.size() > 3) {
                        maxHeap.poll(); // remove lexicographically largest
                    }
                }
            }

            List<String> suggestions = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                suggestions.add(maxHeap.poll());
            }
            Collections.reverse(suggestions);
            result.add(suggestions);
        }

        return result;
    }
}



//Trie
//TIme Complexity: O(n* log n + n*l)
//Space Complexty: O(N)
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
            // Add to suggestions if less than 3
            if (curr.suggestions.size() < 3) {
                curr.suggestions.add(word);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);  // sort products lexicographically

        TrieNode root = new TrieNode();

        // Build Trie with suggestion list
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;

        for (char c : searchWord.toCharArray()) {
            int i = c - 'a';
            if (curr != null) {
                curr = curr.children[i];
            }

            if (curr != null) {
                result.add(curr.suggestions);
            } else {
                result.add(new ArrayList<>()); // no suggestions
            }
        }

        return result;
    }
}


//Binary Search
//TIme Complexity: O(n* log n + m*log n)
//Space Complexty: O(N)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       Arrays.sort(products);
       List<List<String>> result = new ArrayList<>();
       int left = 0;
       int right = products.length-1;
       StringBuilder searchInput = new StringBuilder();
       for(char searchChar : searchWord.toCharArray()){
            searchInput.append(searchChar);
            String currentPrefix = searchInput.toString();
            while(left <= right && !products[left].startsWith(currentPrefix)){
                left++;
            }
            while(left <= right && !products[right].startsWith(currentPrefix)){
                right--;
            }

            List<String> suggestedList = new ArrayList<>();
            for(int i = left; i <= right &&  suggestedList.size() < 3; i++){
                suggestedList.add(products[i]);
            }
            result.add(suggestedList);
       }
       return result;
    }
}