package LeetCode.Top100;


/**
 *   除自身以外数组的乘积
 *   请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class LeetCode238 {
    //[a，b，c，d，e]
    //从左乘一遍得到[1, a, ab, abc, abcd]
    //从右乘一遍得到[bcde,acde,abde,abce,abcd]
    public int[] productExceptSelf(int[] nums) {
        //  乘积 = 当前数左边的乘积 * 当前数右边的乘积
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            // 此时数组存储的是除去当前元素左边的元素乘积
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = res.length -1 ; i >= 0; i--) {
            res[i] *= k;    // k为该数右边的乘积
            k *= nums[i];   // 此时数组等于左边的 * 该数友边的
        }
        return res;
    }
}