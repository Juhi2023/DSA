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

    public static int search(int target){
        int index=0;
        Node temp = head;
        while(temp !=null){
            if(temp.data==target){
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public static int searchUsingRecursion(Node temp, int target){
        if(temp==null)
            return -1;
        if(temp.data==target)
            return 0;
        int index = searchUsingRecursion(temp.next, target);
        if(index==-1)
            return -1;

        return index+1;

    }

    public static void main(String args[]){        

        LinkedList ll = new LinkedList();
        
        ll.addElementAtStart(50);
        ll.addElementAtStart(60);
        ll.addElementAtStart(100);
        ll.addElementAtStart(30);
        System.out.println(searchUsingRecursion(ll.head, 50));
    }
}