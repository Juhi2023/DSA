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

    public static void main(String args[]){        

        LinkedList ll = new LinkedList();
        ll.head = new Node(5);
        ll.head.next = new Node(3);
        ll.head.next.next = new Node(1);
        System.out.println(ll.head.data + "-->" + ll.head.next.data + "-->" + ll.head.next.next.data);
    }
}