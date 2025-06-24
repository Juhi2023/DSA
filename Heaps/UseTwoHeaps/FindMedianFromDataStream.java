import java.util.*;
class FindMedianFromDataStream {
    
    public static void main(String args[]) {
        MedianFinder obj = new MedianFinder();
        obj.add(3);
        obj.add(5);
        obj.add(10);
        System.out.println(obj.findMedian());
        obj.add(9);
        System.out.println(obj.findMedian());
    }
}

//Binary Search
//Time Complexity
// add(num)	O(n)
// findMedian()	O(1)
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }
    
    public void add(int num) {
        
        int start =0 , end= list.size(), mid;
        while(start<end){
            mid = (start+end)/2;
            if(num < list.get(mid))
                end = mid;
            else 
                start = mid+1;
        }
        
        list.add(start, num);
    }
    
    public double findMedian() {
        int size = list.size();
        double median=0;
        if(size% 2 == 0){
            median = (list.get(size/2) + list.get(size/2 -1)) / 2.0;
        }else{
            median = list.get(size/2);
            
        }
        
        return median;
    }
}

//Binary Search
//Time Complexity
// add(num)	O(log n)
// findMedian()	O(1)

class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num<left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        if(left.size() > right.size()+1){
            right.offer(left.poll());
        }else if(right.size() > left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        int ls = left.size();
        int rs = right.size();
        if(ls>rs){
            return left.peek();
        }else if(rs>ls){
            return right.peek();
        }
        return (double)(right.peek() + left.peek())/2;
    }
}