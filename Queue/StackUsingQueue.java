import java.util.*;

class StackUsingQueue {
    //Using One Stack
    static class MyStack1 {
        Queue<Integer> q;
        public MyStack1() {
            q = new LinkedList<>();
        }
        
        public void push(int x) {
            q.add(x);
            int s = q.size()-1;
            while(s>0){
                q.add(q.remove());
                s--;
            }
        }
        
        public int pop() {
            return q.remove();
        }
        
        public int top() {
            return q.peek();
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }

    //Using two Stack
    static class MyStack2 {
        Queue<Integer> q1;
        Queue<Integer> q2;
        public MyStack2() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        
        public void push(int x) {
            if(!q1.isEmpty())
                q1.add(x);
            else    
                q2.add(x);
        }
        
        public int pop() {
            if(empty())
                return -1;
            if(!q1.isEmpty()){
                while(q1.size()>1)
                    q2.add(q1.remove());
                return q1.remove();
            }else{
                while(q2.size()>1)
                    q1.add(q2.remove());
                return q2.remove();
            }
        }
        
        public int top() {
            if(empty())
                return -1;
            if(!q1.isEmpty()){
                while(q1.size()>1)
                    q2.add(q1.remove());
                return q1.remove();
            }else{
                while(q2.size()>1)
                    q1.add(q2.remove());
                return q2.remove();
            }
        }
        
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String args[]) {
        MyStack2 s = new MyStack2();
        s.push(3);
        s.push(4);
        System.out.println("The element poped is " + s.pop());
        s.push(5);
        System.out.println("The top element is " + s.top());
    }
}