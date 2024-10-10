class PrintSubStrings{
    
    public static String removeDuplicate  (String s){
        if(s.length()==0)
            return "";

        char c = s.charAt(0);
        String newStr = removeDuplicate(s.substring(1));
        
        if(newStr.length()>0 && c == newStr.charAt(0))
            return newStr;
        
        return c+newStr;
    }

    public static void main(String []args){
        System.out.println(removeDuplicate("aaaabbbbbccddefff"));
    }
}