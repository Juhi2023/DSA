//https://leetcode.com/problems/my-calendar-i/description/

class MyCalendar {
    List<int[]> calender;

    public MyCalendar() {
        calender = new ArrayList<>();
    }
    
    //Brute Force
    //Time Complexity: O(N^2)
    //Space Complexity: O(N)

    //Binary Search
    //Time Complexity: O(N log N)
    //Space Complexity: O(N)
    public boolean book(int startTime, int endTime) {
        int low=0, high=calender.size()-1;

        while(low<=high){
            int mid = (low+high)/2;
            int booking [] = calender.get(mid);
            if(booking [1] <= startTime)
                high = mid-1;
            else if(booking [0] >= endTime)
                low = mid+1;
            else
                return false;
        }

        calender.add(low, new int[]{startTime, endTime});
        return true;
    }
}
