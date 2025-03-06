import java.util.*;
class FractionalKnapsack{

    //Time Complexity: O(n log n + n). O(n log n) 
    //The greedy method to maximize our answer will be to pick up the items with higher values. Since it is possible to break the items as well we should focus on picking up items having higher value /weight first.
    public static double fractionalKnapsack(int value[], int weight[], int capacity){
        int helper [][] = new int [value.length][2];
        for(int i=0; i< value.length; i++){
            helper[i][0] = value[i];
            helper[i][1] = weight[i];
        }
        int ans=0;
        Arrays.sort(helper, Comparator.comparing(o -> (double)o[0]/(double)o[1]));
        for(int i=value.length-1; i>=0; i--){
            if(helper[i][1]<=capacity){
                capacity-=helper[i][1];
                ans+=helper[i][0];
            }else{
                ans+=((double)helper[i][0]/(double)helper[i][1]) * capacity;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        System.out.println(fractionalKnapsack(value, weight, 50));
    }
}

// class Item {
//   int value, weight;
//   Item(int x, int y) {
//     this.value = x;
//     this.weight = y;
//   }
// }

// class itemComparator implements Comparator<Item>
// {
//     @Override
//     public int compare(Item a, Item b) 
//     {
//         double r1 = (double)(a.value) / (double)(a.weight); 
//         double r2 = (double)(b.value) / (double)(b.weight); 
//         if(r1 < r2) return 1; 
//         else if(r1 > r2) return -1; 
//         else return 0; 
//     }
// }