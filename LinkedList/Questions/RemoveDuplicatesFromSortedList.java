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

    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static void removeDuplicatesFromSortedList(){
        if(head==null || head.next==null)
            return;
        Node curr = head;
        while(curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next= curr.next.next;
            }else{
                curr=curr.next;
            }
            
        }
        
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
        
        ll.addElementAtStart(3);
        ll.addElementAtStart(3);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        ll.addElementAtStart(1);
        ll.addElementAtStart(1);
        removeDuplicatesFromSortedList();
        print();
        
    }
}