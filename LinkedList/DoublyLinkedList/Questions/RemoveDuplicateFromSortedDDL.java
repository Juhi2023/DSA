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


    public static Node removeDuplicate(Node head){
        if(head==null)
            return null;
        Node temp=head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next = temp.next.next;
                if(temp.next!=null)
                    temp.next.prev = temp;
            }else{
                temp=temp.next;
            }
            
        }
        return head;
    }

    public static void main(String args[]){        
        Node head = new Node(1);
        head.next = new Node(2, null, head);
        head.next.next = new Node(3, null, head.next);
        head.next.next.next = new Node(3, null, head.next.next);
        addAtTail(head, 5);
        addAtTail(head, 5);
        print(head);
        head = removeDuplicate(head);
        print(head);
    }
}