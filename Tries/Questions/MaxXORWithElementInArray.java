import java.util.*;
class Solution {
    public static class Node{
        Node children[] = new Node[2];
        public Node(){
            for(int i=0; i<2; i++){
                children[i]=  null;
            }
        }
    }

    //Time Complexity: O(N* logN + Q* log Q + 32N + 32Q)
    public static void insert(Node root, int num) {
        Node curr= root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i) &1;
            if(curr.children[bit]==null)
                curr.children[bit] = new Node();
            curr = curr.children[bit];

        }
    }
    public static int findMax(Node root, int num) {
        if (root.children[0] == null && root.children[1] == null) return -1;
        int max=0;
        Node curr= root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i) &1;
            if(curr.children[1-bit]!=null){
                max|= (1<<i);
                curr = curr.children[1-bit];
            }else{
                curr = curr.children[bit];
            }

        }
        return max;
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int q [][] = new int[queries.length][3];
        for(int i=0; i<queries.length; i++){
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(q, Comparator.comparing(o-> (int)o[1]));

        Node root = new Node();
        int index=0;
        int ans[] = new int[queries.length];
        for(int i=0; i<q.length; i++){
            while(index<nums.length && nums[index]<=q[i][1]){
                insert(root, nums[index]);
                index++;
            }
            ans[q[i][2]] = findMax(root, q[i][0]);
        }
        return ans;
    }

    public static void main(String args[]){
        Node root= new Node();
        int nums[] = {0, 1, 2, 3, 4, 5};
        int queries[][]={{3,1}, {4, 5}, {2, 4}};
        for(int i: maximizeXor(nums, queries)){
            System.out.println(i);
        }

    }
}