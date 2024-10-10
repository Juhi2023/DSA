public class CapitalizeTheTitle{

    public static String capitalize(String s){
        int n=s.length();
        StringBuilder newStr= new StringBuilder("");

        //convert to lowercase
        for(int i=0; i<n; i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z')
                newStr.append((char)('a'+s.charAt(i)-'A'));
            else
                newStr.append(s.charAt(i));
        }

        //capitalize
        int i=0, j=0;
        while(i<n){
            int count=0;
            while(j<n && newStr.charAt(j)!=' '){
                j++;
                count++;
            }

            if(count>2){ //j-i
                newStr.setCharAt(i, (char)('A' + newStr.charAt(i) - 'a'));
            }
            i=++j;
        }

        return newStr.toString();
    }

    public static void main(String [] args){
        System.out.println(capitalize("  capiTalIze       tH titLe"));
    }
}