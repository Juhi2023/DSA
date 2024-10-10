import java.util.*;
class AsignCookies{

    public static int findContentChildren(int greed[], int []cookieSize){
        int n = greed.length;
        int m = cookieSize.length;
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l=0;
        int r=0;
        while(l<n && r< m){
            if(greed[l]<=cookieSize[r]){
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookieSize = {4, 2, 1, 2, 1, 3};
        System.out.println(findContentChildren(greed, cookieSize));
    }
}