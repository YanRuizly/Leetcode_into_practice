package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int start, end, curSum, t;
        int min = Integer.MAX_VALUE;
        int sub=0;
        int abssub=0;
        int sum=0;
        // 外层循环先确定一个数，之后双指针扫描数组右边剩下的数，找到两个和为已确定数的相反数的两个数
        for (int i = 0; i < size - 2; i++) {
            start = i + 1;
            end = size - 1;
//            curSum = target - nums[i];
            // 双指针扫描是否存在两个数等于 -nums[i]
            while (start < end) {
                sub = nums[start] + nums[end] + nums[i] - target;
                abssub = Math.abs(sub);
                // 找到一个解
                if(min > abssub){
                    min = abssub;
                    sum = nums[start] + nums[end] + nums[i] ;
                }
                if (sub == 0) {
                   return target;
                } else if (sub < 0) {
                    start++;
                } else {
                    end--;
                }
            }
            // 去 i 重复
            while (i < size - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] nums  = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
