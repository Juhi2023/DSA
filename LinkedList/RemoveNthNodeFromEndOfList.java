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

    //Time Complexity: O(L) + O(L-n)
    //SpaceComplexity: O(1)
    public static Node removeNthNodeUsingBruteForce(Node HEAD, int n){
        int cnt=0;
        Node temp = HEAD;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        if(cnt==n){
            return HEAD.next;
        }

        int s = cnt-n;
        temp = HEAD;
        while(temp!=null && s>1){
            temp=temp.next;
            s--;
        }
        temp.next = temp.next.next;
        return HEAD;
    }

    //Time Complexity: O(L)
    //SpaceComplexity: O(1)
    public static Node removeNthNodeUsingSlowFastPointer(Node HEAD, int n){
        Node fast = HEAD;
        Node slow = HEAD;
        while(n>0){
            n--;
            fast=fast.next;
        }

        if(fast==null){
            return HEAD.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return HEAD;
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
        removeNthNodeUsingSlowFastPointer(ll.head, 3);
        print();
    }
}