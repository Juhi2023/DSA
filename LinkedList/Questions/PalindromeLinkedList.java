class LinkedList{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size=0;

    public static void addElementAtStart(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail= newNode;
            return;
        }
            
        newNode.next = head;
        head = newNode;
    }

    //Brute Force using stack
    //Time Complexity: O(2N)
    //SpaceComplexity: O(N)
    

    //Time Complexity: O(n/2 + n/2 + n/2)
    //SpaceComplexity: O(1)
    public static boolean isPalindrome(Node HEAD){
        if(HEAD==null || HEAD.next==null)
            return true;
        //Step 1: find mid
        Node slow =HEAD;
        Node fast = HEAD;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        //Step 2: reverse 2nd half
        Node temp = null;
        Node curr=slow;
        Node prev=null;
        while(curr!=null){
            temp = curr.next;
            curr.next= prev;
            prev=curr;
            curr=temp;
        }

        //Step 3: Compare
        Node left = HEAD;
        Node right = prev;
        while(right !=null){
            if(left.data!=right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void print(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){        

        LinkedList ll = new LinkedList();
        
        ll.addElementAtStart(1);
        ll.addElementAtStart(2);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        print();
        System.out.println(isPalindrome(ll.head));
    }
}