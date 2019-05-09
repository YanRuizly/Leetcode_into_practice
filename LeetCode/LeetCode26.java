package LeetCode;

import java.util.Arrays;

public class LeetCode26 {
    public static int removeDuplicates(int[] nums) {
        int ans=0;
        long prev=Integer.MIN_VALUE-1;
        for(int i=0,j=0;i<nums.length;){
            if(prev==nums[i]){
                i++;
                continue;
            }
            else{
                nums[j]=nums[i];
                prev=nums[i];
                j++;
                i++;
                ans++;
            }
        }
        return ans;
    }

    public static int removeDuplicates2(int[] nums) {
        int pre = nums[0];
        int i=0,j=0;
        int dec = 0;
        for(i=1,j=1;i<nums.length;){
            if(nums[i] == pre){  // 找到第一个不等的
                i++;
                continue;
            }else {
                nums[j] = nums[i];
                pre = nums[i];
                i++;
                j++;
                dec++;
            }
        }
        return dec+1;
    }


    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
       // System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
}