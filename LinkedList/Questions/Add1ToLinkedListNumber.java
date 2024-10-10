class Add1ToLinkedListNumber{
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
    public static Node reverse(Node head){
        Node temp=null;
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static Node addOne(Node head){
        Node temp=reverse(head);
        Node dummy = temp;
        Node prev=null;
        int carry=1;
        while(temp!=null){
            prev=temp;
            int sum = temp.data + carry;
            temp.data= sum%10;
            carry= sum/10;
            temp=temp.next;
        }
        if(carry>0){
            prev.next = new Node(carry);
        }

        return reverse(dummy);
    }

    //using recursion
    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static int addWithCarry(Node head){
        if (head == null)
            return 1;
 
        int res = head.data + addWithCarry(head.next);
        head.data = (res) % 10;
        return (res) / 10;
    }

    public static Node addOneUsingRecursion(Node head){
 
        int carry = addWithCarry(head);
         if (carry > 0){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode; 
        }
        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){        
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(9);        
        head = addOneUsingRecursion(head);
        print(head);
    }
}