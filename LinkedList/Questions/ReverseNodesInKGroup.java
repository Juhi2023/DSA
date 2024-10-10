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

    public static Node reverseList(Node HEAD){
        Node prev = null;
        Node curr = HEAD;
        Node temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next= prev;
            prev=curr;
            curr = temp;
        }
        Node newHead = prev;
        return newHead;
    }

    public static Node reverseNodeInKGroup(Node HEAD, int k){
        if(HEAD==null || HEAD.next==null)
            return HEAD;
        
        Node temp = HEAD;
        Node newHead = null;
        Node prev = null;
        while(temp!=null){
            //getting kth node
            int cnt=1;
            Node start = temp;

            while(cnt<k && temp.next!=null){
                temp=temp.next;
                cnt++;
            }
            Node kThNode = temp;
            
            Node next = kThNode.next;
            kThNode.next=null;

            Node res = reverseList(start);

            if(newHead==null)
                newHead=res;
            else
                prev.next= res;
                
            prev=start;
            temp=next;
        }
        
        return newHead;
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
        ll.addElementAtStart(8);
        ll.addElementAtStart(7);
        ll.addElementAtStart(6);
        ll.addElementAtStart(5);
        ll.addElementAtStart(4);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        print();
        head = reverseNodeInKGroup(ll.head, 2);
        print();
    }
}