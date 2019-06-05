package LeetCode.Top100;

/***
 *      最长上升子序列(不必连续)
 *      [10,9,2,5,3,7,101,18] ——> [2,3,7,101] 4
 */

public class LeetCode300{
    /* 超时 */
    public int lengthOfLIS(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int maxLen = 0;
        int len = 0;
        for(int i=0;i<nums.length;){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j-1] < nums[j]){
                    len++;
                }else{
                    maxLen = Math.max(maxLen, len);
                    i = j;
                    len = 0;
                    break;
                }
            }
        }
        return maxLen;
    }


    /**
     *  动态规划思路
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        // 自己一定是一个子序列
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
            // 这个值就得不到更新
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}