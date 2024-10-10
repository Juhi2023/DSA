class ReverseString{
    
    public static String reverseString(String s, int n){
        if(n==s.length()-1)
            return Character.toString(s.charAt(n));

        StringBuilder newStr = new StringBuilder(reverseString(s, n+1));
        newStr.append(s.charAt(n));
        return newStr.toString();
    }

    public static void main(String []args){
        System.out.println(reverseString("Hello", 0));
    }
}