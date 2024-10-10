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

    //Time Complexity: O(n) + O(n/2)
    //SpaceComplexity: O(1)
    public static int getMiddleNodeUsingBruteForce(Node HEAD){
        Node temp =HEAD;
        int cnt=0;
        while(temp !=null){
            temp=temp.next;
            cnt++;
        }
        cnt/=2;
        temp=HEAD;
        while(cnt>0){
            temp=temp.next;
            cnt--;
        }
        return temp.data;
    }

    //Time Complexity: O(n/2)
    //SpaceComplexity: O(1)
    public static int getMiddleNodeUsingSlowFastPointer(Node HEAD){
         Node slow =HEAD;
        Node fast = HEAD;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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
        
        ll.addElementAtStart(50);
        ll.addElementAtStart(60);
        ll.addElementAtStart(100);
        ll.addElementAtStart(30);
        print();
        System.out.println(getMiddleNodeUsingBruteForce(ll.head));
    }
}