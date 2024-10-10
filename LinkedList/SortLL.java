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


    private static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        print();
        
        Node mid=findMid(head);

        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static Node merge(Node head1, Node head2){
        Node temp = new Node(-1);
        Node dummyNode = temp;
        
        while(head1 !=null && head2 != null){
            if(head1.data >head2.data){
                temp.next = head2;
                head2=head2.next;
            }else{
                temp.next = head1;
                head1=head1.next;
            }
            temp=temp.next;
        }

        while(head1 !=null){
            temp.next = head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2 !=null){
            temp.next = head2;
            head2=head2.next;
            temp=temp.next;
        }

        return dummyNode.next;
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
        ll.addElementAtStart(0);
        ll.addElementAtStart(1);
        print();
        head = mergeSort(ll.head);
        print();
    }
}