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

    //Time Complexity: O(n *k)
    //SpaceComplexity: O(1)
    public static Node rotateListByBruteForce(Node HEAD, int k){
        if (HEAD == null || HEAD.next == null) return HEAD;
        for (int i = 0; i < k; i++) {
            Node temp = HEAD;
            while (temp.next.next != null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = HEAD;
            HEAD = end;
        }
        return HEAD;

    }


    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static Node rotateListBySlowAndFast(Node HEAD, int k){
        if (HEAD == null || HEAD.next == null || k == 0) {
            return HEAD;
        }
        Node slow = HEAD;
        Node fast= HEAD;
        while(k>0){
            if(fast.next==null)
                fast=HEAD;
            else
                fast=fast.next;
            k--;
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        fast.next=HEAD;
        Node temp = slow.next;
        slow.next=null;
        return temp;
    }

    //Time Complexity: O(n)+ O(n - (n%k))
    //SpaceComplexity: O(1)
    public static Node rotateListByLength(Node HEAD, int k){
        if (HEAD == null || HEAD.next == null || k == 0) {
            return HEAD;
        }
        int len=1;

        Node temp = HEAD;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        k=k%len;
        int diff = len-k;
        temp.next=HEAD;   //made ll circular

        while(diff>0){
            diff--;
            temp=temp.next;
        }

        HEAD=temp.next;
        temp.next=null;
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
        
        ll.addElementAtStart(5);
        ll.addElementAtStart(4);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        print();
        head = rotateListByLength(ll.head, 2);
        print();
    }
}