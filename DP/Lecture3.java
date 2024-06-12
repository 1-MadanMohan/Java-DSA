package DP;
import java.util.* ;

//Frog Problem
public class Lecture3 {
    // DP memoization solution
    public static int helper(int[] heights, int[] dp, int index){
        if(index==0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int leftSide = helper(heights,dp , index-1) + Math.abs(heights[index] - heights[index-1]);

        int rightSide = Integer.MAX_VALUE;

        if(index>1){
            rightSide = helper(heights, dp, index-2) + Math.abs(heights[index] - heights[index-2]);
        }
        dp[index] = Math.min(leftSide, rightSide);
        return dp[index];
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(heights,dp, n-1);
    }
    // DP Tabulation Solution
    public static int frogJump2(int n, int heights[]) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // base case
        dp[0] = 0;

        for(int i=1 ; i<=n-1 ; i++){
            int first = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1){
                second = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(first,second);
        }

        return dp[n-1];
    }
//space opitimization
    public static int frogJump3(int n, int heights[]) {
        int p1 = 0;
        int p2 = 0;
        for(int i=1 ; i<=n-1 ; i++){
            int first = p1 + Math.abs(heights[i] - heights[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1){
                second = p2 + Math.abs(heights[i] - heights[i-2]);
            }
            int curr = Math.min(first, second);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }

    public static void main(String[] args) {
    int[] arr1 = {10,20,30,10};
    int[] arr2 = {10,20,15,5};
        System.out.println(frogJump(4,arr1));
        System.out.println(frogJump2(4,arr1));
        System.out.println(frogJump3(4,arr1));
        System.out.println(frogJump(4,arr2));
        System.out.println(frogJump2(4,arr2));
        System.out.println(frogJump3(4,arr2));

    }


}
