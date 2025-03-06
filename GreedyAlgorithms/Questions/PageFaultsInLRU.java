import java.util.*;
class PageFaultsInLRU{

    public static int pageFaults(int N, int C, int pages[]){
        int fault=0;
         LinkedList<Integer> set = new LinkedList<>();
        
        for(int j=0; j<N; j++){
            if(!set.contains(pages[j]) && set.size()<C){
                fault++;
            }else if(!set.contains(pages[j]) && set.size()==C){
                fault++;
                set.remove(0);
            }else{
                int index = set.indexOf(pages[j]);
                set.remove(index);
            }
            set.add(pages[j]);
        }
        
        return fault;
    }

    public static void main(String[] args) {
        System.out.println(pageFaults(9, 4, new int[]{5, 0, 1, 3, 2, 4, 1, 0, 5}));
    }
}