import java.util.*;

class NinjaTraining {
    //Memoization
    // Time Complexity: O(N*4*3) 4 = number of course
    // Space Complexity: O(N) + O(N*4)
    public static int f(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); 
            }
        }

        return dp[day][last] = maxi; 
    }

    public static int ninjaTraining(int n, int[][] points) {
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n - 1, 3, points, dp);
    }

    //Tabulation
    // Time Complexity: O(N*4*3) 4 = number of course
    // Space Complexity: O(N) + O(N*4)
    public static int ninjaTrainingByTab(int n, int[][] points) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day< points.length; day++){
            for(int last=0; last<4; last++){
                    int max=0;
                for(int i=0; i<3; i++){
                    if(i!=last){
                        max=Math.max(max, points[day][i]+dp[day-1][i]);
                    }
                    dp[day][last]=max;
                }
            }
        }
        return dp[points.length-1][3];
    }

    //other way
    // public static int ninjaTraining(int n, int[][] points) {
    //     int[][] dp = new int[n][3];
    //     dp[0][0] = Math.max(points[0][1], points[0][2]);
    //     dp[0][1] = Math.max(points[0][0], points[0][2]);
    //     dp[0][2] = Math.max(points[0][0], points[0][1]);

    //     for (int day = 1; day < n; day++) {
    //         for (int task = 0; task < 3; task++) {
    //             dp[day][task] = 0;
    //             for (int last = 0; last < 3; last++) {
    //                 if (task != last) {
    //                     int point = points[day][task] + dp[day - 1][last];
    //                     dp[day][task] = Math.max(dp[day][task], point);
    //                 }
    //             }
    //         }
    //     }

    //     return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    // }

    //Space Optimization
    // Time Complexity: O(N*4*3) 4 = number of course
    // Space Complexity: O(N) + O(N*4)
    public static int ninjaTrainingBySO(int n, int[][] points) {
        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day< points.length; day++){
            int temp[] = new int[4];
            for(int last=0; last<4; last++){
                for(int i=0; i<3; i++){
                    if(i!=last){
                        temp[last]=Math.max(temp[last], points[day][i]+prev[i]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }

    public static void main(String args[]) {
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90}};

        int n = points.length; 
        System.out.println(ninjaTrainingBySO(n, points)); 
    }
}

