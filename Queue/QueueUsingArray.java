class QueueUsingArray{
    static final int MAX = 1000; 

    public static class Queue{
        static int front;
        static int rear;
        static int size;
        static int arr[];

        Queue(int n){
            arr = new int[n];
            size=n;
            rear=-1;
            front=0;
        }

        public static boolean isEmpty(){
            return rear==-1;
        }

        public static void enqueue(int data){
            if(rear+1 == size){
                System.out.println("Queue Overflow"); 
                return;
            }
            
            arr[++rear] = data;
        }

        public static int dequeue(){
            if (front > rear) {
                System.out.println("Queue is empty");
                return -1;
            }

            int x=arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            return x;
        }

        public static int peek(){
            if(rear==-1){
                System.out.println("Queue Underflow"); 
                return -1;
            }
            return arr[0];
        } 

        public static void print(){ 
            for(int i = 0;i<size;i++){ 
                System.out.print(" "+ arr[i]); 
            } 
        }
    }

    public static void main(String args[]){
        Queue q = new Queue(10);
        q.dequeue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        q.dequeue();
        q.print();
    }
}