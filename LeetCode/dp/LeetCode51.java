package LeetCode.dp;

public class LeetCode51 {
    public static int maxSubArray(int[] nums) {
        //dp[i] = max(dp[i-1]+a[i],a[i])
        int dp = 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(dp < 0)
                dp = nums[i];
            else dp = dp + nums[i];
            if(dp > max)
                max = dp;
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
