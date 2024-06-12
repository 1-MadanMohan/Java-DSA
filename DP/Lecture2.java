package DP;
//climbstairs
public class Lecture2 {
//        private int climbStairs1(int n, Map<Integer, Integer> memo) {
//            if (n == 0 || n == 1) {
//                return 1;
//            }
//            if (!memo.containsKey(n)) {
//                memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
//            }
//            return memo.get(n);
//        }
public static int climbStairs1(int n) {
    int[] dp = new int[n + 1];
    return climbStairsHelper(n, dp);
}
 private static int climbStairsHelper(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] == 0) { // If the value has not been computed yet
            dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);
        }
        return dp[n];
    }
    //tabulation
    public static int climbStairs2(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
    }
//space optimization
        public static int climbStairs3(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int prev = 1, curr = 1;
            for (int i = 2; i <= n; i++) {
                int temp = curr;
                curr = prev + curr;
                prev = temp;
            }
            return curr;
        }
    public static void main(String[] args) {
        System.out.println(climbStairs1(0));
        System.out.println(climbStairs2(0));
        System.out.println(climbStairs3(4));
    }

}

