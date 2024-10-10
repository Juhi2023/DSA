import java.util.* ;
class ReverseArray{
    public static void reverseArray(int arr []){
        int start=0, end=arr.length-1;
        while(start<end){
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;

            start++;
            end--;
        }
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        System.out.println("Reversed Array: ");
        reverseArray(arr);
        for(int i=0; i<num; i++){
        System.out.println(arr[i]);
        }
    }
}