import java.util.*;
class KPermutation{

    public static String getKthPermutation(int n, int k){

        List<Integer> a = new ArrayList<>();
        int fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
            a.add(i);
        }
        fact /= n;
        String ans="";
        
        while(true){
            ans += a.get(k/fact);
            a.remove(k/fact);
            if(a.size()==0)
                break;
            k= k%fact;
            fact = fact / a.size();
        }

        return ans;
    }


    public static void main(String args[]){
        System.out.println(getKthPermutation(4, 16));
    }
}