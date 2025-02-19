class Trie {
    public static class Node{
        Node children[] = new Node[2];
        public Node(){
            for(int i=0; i<2; i++){
                children[i]=  null;
            }
        }
    }

    //Time Complexity: O(32*N + 32*M)
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
    public static int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int i: nums)
            insert(root, i);
        int maxXOR=0;
        for(int i: nums)
            maxXOR = Math.max(maxXOR, findMax(root, i));
        return maxXOR;
    }

    public static void main(String args[]){
        Node root= new Node();
        int nums[] = {9, 8, 7, 3, 5, 2};
        System.out.println(findMaximumXOR(nums));

    }
}