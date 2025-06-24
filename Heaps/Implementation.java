import java.util.*;

class Implementation{
    //heapify element
    public static void minHeapifyArray(int[] arr, int n, int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int minInd=i;

        if(left <n && arr[minInd]> arr[left]){
            minInd = left;
        }
        if(right <n && arr[minInd]> arr[right]){
            minInd = right;
        }

        if(minInd!=i){
            int temp = arr[minInd];
            arr[minInd]= arr[i];
            arr[i]=temp;
            
            minHeapifyArray(arr, n, minInd);
        }
    }

    public static void maxHeapifyArray(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxInd = i;

        if (left < n && arr[left] > arr[maxInd]) {
            maxInd = left;
        }

        if (right < n && arr[right] > arr[maxInd]) {
            maxInd = right;
        }

        if (maxInd != i) {
            int temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;

            maxHeapifyArray(arr, n, maxInd);
        }
    }

    public static void heapSortAsc(int arr[]){
        int n= arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyArray(arr, n, i);
        }

        for (int i =n-1; i>0; i--) {
            int temp =  arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeapifyArray(arr, i, 0);
        }
    }

     public static void heapSortDesc(int arr[]){
        int n= arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapifyArray(arr, n, i);
        }

        for (int i =n-1; i>0; i--) {
            int temp =  arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            minHeapifyArray(arr, i, 0);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        Heap minHeap = new Heap();
        minHeap.insert(4);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(5);
        System.out.println("Min value is " + minHeap.peek());
        minHeap.insert(-1);
        System.out.println("Min value is " + minHeap.peek());
        minHeap.remove();
        System.out.println("Peak value is " + minHeap.peek());
        minHeap.print();

        //Convert to min heap
        int[] values = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int n = values.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            minHeapifyArray(values, n, i);
        }
        print(values);

        //Convert to max heap
        int[] values2 = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        n=values2.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyArray(values2, n, i);
        }
        print(values2);

        //Heap Sort using max heap in asc
        int[] values3 = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        heapSortAsc(values3);
        print(values3);

        //Heap Sort using min heap in desc
        int[] values4 = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        heapSortDesc(values4);
        print(values4);
    }
}

public class Heap{
    ArrayList<Integer> arr;

    public Heap(){
        arr= new ArrayList<>();
    }

    //Insert
    public void insert(int data){
        arr.add(data);
        int x= arr.size()-1;
        while (x > 0) {
            int parent = (x - 1) / 2;

            if (arr.get(parent) > arr.get(x)) {
                // Swap parent and child
                int temp = arr.get(parent);
                arr.set(parent, arr.get(x));
                arr.set(x, temp);

                x = parent;
            } else {
                break;
            }
        }
    }

    //Top
    public int peek(){
        return arr.get(0); 
    }

    //Delete
    public void remove(){
        //1. swap first and last element
        arr.set(0, arr.get(arr.size()-1));

        //2.remove last element
        arr.remove(arr.size()-1);

        //3. heapify 
        minHeapify(0);
    }

    //min heapify element
    public void minHeapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int minInd=i;

        if(left <arr.size() && arr.get(minInd)> arr.get(left)){
            minInd = left;
        }
        if(right <arr.size() && arr.get(minInd)> arr.get(right)){
            minInd = right;
        }

        if(minInd!=i){
            int temp = arr.get(minInd);
            arr.set(minInd, arr.get(i));
            arr.set(i, temp);

            minHeapify(minInd);
        }
    }

    public void print() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
}