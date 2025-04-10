import java.util.*;

class UnionByRank {
    public static List<Integer> rank = new ArrayList<>();
    public static List<Integer> parent = new ArrayList<>();

    //Time Complexity:  The actual time complexity is O(4) which is very small and close to 1. So, we can consider 4 as a constant.
    public static int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public static void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public static void main (String[] args) {
        for (int i = 0; i <= 7; i++) {
            rank.add(0);
            parent.add(i);
        }
       unionByRank(1, 2);
       unionByRank(2, 3);
       unionByRank(4, 5);
       unionByRank(6, 7);
       unionByRank(5, 6);

        if (findUPar(3) ==findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

       unionByRank(3, 7);
        if (findUPar(3) ==findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

