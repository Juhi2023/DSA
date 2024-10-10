import java.util.*;

public class FlatteningLinkedList {

    public static class Node {
        int data;
        Node next, bottom;

        Node(int newData) {
            data = newData;
            next = bottom = null;
        }
    }

    //Using Array
    //Time Complexity: O(n*m) +  O(N*M log(N*M)) + O(N*M)
    //Space Complexity: O(n*m) (array) + O(n*m) (new nodes)
    static Node flatten(Node root) {
        List<Integer> values = new ArrayList<>();

        while (root != null) {
            values.add(root.data);
            Node temp = root.bottom;
            while (temp != null) {
                values.add(temp.data);
                temp = temp.bottom;
            }
            root = root.next;
        }

        Collections.sort(values);

        Node dummy = new Node(-1);
        Node head = dummy;
        for (int value : values) {
            Node newNode = new Node(value);
            head.bottom = newNode;
            head=newNode;
        }
        return dummy.bottom;
    }

    static Node merge(Node list1, Node list2) {
        Node dummy= new Node(-1);
        Node head= dummy;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                dummy.bottom = list1;
                list1=list1.bottom;
            }else{
                dummy.bottom = list2;
                list2=list2.bottom;
            }
            dummy=dummy.bottom;
        }
        while(list1!=null){
            dummy.bottom = list1;
            list1=list1.bottom;
            dummy=dummy.bottom;
        }
        while(list2!=null){
            dummy.bottom = list2;
            list2=list2.bottom;
            dummy=dummy.bottom;
        }
        return head.bottom;
    }

    //Using merge
    //Time Complexity: O(n* m) 
    //Space Complexity: O(1) 
    static Node flattenByMerge(Node root) {
        Node curr = root;
        root=root.next;
        while (root != null) {
            curr = merge(curr, root);            
            root = root.next;
        }
        return curr;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 5 -> 10 -> 19 -> 28
        // |    |     |
        // V    V     V
        // 7    20    22
        // |          |
        // V          V
        // 8          50
        // |
        // V
        // 30

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        head = flattenByMerge(head);

        printList(head);
    }
}
