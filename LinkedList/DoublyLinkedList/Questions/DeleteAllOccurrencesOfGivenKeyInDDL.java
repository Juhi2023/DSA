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


    public static Node deleteAllOccurance(Node head, int x){
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(head==temp){
                    head=head.next;
                }else{
                    if(temp.prev !=null)
                        temp.prev.next = temp.next;
                    if(temp.next !=null)
                        temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String args[]){        
        Node head = new Node(1);
        head.next = new Node(1, null, head);
        head.next.next = new Node(3, null, head.next);
        head.next.next.next = new Node(1, null, head.next.next);
        addAtTail(head, 4);
        addAtTail(head, 5);
        addAtTail(head, 1);
        print(head);
        head = deleteAllOccurance(head, 1);
        print(head);
    }
}