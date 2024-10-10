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
    public static Node sort(Node HEAD){
        Node zeros = new Node(-1);
        Node ones = new Node(-1);
        Node twos = new Node(-1);
        Node zerosHead = zeros;
        Node onesHead = ones;
        Node twosHead = twos;
        Node temp = HEAD;
        while(temp!=null){
            Node curr = temp;
            temp=temp.next;
            curr.next=null;
            
            if(curr.data==0){
                zeros.next=curr;
                zeros=curr;
            }else if(curr.data==1){
                ones.next=curr;
                ones=curr;
            }else{
                twos.next=curr;
                twos=curr;
            }
        }
        zeros.next=onesHead.next ==null ? twosHead.next: onesHead.next;
        ones.next=twosHead.next;
        return zerosHead.next;
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
        ll.addElementAtStart(0);
        ll.addElementAtStart(1);
        print();
        head = sort(ll.head);
        print();
    }
}