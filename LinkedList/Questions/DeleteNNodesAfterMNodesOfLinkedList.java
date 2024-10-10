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

    public static void linkdelete(Node head, int n, int m) {
        Node temp = head;
        while(temp!=null){
            int cnt=1;
            while(cnt<m && temp!=null){
                temp=temp.next;
                cnt++;
            }
            if(temp==null)
                break;
            cnt=0;
            Node start=temp;
            while(cnt<n && temp!=null){
                temp=temp.next;
                cnt++;
            }
            Node res = temp==null ? null : temp.next;
            start.next= res;
            temp=res;
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
        ll.addElementAtStart(8);
        ll.addElementAtStart(7);
        ll.addElementAtStart(6);
        ll.addElementAtStart(5);
        ll.addElementAtStart(4);
        ll.addElementAtStart(3);
        ll.addElementAtStart(2);
        ll.addElementAtStart(1);
        print();
        linkdelete(ll.head, 3, 2);
        print();
    }
}