import java.util.*;
class StackUsingLinkedList{
    static Node head=null;

    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack{

        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            newNode.next=head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            int x = head.data;
            head=head.next;
            return x;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            return head.data;
        } 

        public static void print(){
            Node temp = head; 
            while(temp!=null){ 
                System.out.print(" "+ temp.data); 
                temp=temp.next;
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