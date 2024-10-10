import java.util.*;
class IntersectionOfTwoLinkedLists{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    //Time Complexity: O(m*n)
    //SpaceComplexity: O(1)
    public static int getIntersectedNodeByBruteForce(Node head1, Node head2){
        while(head2 != null) {
        Node temp = head1;
            while(temp != null) {
                if(temp == head2) 
                    return head2.data;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return -1;
    }

    //Time Complexity: O(m+n)
    //SpaceComplexity: O(m+n)
    public static int getIntersectedNodeByHashing(Node head1, Node head2){
        HashSet<Node> set=new HashSet<>();
        Node temp=head1;
        while(temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp=head2;
        while(temp != null) {
            if(set.contains(temp)){
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    //Time Complexity: O(m+n) + O(abs(m-n)) + O(min(m,n))
    //SpaceComplexity: O(1)
    public static int getIntersectedNodeByLengthDifference(Node head1, Node head2){
        int len1 = 0, len2 = 0;
        Node temp1=head1, temp2=head2;
        while(temp1 != null || temp2 != null) {
            if(temp1 != null) {
                ++len1; 
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                ++len2; 
                temp2 = temp2.next;
            }
        }
        temp1=head1;
        temp2=head2;
        int diff = len1-len2;
        if(diff < 0) 
            while(diff++ != 0) 
                temp2 = temp2.next; 
        else
            while(diff-- != 0) 
                temp1 = temp1.next;

        while(temp1 != null) {
            if(temp1 == temp2) 
                return temp1.data;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return temp1==null ? -1 : temp1.data;
    }

    //Time Complexity: O(m+n) 
    //SpaceComplexity: O(1)
    public static int getIntersectedNodeByMoreOptimization(Node head1, Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;

        if (ptr1 == null || ptr2 == null)
            return -1;

        while (ptr1 != ptr2) {
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }

        return ptr1==null ? -1 : ptr1.data;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){        
        Node head1 = new Node(3);
        head1.next = new Node(4);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        print(head1);

        Node head2 = new Node(5);
        head2.next = new Node(0);
        head2.next.next = new Node(1);
        head2.next.next.next = head1.next;
        head2.next.next.next.next = new Node(7);
        print(head2);

        System.out.println(getIntersectedNodeByMoreOptimization(head1, head2));
    }
}