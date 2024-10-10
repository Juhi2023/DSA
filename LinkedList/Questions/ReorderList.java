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

    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static void reorderList(){
        //find mid element
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //revere 2nd half list
        Node temp=null;
        Node curr=slow.next;
        slow.next=null;
        Node prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        Node nextL, nextR;
        Node left=head;
        Node right=prev;
        while(left!=null && right!=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next= nextL;

            left=nextL;
            right=nextR;
        }
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
        ll.addElementAtStart(5);
        ll.addElementAtStart(4);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        print();
        reorderList();
        print();
    }
}