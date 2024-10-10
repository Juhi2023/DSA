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

    public static int getLength(){
        int cnt=0;
        Node temp = head;
        while(temp !=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public static void main(String args[]){        

        LinkedList ll = new LinkedList();
        
        ll.addElementAtStart(50);
        ll.addElementAtStart(60);
        ll.addElementAtStart(100);
        ll.addElementAtStart(30);
        System.out.println("Size: " + getLength());
    }
}