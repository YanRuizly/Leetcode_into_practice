package LeetCode.Top100;

/**
 *  求众数
 */
public class LeetCode169 {
    public static int majorityElement(int[] nums){
        int count = 0; //计算当前的数字出现的次数
        int mj = 0; //当前判断的元素
        for (int i = 0; i < nums.length ; i++){
            if(count == 0){ // 当次数为0时，则换下一个判断元素
                mj = nums[i];
                count = 1;
            }else if (nums[i] == mj){
                count++;
            }else {
                count--;
            }
        }
        return mj;
    }
}
