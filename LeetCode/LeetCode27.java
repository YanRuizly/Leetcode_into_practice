package LeetCode;

import java.util.Arrays;

public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        int i,j;
        for(i=0,j=0;i<nums.length;){
            if (nums[i] == val){
                i++;
                continue;
            }
            if(i<nums.length) {
                nums[j] = nums[i];
                i++;
                j++;
            }else {
                return j;
            }
        }
        return j;
    }

    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        // System.out.println(removeDuplicates(nums));
        System.out.println(removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }
}
