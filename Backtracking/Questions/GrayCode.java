import java.util.*; 
class GrayCode {
    //Time Complexity: O(2^n) (for all)

    public static List<Integer> grayCode1(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< 1<<n; i++){
            ans.add(i^(i>>1));
        }

        return ans;
    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        if (generateGrayCode(0, n, result, visited)) {
            return result;
        }
        return result;
    }

    private static boolean generateGrayCode(int num, int n, List<Integer> result, Set<Integer> visited) {
        if (result.size() == (1 << n)) return true;
        for (int i = 0; i < n; i++) {
            int next = num ^ (1 << i);

            if (!visited.contains(next)) {
                result.add(next);
                visited.add(next);

                if (generateGrayCode(next, n, result, visited)) return true;

                result.remove(result.size() - 1);
                visited.remove(next);
            }
        }
        return false;
    }




    public static ArrayList<String> grayBinaryCode1(int n){
    
        if (n <= 0){
            ArrayList<String> temp = new ArrayList<String>(){{add("0");}};
            return temp;
        }
        if(n == 1){
            ArrayList<String> temp =  new ArrayList<String>(){{add("0");add("1");}};
            return temp;
        }
    
        // Recursive case
        ArrayList<String> recAns = grayBinaryCode1(n - 1);
        ArrayList<String> mainAns = new ArrayList<String>();
    
        for(int i = 0; i < recAns.size(); i++){
            String s = recAns.get(i);
            mainAns.add("0" + s);
        }
    
        for(int i = recAns.size() - 1; i >= 0; i--){
            String s = recAns.get(i);
            mainAns.add("1" + s);
        }
        return mainAns;
    }

    public static ArrayList<String> grayBinaryCode2(int n){
    
        ArrayList<String> arr = new ArrayList<String> (); 
        if (n <= 0) 
            return arr; 
 
        arr.add("0"); 
        arr.add("1"); 
 
        for (int i = 2; i <=n; i++){ 
            int arrSize = arr.size();

            for (int j = arrSize-1 ; j >= 0 ; j--) 
                arr.add(arr.get(j)); 
    
            for (int j = 0 ; j < arrSize ; j++) 
                arr.set(j, "0" + arr.get(j)); 
    
            for (int j = arrSize ; j < 2*arrSize ; j++) 
                arr.set(j, "1" + arr.get(j)); 
        } 
        return arr;
    }

    
    public static void main(String args[]) {
        System.out.println(grayCode1(3));
        System.out.println(grayCode2(3));
        System.out.println(grayBinaryCode1(3));
        System.out.println(grayBinaryCode2(3));
    }
}