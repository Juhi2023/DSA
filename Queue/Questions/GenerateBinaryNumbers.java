import java.util.*;

public class GenerateBinaryNumbers {

    //Brute Force
    //Time Cpmplexity: O(N log N)
    //Space Complexity: O(N)
    static ArrayList<String> generatePrintBinaryByBruteForce(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    str = "1" + str;
                } else {
                    str = "0" + str;
                }
                temp = temp >> 1;
            }
            ans.add(str);
        }
        return ans;
    }

    //By queue
    //Time Cpmplexity: O(N)
    //Space Complexity: O(N)
    static ArrayList<String> generatePrintBinary(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String front  = q.remove();
            ans.add(front);
            q.add(front+"0");
            q.add(front+"1");
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generatePrintBinary(5));
    }
}
