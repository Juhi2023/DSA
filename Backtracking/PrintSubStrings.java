class PrintSubStrings{

    public static void getSubSets(String s, int index, String ans){
        if(index==s.length()){
            System.out.println(ans.length()==0 ? "null" : ans);
            return ;
        }

        getSubSets(s, index+1, ans+s.charAt(index));
        getSubSets(s, index+1, ans);
    }

    public static void main(String args[]){
        getSubSets("ABC", 0, "");
    }
}