import java.util.* ;
class MergeSortedArray{
    public static int[] mergeArray(int nums1 [], int nums2 [], int m, int n){
        int p1 = m-1;
        int p2 = n-1;
        int x= m+n-1;

        while(p1>=0 && p2>=0){
            if(nums2[p2]>nums1[p1]){
                nums1[x]=nums2[p2];
                x--;
                p2--;
            }else{
                nums1[x]=nums1[p1];
                x--;
                p1--;
            } 
        }

        while(p2>=0){
            nums1[x]=nums2[p2];
            x--;
            p2--;
        } 
        return nums1;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr1 = {2,5,7,8,0,0,0,0, 0};
        int[] arr2 = {1,4,6,10,11};

        int result[] =mergeArray(arr1, arr2, 4, arr2.length);
        for (int n: result){
            System.out.print(n+" ");
        }
    }
}