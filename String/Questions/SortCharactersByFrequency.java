import java.util.*;
class SortCharactersByFrequency{
    //Brute
    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public static String sortByfreq(String s){
        int n=s.length();
        int freq[] = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        char[] chars = new char[128];
        for (int i = 0; i < 128; i++) {
            chars[i] = (char) i;
        }

        for (int i = 0; i < 128; i++) {
            for (int j = i + 1; j < 128; j++) {
                if (freq[chars[j]] > freq[chars[i]]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int count = freq[chars[i]];
            for (int j = 0; j < count; j++) {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

    //HashMap
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static String sortByfreqHash(String s){
         int n=s.length();
        char arr[] = s.toCharArray();
        HashMap<Character, Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        ArrayList<int[]> vec=new ArrayList<>();
        for (char x:map.keySet()){
            vec.add(new int[]{x,map.get(x)});
        }
        Collections.sort(vec,(a,b)-> b[1]-a[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vec.size(); i++){
            while (vec.get(i)[1] > 0){
                sb.append((char)vec.get(i)[0]);
                vec.get(i)[1]--;
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String s = "tree";
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

    }
}