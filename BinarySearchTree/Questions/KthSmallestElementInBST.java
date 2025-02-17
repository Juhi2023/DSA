
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  
    //Using sorting :  add all element in array and sort
    //Time Complexity: O(n + nlogn)
    //Space Complexity: O(n)
    

    //Using Inorder traversal 
    //Time Complexity: O(n)
    //Space Complexity: O(n+n)

    //using moris inorder
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int kthSmallestByMorris(Node root, int k) {
        Node curr=root; 
        int cnt=0;

        while(curr!=null){
            if(curr.left==null){
                cnt++;
                if(cnt==k){
                    return curr.data;
                }
                curr=curr.right;
            }else{
                Node temp = curr.left;
                while(temp.right!=null && temp.right!=curr)
                    temp=temp.right;
                
                if(temp.right==null){
                    temp.right = curr;
                    curr=curr.left;
                }else{
                    cnt++;
                    if(cnt==k){
                        return curr.data;
                    }
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(kthSmallestByMorris(root, 3));
    }
}