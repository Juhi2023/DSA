//https://leetcode.com/problems/my-calendar-ii/solutions/5838424/full-sweep-line-concept-dry-run-illustration-brute-submission-faster/


//Simple Approach
//Time Complexity: O(N)
//Space Complexity: O(N)
class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlapBookings;

    public boolean doesOverlap(int start1, int end1, int start2, int end2){
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int [] b: overlapBookings){
            if(doesOverlap(b[0], b[1], startTime, endTime)){
                return false;
            }
        }

        for(int [] b: bookings){
            if (doesOverlap(b[0], b[1], startTime, endTime)) {
                overlapBookings.add(new int[] { Math.max(b[0], startTime), Math.min(b[1], endTime)});
            }
        }
        bookings.add(new int[] { startTime, endTime });
        return true;
    }

}

//Line Sweep and prefix sum
//Time Complexity: O(N log N)
//Space Complexity: O(N)
class MyCalendarTwo {

    private Map<Integer, Integer> bookingCount;
    private int maxOverlappedBooking;

    public MyCalendarTwo() {
        bookingCount = new HashMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int start, int end) {
        // Increase the booking count at 'start' and decrease at 'end'.
        bookingCount.put(start, bookingCount.getOrDefault(start, 0) + 1);
        bookingCount.put(end, bookingCount.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;

        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            overlappedBooking += entry.getValue();
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes.
                bookingCount.put(start, bookingCount.get(start) - 1);
                bookingCount.put(end, bookingCount.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}