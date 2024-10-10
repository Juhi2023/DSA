import java.util.*;
class LRUCache{
    static Node head = new Node(0,0);
    static Node tail = new Node(0,0);
    static HashMap<Integer, Node> cache = new HashMap<>();
    static int capacity;

    public LRUCache(int n){
        capacity = n;
        head.next = tail;
        tail.prev = head;
    }

    public static void insertAtHead(Node n){
        map.put(n.key, n);
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev=head;
    }

    public static void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public static int get(int key){
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            insertAtHead(temp);
            return temp.data;
        }else{
            return -1;
        }
    }

    public static void put(int key, int data){
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insertAtHead(new Node(key, data));
    }

    public static void print(){
        Node temp = head.next;
        while(temp.next!=null){
            System.out.print("("+temp.key+", "+temp.data+") - ");
            temp=temp.next;
        }
    }

    static class Node{
        int key;
        int data;
        Node prev, next;

        public Node(int _key, int _data){
            key = _key;
            data= _data;
            prev = next = null;
        }
    }
    
    public static void main(String args[]){
        LRUCache cache = new LRUCache(4);
        cache.put(2,6);
        cache.put(4,7);
        cache.put(8, 11);
        cache.put(7, 10);
        cache.put(5,6);
        cache.get(3);
        cache.get(4);
        cache.put(8, 6);
        cache.print();
    }
}