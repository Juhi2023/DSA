public class RomanToInteger{


    public static int getInteger(String s) {
        int ans=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='I'){
                if(i+1<n && s.charAt(i+1)=='V'){
                    i++;
                    ans+=4;
                }else if(i+1<n && s.charAt(i+1)=='X'){
                    i++;
                    ans+=5;
                }else{
                    ans+=1;
                }
            }
            else if(s.charAt(i)=='V')
                ans+=5;
            else if(s.charAt(i)=='X'){
                if(i+1<n && s.charAt(i+1)=='L'){
                    i++;
                    ans+=40;
                }else if(i+1<n && s.charAt(i+1)=='C'){
                    i++;
                    ans+=90;
                }else{
                    ans+=10;
                }
            }
            else if(s.charAt(i)=='L')
                ans+=50;
            else if(s.charAt(i)=='C'){
                if(i+1<n && s.charAt(i+1)=='D'){
                    i++;
                    ans+=400;
                }else if(i+1<n && s.charAt(i+1)=='M'){
                    i++;
                    ans+=900;
                }else{
                    ans+=100;
                }
            }
            else if(s.charAt(i)=='D')
                ans+=500;
            else if(s.charAt(i)=='M')
                ans+=1000;
        }
        return ans;
    }


    public static int getInteger2(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' : number = 1000;break;
                case 'D' : number = 500;break;
                case 'C' : number = 100;break;
                case 'L' : number = 50;break;
                case 'X' : number = 10;break;
                case 'V' : number = 5;break;
                case 'I' : number = 1;break;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;

    }



    public static void main(String [] args){
        System.out.println(getInteger2("MCMXCIV"));
    }
}