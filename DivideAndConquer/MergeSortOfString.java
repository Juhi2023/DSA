class MergeSortOfStrings{

    public static void mergeSort(String arr[], int low, int high){
        if(low >=high)
            return;

        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(String arr[], int low, int mid, int high){
        String temp[] = new String[high-low+1];
        int l=low;
        int r=mid+1;
        int k=0;

        while(l<=mid && r<=high){
            if(isAlphabeticallySmaller(arr[l], arr[r])){
                temp[k]= arr[l];
                l++;
            }else{
                temp[k]= arr[r];
                r++;
            }

            k++;
        }

        while(l<=mid){
            temp[k++]= arr[l++];
        }
        while(r<=high){
            temp[k++]= arr[r++];
        }

        for(int i=low; i<=high; i++){
            arr[i]= temp[i-low];
        }
    }

    public static boolean isAlphabeticallySmaller(String a, String b){
        if(a.compareTo(b)<0)
            return  true;
        return false;
    }

    public static void main(String [] args){
        String [] arr = {"Apple", "Appeal", "Bowl", "Ball"};
        mergeSort(arr, 0, arr.length-1);

        for(String s : arr){
            System.out.println(s);
        }
    }
}