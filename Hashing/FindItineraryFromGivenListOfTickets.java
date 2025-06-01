import java.util.*;

public class FindItineraryFromGivenListOfTickets{

    //Brute Force 
    //Time Complexity: O(n^3)

    //Better Approch
    //Time Complexity: O(n^2)

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static void findItinerary(List<List<String>> arr){
        Map<String, String> dataSet = new HashMap<>();
        for (List<String> i : arr) {
            dataSet.put(i.get(0), i.get(1));
        }

        Map<String, String> reverseMap = new HashMap<>();
        for (List<String> i : arr) {
            reverseMap.put(i.get(1), i.get(0));
        }

        String start = "";

        for (int i = 0; i < arr.size(); i++) {
            if (!reverseMap.containsKey(arr.get(i).get(0))) {
                start = arr.get(i).get(0);
                break;
            }
        }

        System.out.print(start+" -> ");
        for(String s: dataSet.keySet()){
            System.out.print(dataSet.get(start)+" -> ");
            start=dataSet.get(start);
        }

    }

    public static void main(String []arg){
        List<List<String>> arr = Arrays.asList(
                Arrays.asList("Chennai", "Bangalore"),
                Arrays.asList("Bombay", "Delhi"),
                Arrays.asList("Goa", "Chennai"),
                Arrays.asList("Delhi", "Goa")
        );

        findItinerary(arr);
    }
}