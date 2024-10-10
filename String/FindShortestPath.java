import java.util.*;

public class FindShortestPath{

    public static float getDistance(String str){
        int x=0, y=0;

        for(int i=0; i<str.length(); i++){
            int dir = str.charAt(i);
            if(dir=='W')
                x--;
            else if(dir=='E')
                x++;
            else if(dir == 'N')
                y++;
            else
                y--;
        }
        x*=x;
        y*=y;

        return (float)Math.sqrt(x+y);
    }

    public static void main (String args[]){
        System.out.println(getDistance("WNEENESENNN"));
    }
}