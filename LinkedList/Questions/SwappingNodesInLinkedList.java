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

    //By swapping Node
    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static Node swapNodes(Node HEAD, int x, int y){
        Node pt1 = head;
        Node pt2 = head;
        Node prev1 = null;
        Node prev2 = null;
        int cnt=1;
        while(cnt<x){
            prev1=pt1;
            pt1=pt1.next;
            cnt++;
        }
        cnt=1;
        Node temp = head;
        while(cnt<y){
            temp=temp.next;
            cnt++;
        }
        
        while(temp.next!=null){
            prev2=pt2;
            temp=temp.next;
            pt2=pt2.next;
        }

        if(prev1==null)
            head=pt2;
        else
            prev1.next= pt2;

        if(prev2==null)
            head=pt1;
        else
            prev2.next= pt1;

        
        temp = pt1.next;
        pt1.next = pt2.next;
        pt2.next=temp;

        return head;
    }

    //By swapping data
    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static Node swapValueOfNodes(Node HEAD, int x, int y){
        Node pt1 = head;
        Node pt2 = head;
        int cnt=1;
        while(cnt<x){
            pt1=pt1.next;
            cnt++;
        }
        cnt=1;
        Node temp = head;
        while(cnt<y){
            temp=temp.next;
            cnt++;
        }
        
        while(temp.next!=null){
            temp=temp.next;
            pt2=pt2.next;
        }


        int data = pt1.data;
        pt1.data = pt2.data;
        pt2.data=data;

        return head;
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
        
        ll.addElementAtStart(1);
        ll.addElementAtStart(2);
        ll.addElementAtStart(3);
        ll.addElementAtStart(4);
        ll.addElementAtStart(5);
        print();
        head = swapNodes(ll.head, 2, 3);
        print();
    }
}