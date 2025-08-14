//https://leetcode.com/problems/find-unique-binary-string/description

class Solution {

    //Brute Force
    //Time Complexity: O(N^2)
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }
                
                return ans;
            }
        }
        
        return "";
    }

    //For each indexi, we will check the i th character of the i th string innums. That is, we checkcurr = nums[i][i]. We then assignans[i]to the opposite ofcurr. That is, ifcurr = "0", we assignans[i] = "1". Ifcurr = "1", we assignans[i] = "0".
    //Time Complexity: O(N)
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
}