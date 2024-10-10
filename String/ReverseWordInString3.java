public class ReverseWordInString3{

    public static void reverseWords (char str[], int s, int e){
        while(s<=e){
            char temp = str[e];
            str[e] = str[s];
            str[s]= temp;
            s++;
            e--;
        }
    }

    public static String reverseString(String s) {
        int n= s.length();
        if(n<=1)
            return s;
        
        char arr[] = s.toCharArray();
        int i=0;
        int j=0;
        while(j<=arr.length){
            if(j==arr.length || arr[j]==' '){
                reverseWords(arr, i, j-1);
                i=j+1;
            }
            j++;
        }
        return new String(arr);
    }



    public static void main(String [] args){
        System.out.println(reverseString("Reverse String titLe"));
    }
}