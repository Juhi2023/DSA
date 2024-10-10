class AddTwoNumbers{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public static Node addNumbers(Node l1, Node l2) {
        Node dummy=new Node(0);
        Node ans = dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int digit1 =  l1!=null ? l1.data : 0;
            int digit2 =  l2!=null ? l2.data : 0;
            int sum = digit1 + digit2 + carry;
            dummy.next = new Node(sum%10);
            carry=sum/10;
            dummy=dummy.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return ans.next;
    }

    public static void main(String args[]){        
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node ans = addNumbers(head1, head2);
        while(ans!=null){
            System.out.print(ans.data+"-->");
            ans=ans.next;
        }
    }
}