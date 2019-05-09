package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class LeetCode312_2 {
    private static int ans = 0;
    public static int maxCoins(List<Integer> nums){
//        int ans = 0;
        helper(nums,0);
        return ans;
    }

    public static void helper(List<Integer> nums, int coins){
        //boundary
        if(nums.size() == 0){
            ans = Math.max(ans,coins);
            return;
        }
        //search
        for(int i=0;i<nums.size();i++){
            int temp = nums.get(i);
            int delda = nums.get(i) * (i-1 < 0 ? 1 : nums.get(i-1)) * (i+1 > nums.size()-1 ? 1 : nums.get(i+1));
            nums.remove(i); // 删除第i个元素
            helper(nums,coins+delda);
            nums.add(i,temp);
        }
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(8);
        System.out.println(list);
        System.out.println(maxCoins(list));
    }
}