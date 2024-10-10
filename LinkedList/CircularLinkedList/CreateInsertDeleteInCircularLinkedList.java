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

    public static void print(Node last){
        Node next = last.next;
        last.next=null;
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
        last.next=next;
    }

    public static Node insertAtStart(Node HEAD, Node last, int data){
        Node newNode = new Node(data);
        newNode.next= HEAD;
        last.next = newNode;
        HEAD =newNode;
        return newNode;
    }

    public static Node insertAtEnd(Node last, int data){
        Node next = last.next;
        Node newNode = new Node(data);
        last.next= newNode;
        newNode.next= next;
        return newNode;
    }

    public static Node insertAtIndex(Node last, int data, int pos){
        Node newNode = new Node(data);
        if(last==null){
            newNode.next = newNode;
            return newNode;
        }
        if(pos==0){
            last = insertAtStart(last.next, last, data);
        }

        Node temp = last.next;
        while(pos>1){
            temp=temp.next;
            pos--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if(temp == last){
            last = newNode;
        }
        return last;
    }

    public static Node deleteAtStart(Node last){
        if(last==null || last.next==last){
            return null;
        }
        Node next = last.next;
        last.next=last.next.next;
        next.next=null;
        return last.next;
    }

    public static Node deleteAtEnd(Node last){
        if(last==null || last.next==last){
            return null;
        }
        Node prev = null;
        Node temp = last.next;
        while(temp.next!=last){
            temp=temp.next;
        }
        prev=temp;
        prev.next= prev.next.next;
        return prev;
    }



    public static void main(String args[]){        

        LinkedList ll = new LinkedList();
        ll.head = new Node(5);
        ll.head.next = new Node(3);
        ll.head.next.next = new Node(1);
        ll.head.next.next.next = head;
        Node last = ll.head.next.next;
        print(last);
        ll.head = insertAtStart(ll.head, last, 6);
        print(last);
        last = insertAtEnd(last, 7);
        print(last);
        last = insertAtIndex(last, 9, 5);
        print(last);
        ll.head = deleteAtStart(last);
        print(last);
        last = deleteAtEnd(last);
        print(last);
    }
}