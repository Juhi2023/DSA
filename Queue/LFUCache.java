import java.util.*;
class LFUCache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, MyList> freq;
    int capacity;
    int minFrequency;
    int cacheSize;
    
    class Node{
        int data;
        int key;
        int frequency;
        Node next;
        Node prev;

        Node(int _key, int _data){
            key = _key;
            data = _data;
            frequency=1;
            next=null;
            prev=null;
        }
    }

    class MyList{
        Node head;
        Node tail;
        int size;

        MyList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev= head;
            size=0;
        }

        public void  insert(Node n){
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
            n.prev= head;
            size++;
        }

        public void remove(Node n){
            n.prev.next  = n.next;
            n.next.prev = n.prev;
            size--;
        }
    }

    public LFUCache(int n) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        capacity = n;
        minFrequency=0;
        cacheSize=0;
    }
    
    public int get(int key) {
        Node temp = cache.get(key);
        if(temp==null)
            return -1;
        updateNode(temp);
        return temp.data;
    }
    
    public void put(int key, int data) {
        if(capacity==0)
            return;

        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.data = data;
            updateNode(curNode);
        }else{
            if(cacheSize + 1>capacity){
                MyList minFreqList = freq.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
            }else{
                cacheSize++;
            }
            minFrequency=1;
            Node newNode = new Node(key, data);
            MyList newList = freq.getOrDefault(1, new MyList());
            newList.insert(newNode);
            freq.put(1, newList);
            cache.put(key, newNode);
        }


    }

    public void updateNode(Node n) {
        int curFreq = n.frequency;
        MyList head = freq.get(curFreq);
        head.remove(n);

        if (curFreq == minFrequency && head.size == 0) {
            minFrequency++;
        }

        n.frequency++;

        MyList newList = freq.getOrDefault(n.frequency, new MyList());
        newList.insert(n);
        freq.put(n.frequency, newList);
    }

    public static void main(String args[]){
        LFUCache c = new LFUCache(2);
        c.put(1, 10);
        c.put(2, 20);
        c.get(1);
        c.put(3, 10);
        c.get(2);
        c.get(3);
        c.put(4, 40);
    }
}
