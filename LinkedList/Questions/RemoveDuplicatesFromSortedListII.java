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
    public static Node removeDuplicatesFromSortedListII(Node HEAD){
        if(HEAD==null || HEAD.next==null)
            return HEAD;

        Node dummy = new Node(0);
        dummy.next=HEAD;
        Node newHead = dummy;
        Node curr = HEAD;
        while(curr!=null){
            Node start = curr;
            while(curr.next!=null && start.data==curr.next.data){
                curr = curr.next;
            }

            if(start!=curr){
                dummy.next=curr.next;
            }else
                dummy=dummy.next;
            curr=curr.next;
        }
        return newHead.next;
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
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        ll.addElementAtStart(1);
        ll.addElementAtStart(1);
        ll.head = removeDuplicatesFromSortedListII(ll.head);
        print();
        
    }
}