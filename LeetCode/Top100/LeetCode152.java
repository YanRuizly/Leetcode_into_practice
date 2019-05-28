package LeetCode.Top100;

/**
 *  乘积最大子序列
 *  dp
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int retVal;
        retVal = max[0] = min[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            max[i] = Math.max(nums[i],Math.max(nums[i] * max[i-1],nums[i] * min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            retVal = Math.max(retVal,max[i]);
        }
        return retVal;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max,min,retVal,preMax,preMin;
        retVal = max = min = nums[0];
        for (int i=1;i<nums.length;i++){
            preMax = max;
            preMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            min = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
            retVal = Math.max(retVal, max);
        }
        return retVal;
    }

    public static void main(String[] args){

    }
}
