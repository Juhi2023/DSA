import java.util.*;
class FindPairsWithGivenSumInDLL{
    public static int size=0;
    public static class  Node{
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<-->");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void addAtTail(Node head, int data){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode= new Node(data, null, temp);
        temp.next = newNode;
    }


    public static ArrayList<ArrayList<Integer>> findPairSum(Node head, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(head==null)
            return ans;
        Node ptr1 = head;
        Node ptr2=head;
        
        while(ptr2.next!=null)
            ptr2=ptr2.next;
        //work on oddd       //work on even length list
        while(ptr1!=ptr2 && ptr2.next!=ptr1){
            int sum = ptr1.data+ptr2.data;
            if(sum == target){
                ans.add(new ArrayList<>(Arrays.asList(ptr1.data, ptr2.data)));
                ptr1 = ptr1.next;
                ptr2 = ptr2.prev;
            }else if(sum> target){
                ptr2 = ptr2.prev;
            }else{
                ptr1 = ptr1.next;
            }
        }
        
        return ans;
    }

    public static void main(String args[]){        
        Node head = new Node(1);
        head.next = new Node(2, null, head);
        head.next.next = new Node(3, null, head.next);
        head.next.next.next = new Node(3, null, head.next.next);
        addAtTail(head, 4);
        addAtTail(head, 5);
        addAtTail(head, 6);
        print(head);
        ArrayList<ArrayList<Integer>> ans = findPairSum(head, 7);
        System.out.println(ans);
    }
}