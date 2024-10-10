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
    public static Node segregateListAccordingToPosition(Node HEAD){
        if(HEAD==null || HEAD.next==null)
            return HEAD;

        Node odd = HEAD;
        Node even= HEAD.next;
        Node evenHead = even;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd= odd.next;
            even = even.next;
        }

        odd.next=evenHead;
        return HEAD;
        
        // Node temp = HEAD;
        // Node odd = new Node(-1);
        // Node even= new Node(-1);
        // Node oddHead = odd;
        // Node evenHead = even;
        // int count =1;
        // while(temp!=null){
        //     if(count%2==1){
        //         odd.next = temp;
        //         odd=odd.next;
        //     }else{
        //         even.next = temp;
        //         even=even.next;
        //     }
        //     temp=temp.next;
        //     count++;
        // }

        // odd.next=evenHead.next;
        // evenHead.next=null;
        // return oddHead.next;
    }

    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static Node segregateListAccordingToValue(Node HEAD){
        if(HEAD==null || HEAD.next==null)
            return HEAD;
        
        Node temp = HEAD;
        Node odd = new Node(-1);
        Node even= new Node(-1);
        Node oddHead = odd;
        Node evenHead = even;
        while(temp!=null){
            Node curr = temp;
            temp=temp.next;
            curr.next=null;

            if(curr.data%2==0){
                even.next= curr;
                even = curr;
            }else{
                odd.next= curr;
                odd = curr;
            }
        }

        odd.next=evenHead.next;
        return oddHead.next;
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
        
        ll.addElementAtStart(4);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(8);
        print();
        head = segregateListAccordingToValue(ll.head);
        print();
    }
}