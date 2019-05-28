package LeetCode.Top100;


import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  子集
 */
public class LeetCode78 {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        Solution(nums,0,lists,list);
        return lists;
    }

    public static void Solution(int[] nums,int start,List<List<Integer>> lists,List<Integer> list){
        lists.add(new ArrayList<>(list));
        for (int i=start;i<nums.length;i++){
            list.add(nums[i]);
            Solution(nums,i+1,lists,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }
}