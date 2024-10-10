class DoublyLinkedList{
    public static int size=0;
    public static class  Node{
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<-->");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void addAtTail(Node head, int data){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode= new Node(data, null, temp);
        temp.next = newNode;
    }

    public static Node reverseUsingIteration(Node head){
        Node prev=null;
        Node curr=head;
        Node temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            curr.prev=temp;
            prev=curr;
            curr = temp;
        }
        head=prev;
        return head;
    }

    public static Node reverseUsingRecursion(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        
        Node newHead = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        
        return newHead;

        // if(head==null)
        //     return head;
        
        // Node temp= head.next;
        // head.next = head.prev;
        // head.prev=temp;

        // if(head.prev == null)
        //     return head;
        // return reverseUsingRecursion(head.prev);
    }

    public static void main(String args[]){        

        Node head = new Node(1);
        head.next = new Node(2, null, head);
        head.next.next = new Node(3, null, head.next);
        addAtTail(head, 4);
        addAtTail(head, 5);
        addAtTail(head, 6);
        print(head);
        head = reverseUsingRecursion(head);
        print(head);
    }
}