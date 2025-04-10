import java.util.*;



class AccountsMerge {

    //Time Complexity: O(N+V) + O(E * 4alpha) + E(Log E)
    //Space Complexity: O(N)+ O(N) +O(2N) 
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        DSU dsu = new DSU(accounts.size());
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String x = accounts.get(i).get(j);
                if(map.containsKey(x))
                    dsu.union(i, map.get(x));
                else
                    map.put(x, i);
            }
        }

        List<List<String>> mergeList = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) mergeList.add(new ArrayList<>());
        for(String x : map.keySet()){
            mergeList.get(dsu.find(map.get(x))).add(x);
        }
        System.out.println(mergeList);

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (mergeList.get(i).size() == 0) 
                continue;
            Collections.sort(mergeList.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergeList.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

    }

    public static void main (String[] args) {
        List<List<String>> accounts = new ArrayList<>() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        List<List<String>> ans = accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }

    }
}

class DSU{
    int parent[];
    int size[];
    public DSU(int n){
        parent= new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i]=1;
        }
    }

    public int find(int node){
        if(node==parent[node])
        return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int a, int b){
        int pa = find(a);
        int pb= find(b);
        if(pa==pb)
            return;
        else if(pa>pb){
            parent[pb]=pa;
            size[pa]+=size[pb];
        }else{
            parent[pa]=pb;
            size[pb]+=size[pa];
        }
    }
}