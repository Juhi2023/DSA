import java.util.*;

public class SmallestMultipleOF0And1 {
    
    public static String smallestMultiple(int A) {
        if (A == 1) return "1";
        
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[A];
        
        queue.offer("1");
        visited[1 % A] = true;
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int remainder = Integer.parseInt(current) % A;
            
            if (remainder == 0) {
                return current;
            }
            
            String next0 = current + "0";
            String next1 = current + "1";
            
            int remainder0 = Integer.parseInt(next0) % A;
            int remainder1 = Integer.parseInt(next1) % A;
            
            if (!visited[remainder0]) {
                queue.offer(next0);
                visited[remainder0] = true;
            }
            
            if (!visited[remainder1]) {
                queue.offer(next1);
                visited[remainder1] = true;
            }
        }
        
        return "";
    }

    public static void main(String[] args) {
        int A = 3;
        System.out.println(smallestMultiple(A)); 
        
        A = 5;
        System.out.println(smallestMultiple(A)); 
    }
}
