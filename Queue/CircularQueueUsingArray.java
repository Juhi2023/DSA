class CircularQueueUsingArray{

    public static class CircularQueue{
        static int front;
        static int rear;
        static int size;
        static int arr[];

        CircularQueue(int n){
            arr = new int[n];
            size=n;
            rear=-1;
            front=-1;
        }

        public static boolean isEmpty(){
            return rear==-1 && front ==-1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;  //(front==0 and rear=size-1) || (front == rear+1)
        }

        public static void enqueue(int data){
            if(isFull()){
                System.out.println("Queue is full"); 
                return;
            }
            if(front==-1)
                front=0;
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public static int dequeue(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int x=arr[front];
            if(front==rear){
                front=-1;
                rear=-1;
            }else{
                front= (front+1)%rear;
            }
            return x;
        }

        public static int peek(){
            if(front==-1){
                System.out.println("Queue Underflow"); 
                return -1;
            }
            return arr[front];
        } 

        public static void print(){ 
            for(int i = front; i!=rear; i=(i+1)%size){ 
                System.out.print(" "+ arr[i]); 
            } 
            System.out.print(" "+ arr[rear]);
        }
    }

    public static void main(String args[]){
        CircularQueue q = new CircularQueue(7);
        q.dequeue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        q.print();
    }
}