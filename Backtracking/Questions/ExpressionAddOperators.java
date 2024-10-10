import java.util.*;
class ExpressionAddOperators{
    public static void solve(String num, int index,long prev, long total, int target, String exp, List<String> ans){
        if(index==num.length()){
            if(total==target)
                ans.add(exp);
            return;
        }


        for(int i=index ;i< num.length(); i++){
            String temp = num.substring(index, i + 1);
            long curr = Long.parseLong(temp);
            if(index==0){
                solve(num, i+1, curr, curr, target, temp, ans);
            }else{
                solve(num, i+1, curr, total+curr, target, exp+"+"+temp, ans);
                solve(num, i+1, -curr, total-curr, target, exp+"-"+temp, ans);
                solve(num, i+1, prev*curr, (total-prev)+(prev*curr), target, exp+"*"+temp, ans);
            }
            if(num.charAt(index)=='0'){
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        solve("0123", 0,0, 0, 6, "", ans);
        System.out.println(ans);
    }
}