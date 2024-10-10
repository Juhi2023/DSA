import java.util.*;
class ReverseFirstKElementsOfQueue {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> temp = new Stack<>();
        int i=k;
        while(i>0){
            temp.push(q.remove());
            i--;
        }
        while(!temp.isEmpty()){
            q.add(temp.pop());
        }
        
        i=q.size()-k;
        while(i>0){
            q.add(q.remove());
            i--;
        }   
        return q;
    }

    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(modifyQueue(q, 3));
    }
}