import java.util.*;

public class GroupAnagrams{
    //Brute force  // same complexity using trie
    //Time Complexity: O(n * l * log l)

    public static List<List<String>> groupAnagram1(String [] arr){
        HashMap<String, List<String>> visit = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            char a[] = arr[i].toCharArray();
            Arrays.sort(a);
            String newStr = new String(a);
            if(!visit.containsKey(newStr)){
                visit.put(newStr, new ArrayList<>());
            }
            visit.get(newStr).add(arr[i]);
        }
        return new ArrayList<>(visit.values());
    }


    //Time Complexity: O(n * l)
    public static List<List<String>> groupAnagram2(String strs[]) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            // Count frequency of each letter in the string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());        
    }

    public static void main (String args[]){
        String [] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram2(s));
    }
}