package DP;
import java.util.*;
public class Lecture1 {
        //Memoization
        private static int fibonacci(int n, int[] dp){
            if(n<=1) {
                return dp[n]=n;
            }
            if(dp[n]!= -1) {
                return dp[n];
            }
            return dp[n]= fibonacci(n-1,dp) + fibonacci(n-2,dp);
        }
        //Tabulation
        private static int fibonacci2(int n) {
            int[] dp2 = new int[n + 1];
            Arrays.fill(dp2,-1);
            dp2[0] = 0;
            dp2[1] = 1;
            for (int i = 2; i <= n; i++) {
                    dp2[i] = dp2[i - 1] + dp2[i - 2];
            }
            return dp2[n];
        }
        //space optimization
        private static void fibonacci3(int n){
            int prev2 = 0;
            int prev = 1;

            for(int i=2; i<=n; i++){
                int curr= prev2+ prev;
                prev2 = prev;
                prev= curr ;
            }
            System.out.println(prev);
        }
        public static void main(String args[]) {
            int n=5;
            int dp[]=new int[n+1];
            Arrays.fill(dp,-1);
            System.out.println(fibonacci(n,dp));
            System.out.println(fibonacci2(n));
            fibonacci3(n);
    }
}
