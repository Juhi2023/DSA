class RemoveCycleInLL{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    

    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static void removeCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow=head;
                Node prev=null;
                while(slow!=fast){
                    prev=fast;
                    slow=slow.next;
                    fast=fast.next;
                }
                prev.next=null;
            }
        }
    }

    public static void main(String args[]){        
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next = head.next;
        System.out.println(removeCycle(head));
    }
}