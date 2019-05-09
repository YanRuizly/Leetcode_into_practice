package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums,0,nums.length-1,lists);
        return lists;
    }

    public static void permute(int[] nums,int start,int end,List<List<Integer>> lists) {
        if(start >= end){
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<nums.length;i++)
                temp.add(nums[i]);
            lists.add(temp);
        }else {
            for(int i=start;i<=end;i++){
                swap(nums,i,start);
                permute(nums,start+1,end,lists);
                swap(nums,i,start);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        List<List<Integer>> lists = new ArrayList<>();
        int[] nums = {1,2,3,4};
        lists = permute(nums);
        System.out.println(lists);
    }
}
