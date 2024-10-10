import java.util.*;
class QueueUsingArray{
    static final int MAX = 1000; 

    public static class Stack{
        static int top=-1;
        static int s[] = new int[MAX];

        public static boolean isEmpty(){
            return top<0;
        }

        public static void push(int data){
            if(top+1>MAX){
                System.out.println("Stack Overflow"); 
                return;
            }
            
            s[++top] = data;
        }

        public static int pop(){
            if(top<0){
                System.out.println("Stack Underflow"); 
                return 0;
            }
            int x = s[top];
            top--;
            return x;
        }

        public static int peek(){
            if (top < 0) { 
                System.out.println("Stack Underflow"); 
                return 0; 
            } 
            else { 
                int x = s[top]; 
                return x; 
            } 
        } 

        public static void print(){ 
            for(int i = top;i>-1;i--){ 
                System.out.print(" "+ s[i]); 
            } 
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.print();
    }
}