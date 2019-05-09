package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){  // 三指针
            int start = i+1;
            int end = nums.length-1;
            int cur = 0 - nums[i];
            while (start < end){
                if(nums[start] + nums[end] == cur){
                    temp.clear();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    list.add(temp);
                    start++;
                    end--;

                    //start去重
                    while (start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                    //end去重
                    while (start < end && nums[end+1] == nums[end]){
                        end--;
                    }
                }else if(nums[start] + nums[end] < cur){
                    start++;
                }else {
                    end--;
                }

            }
            //i去重
            // 去 i 重复
            while (i < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return list;
    }


    public static void main(String[] args){
        int[] nums  = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
