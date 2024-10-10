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

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head= tail = newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }

    public static void deleteAtIndex(int index) {
        if(index>=size)
            return;
        size--;
        //deleting head node
        if(index==0){
            head = head.next;
            return;
        }
        Node temp = head;
        while(index>1){
            temp = temp.next;
            index--;
        }

        //deleteing tail node
        if (temp.next == tail) { 
            tail = temp;
        }
        temp.next = temp.next.next;
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
        

        ll.addAtHead(50);
        ll.addAtHead(60);
        ll.addAtHead(100);
        ll.addAtHead(30);
        ll.deleteAtIndex(2);
        ll.print();
    }
}