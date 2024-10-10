public class StringCompression{

    public static String getCompressedString(String s){
        int n=s.length();
        String newStr="";
        for(int i=0; i<n; i++){
            Integer count=1;
            while(i+1<n && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            newStr+= s.charAt(i) ;
            if(count>1)
                newStr+= count;
        }

        return newStr;
    }

    public static void main(String [] args){
        System.out.println(getCompressedString("aaaabbbcddd"));
    }
}