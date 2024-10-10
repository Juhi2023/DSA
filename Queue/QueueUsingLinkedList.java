class QueueUsingLinkedList{

    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue{
        static Node front=null;
        static Node rear=null;
        static int size=0;
        
        public static void enqueue(int data){
            size++;
            Node newNode = new Node(data);
            if(rear==null){
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear=newNode;
        }

        public static int dequeue(){
            if(front==null)
                return -1;
            size--;
            Node temp = front;
            front = front.next;
            temp.next=null;
            return temp.data;
        }

        public static int peek(){
            if(front==null){
                System.out.println("Queue Underflow"); 
                return -1;
            }
            return front.data;
        } 

        public static boolean isEmpty(){
            return head==null && tail==null;
        } 

        public static void print(){ 
            Node temp = front;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
                
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        q.print();
    }
}