package LeetCode.Top100;


/**
*   打家劫舍
*   dp[i] 表示从第0到第i户人家最多能偷到多少财务
*/

public class LeetCode198{
    public int rob(int[] nums) {
        int n = nums.length;
        if( n <= 1){
            return n == 0 ? 0 : nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);           
        }
        return dp[n];
    }
}