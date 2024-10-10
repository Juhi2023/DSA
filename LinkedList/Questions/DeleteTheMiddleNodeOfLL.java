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

    //Time Complexity: O(n/2)
    //SpaceComplexity: O(1)
    public static Node deleteMiddleNode(Node HEAD){
        if(HEAD.next==null)
            return null;
        Node slow =HEAD;
        Node fast = HEAD.next.next;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        slow.next=slow.next.next;
        return HEAD;
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
        
        ll.addElementAtStart(50);
        ll.addElementAtStart(60);
        ll.addElementAtStart(100);
        ll.addElementAtStart(30);
        print();
        deleteMiddleNode(ll.head);
        print();
    }
}