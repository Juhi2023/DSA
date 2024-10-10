import java.util.*;
class JCFDeque{
    public static void main(String args[]){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        System.out.println(deque);
        System.out.println(deque.getFirst());
    }
}