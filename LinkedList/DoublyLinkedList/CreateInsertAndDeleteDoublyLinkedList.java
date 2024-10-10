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

    public static Node addAtHead(Node head, int data){
        Node newNode= new Node(data, head, null);
        head.prev=newNode;
        return newNode;
    }

    public static void addAtTail(Node head, int data){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode= new Node(data, null, temp);
        temp.next = newNode;
    }

    public static Node addAtIndex(Node head, int data, int index){
        if(index==0){
            return addAtHead(head, data);
        }
        Node temp=head;
        while(index>1){
            temp=temp.next;
            index--;
        }
        Node newNode= new Node(data, temp.next, temp);
        temp.next = newNode;
        return head;
    }

    public static Node deleteAtHead(Node head){
        Node temp =head.next;
        head.next=null;
        return temp;
    }

    public static void deleteAtTail(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        temp.prev = null;
    }

    public static void main(String args[]){        

        Node head = new Node(5);
        head.next = new Node(3, null, head);
        head.next.next = new Node(4, null, head.next);
        head=addAtHead(head, 2);
        addAtTail(head, 60);
        print(head);
        head=deleteAtHead(head);
        deleteAtTail(head);
        addAtIndex(head, 30, 2);
        print(head);
    }
}