package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine2 {
    public static List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solution2(nums,0,lists,list);
        return lists;
    }

    public static void solution2(int[] nums ,int start ,List<List<Integer>> lists, List<Integer> list ){
        //       if(start == nums.length-1)
     //   if (list.size() == 3)
            lists.add(new ArrayList<>(list));
        for (int i= start;i<nums.length;i++){
            list.add(nums[i]);
            solution2(nums,i+1,lists,list);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        //  solution(nums);
        List<List<Integer>> lists = solution(nums);
        System.out.println(lists);
    }
}