import java.util.*;

class QueueUsingStack {
    static public class MyQueue {
        static Stack < Integer > st1 = new Stack < > ();
        static Stack < Integer > st2 = new Stack < > ();

        public MyQueue() {

        }

        public void push(int x) {
            while (st1.empty() == false) {
                st2.push(st1.peek());
                st1.pop();
            }
            System.out.println("The element pushed is " + x);
            st1.push(x);
            while (st2.empty() == false) {
                st1.push(st2.peek());
                st2.pop();
            }

        }

        public int pop() {
            if (st1.empty()) {
                System.out.println("Stack is empty");

            }
            int val = st1.peek();
            st1.pop();
            return val;

        }

        public int peek() {
            if (st1.empty()) {
                System.out.println("Stack is empty");
            }
            return st1.peek();
        }


        int size() {
            return st1.size();
        }
    }

    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}