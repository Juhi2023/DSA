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

    public static Node reverseUsingIterative(Node HEAD){
        Node prev = null;
        Node curr = tail = HEAD;
        Node temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next= prev;
            prev=curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

    public static Node reverseUsingRecursive(Node HEAD){
        if(HEAD==null || HEAD.next==null)
            return HEAD;
        
        Node newHead = reverseUsingRecursive(HEAD.next);
        HEAD.next.next = HEAD;
        HEAD.next=null;

        head= newHead;
        return newHead;
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
        reverseUsingRecursive(ll.head);
        print();
    }
}