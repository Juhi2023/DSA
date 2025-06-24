import java.util.*;


class MergekSortedLists {

    //Brute Force: Merge One by One
    //Time Complexity: (n * k * k) 

    //Divide and Conquer
    //Time Complexity: (n * k * log k) 

    //Heap
    //Time Complexity: (n * k * log k) 
    static Node mergeKLists(List<Node> lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(Node x: lists){
            if(x!=null)
                pq.add(x);
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp=temp.next;
            if(temp.next!=null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3;

        List<Node> arr = new ArrayList<>();

        arr.add(new Node(1));
        arr.get(0).next = new Node(3);
        arr.get(0).next.next = new Node(5);
        arr.get(0).next.next.next = new Node(7);

        arr.add(new Node(2));
        arr.get(1).next = new Node(4);
        arr.get(1).next.next = new Node(6);
        arr.get(1).next.next.next = new Node(8);

        arr.add(new Node(0));
        arr.get(2).next = new Node(9);
        arr.get(2).next.next = new Node(10);
        arr.get(2).next.next.next = new Node(11);

        Node head = mergeKLists(arr);

        printList(head);
    }

}

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}