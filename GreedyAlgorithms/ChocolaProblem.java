import java.util.*;
class ChocolaProblem{

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int getMinCost(int n, int m, Integer costVer[], Integer []costHor){
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());
        int h=0, v=0;
        int hp=1, vp=1;

        int cost=0;

        while(h< costHor.length && v< costVer.length){
            if(costHor[h]>= costVer[v]){
                cost += costHor[h]* vp;
                h++;
                hp++;
            }else{
                cost += costVer[v]* hp;
                v++;
                vp++;
            }
        }

        while(h< costHor.length){
            cost += costHor[h]* vp;
            h++;
            hp++;
        }

        while(v< costVer.length){
            cost += costVer[v]* hp;
            v++;
            vp++;
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(getMinCost(4, 6, new Integer[]{2,1,3,1,4}, new Integer[]{4,1,2}));
    }
}