import java.util.*;

class UnionBySize {
    public static List<Integer> size = new ArrayList<>();
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

    public static void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public static void main (String[] args) {
        for (int i = 0; i <= 7; i++) {
            size.add(0);
            parent.add(i);
        }
       unionBySize(1, 2);
       unionBySize(2, 3);
       unionBySize(4, 5);
       unionBySize(6, 7);
       unionBySize(5, 6);

        if (findUPar(3) ==findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

       unionBySize(3, 7);
        if (findUPar(3) ==findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

