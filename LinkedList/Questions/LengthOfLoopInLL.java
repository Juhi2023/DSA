class LengthOfLoopInLL{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Brute Force using hashmap
    //Time Complexity: O(N * 2 * log(N) ) (2 * log(N) for hashmap insert and search)
    //SpaceComplexity: O(N)
    

    //Time Complexity: O(n)
    //SpaceComplexity: O(1)
    public static int getLengthOfLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                fast=fast.next;
                int cnt=1;
                while(slow!=fast){
                    fast=fast.next;
                    cnt++;
                }
                return cnt;
            }
        }
        return 0;
    }

    public static void main(String args[]){        
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next = head.next;
        System.out.println(getLengthOfLoop(head));
    }
}