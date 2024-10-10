import java.util.* ;
class UnionOfTwoSortedArrays{
    public static ArrayList<Integer> union(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=0;
        int j=0;

        while(i<n && j<m){
            while(i<n-1 && arr1[i]==arr1[i+1])
                i++;
            while(j<m-1 && arr2[j]==arr2[j+1])
                j++;
            if(arr1[i]==arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]<arr2[j]){
                list.add(arr1[i]);
                i++;
            }else{
                list.add(arr2[j]);
                j++;
            }
        }
        
        while(i<n){
            while(i<n-1 && arr1[i]==arr1[i+1])
                i++;
            list.add(arr1[i]);
            i++;
        }
        while(j<m){
            while(j<m-1 && arr2[j]==arr2[j+1])
                j++;
            list.add(arr2[j]);
            j++;
        }
        return list;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr1 = {2,2,5,7,7,7,8};
        int[] arr2 = {1,1,1,2,7,10,11};

        ArrayList<Integer> result =union(arr1, arr2, arr1.length, arr2.length);
        for (int n: result){
            System.out.print(n+" ");
        }
    }
}