import java.util.HashMap;
import java.util.Map;

class cloneListWithRandomPointer {

    public static class Node {
        int data;
        Node next;
        Node random;
    
        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    //Using hashmap
    //Time Complexity: O(2N)
    //Space Complexity: O(2N)
    static Node cloneLinkedListUsingHashing(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            mp.put(curr, new Node(curr.data));
            curr = curr.next;
        }
    
        curr = head;
        while (curr != null) {
            Node newNode = mp.get(curr);
            newNode.next = mp.get(curr.next);
            newNode.random = mp.get(curr.random);
      
            curr = curr.next;
        }
  
        return mp.get(head);
    }

    static Node cloneLinkedList(Node head) {
        if(head==null)
            return;
        //joining new nodes between orignal nodes
        Node temp=head;
        while(temp!=null){
            Node next = temp.next;
            Node clone = new Node(temp.data);
            temp.next = clone;
            clone.next = next;
            temp=next;
        }

        //joining random pointer
        temp = head;
        while(temp!=null){
            Node clone = temp.next;
            clone.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next; 
        }

        //removing orignal nodes
        temp = head;
        Node cloneHead = temp.next;
        Node clone = cloneHead;
        while(temp!=null){
            temp.next = clone.next;
            temp = temp.next;
            if(temp!=null){
                clone.next = temp.next;
                clone = clone.next;
            }
        }
        return cloneHead;

    }

    static void printList(Node head) {
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
  
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;
  
        System.out.println("Original linked list:");
        printList(head);
  
        Node clonedList = cloneLinkedListUsingHashing(head);
        System.out.println("Cloned linked list:");
        printList(clonedList);
    }
}
