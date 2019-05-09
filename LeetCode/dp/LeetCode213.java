package LeetCode.dp;

public class LeetCode213 {
    public static int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[1] = nums[0]; //从第1个房屋开始偷
        dp2[1] = nums[1]; //从第2个房屋开始偷
        //1-(n-1)
        for(int i=2;i<nums.length;i++) {
            dp1[i] = Math.max( dp1[i-2]+nums[i-1],dp1[i-1] );
        }
        //2-n
        for(int i=2;i<nums.length-1;i++){
            dp2[i] = Math.max( dp2[i-2]+nums[i], dp2[i-1]);
        }
        return Math.max( dp1[nums.length-1], dp2[nums.length-1] );
    }

    public static void main(String[] args){
        System.out.println(rob(new int[]{1,2,3,1}));
    }

}
