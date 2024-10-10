import java.util.*;
class PushAtBottomOfStack{
    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack{
        static List<Integer> s = new ArrayList<>();

        public static boolean isEmpty(){
            return s.size()==0;
        }

        public static void push(int data){
            s.add(data);
        }

         public static void pushAtBottom(int data){
            if(isEmpty()){
                push(data);
                return;
            }
            int x = pop();
            pushAtBottom(data);
            push(x);
        }

        public static void reverse(){
            if(isEmpty()){
                return;
            }
            int x = pop();
            reverse();
            pushAtBottom(x);
        }

        public static int pop(){
            int size = s.size()-1;
            if(isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            int x = s.get(size);
            s.remove(size);
            return x;
        }

        public static int peek(){
            int size = s.size()-1;
            if(isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            int x = s.get(size);
            return x;
        } 

        public static void print(){ 
            for(int i = s.size()-1;i>-1;i--){ 
                System.out.print(" "+ s.get(i)); 
            } 
            System.out.println();
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.print();
        s.reverse();        
        s.print();
    }
}