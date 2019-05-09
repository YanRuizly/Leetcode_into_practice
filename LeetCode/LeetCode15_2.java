package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15_2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    List<Integer> temp = new ArrayList<>();
                    if(nums[i] + nums[j] + nums[k] == 0){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if(!list.contains(temp))
                            list.add(temp);
                    }
                }
            }
        }
        System.out.println(list);
        return list;
    }
    public static void main(String[] args){
        int[] nums  = {-1, 0, 1, 2, -1, -4};
     //   List<Integer> list1 = new ArrayList<Integer>(){{add(1); add(0); add(-1);}};
     //   List<Integer> list2 = new ArrayList<Integer>(){{add(-1); add(0); add(1);}};
     //   System.out.println(judgeEqual(list1,list2));
        threeSum(nums);
    }
}
