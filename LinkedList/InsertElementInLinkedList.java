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

    public static int get(int index) {
        if(index>=size){
            return -1;
        }

        Node temp = head;
        while(index>0){
            temp=temp.next;
            index--;
        }
        if(temp==null)
            return -1;

        return temp.data;
    }
    
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
    
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail= newNode;
            return;
        }
        tail.next= newNode;
        tail=newNode;
    }
    
    public void addAtIndex(int data, int index) {
        if(index > size)
    		return;

        Node newNode = new Node(data);
        size++;
        if(index==0){
            if(head==null){
                head = tail = newNode;
                return;
            }
                
            newNode.next = head;
            head = newNode;
            return;
        }

        if(index+1 == size){
            tail=newNode;
        }

        Node temp = head;
        while(temp !=null && index-1>0){
            temp = temp.next;
            index--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
        ll.addAtTail(60);
        ll.addAtIndex(100, 0);
        ll.addAtIndex(30, 3);
        ll.print();
        System.out.println("Size: " + ll.size);
    }
}