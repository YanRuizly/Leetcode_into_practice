package LeetCode.Top100;

/***
 *     完全平方数
 */

public class LeetCode279{
    public int numSquares(int n) {
        //利用动态规划 定义长度为n+1的数组 对应索引所对应的数装最少的步数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = i; /* i个1组合 */
            for(int j = 1; i - j*j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}