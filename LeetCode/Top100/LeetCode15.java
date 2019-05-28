package LeetCode.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public static void sort(int[] arrays,int start,int end){
        if (start < end) {
            int index = partition(arrays, start, end);
            sort(arrays, start,index-1);
            sort(arrays,index+1,end);
        }
    }

    public static int partition(int[] arrays,int start,int end){
        int pviot = arrays[start];
        int i = start;
        int j = end;
        while (i < j){
            while (i < j && arrays[j] >= pviot){
                j--;
            }
            arrays[i] = arrays[j];
            while (i < j && arrays[i] <= pviot){
                i++;
            }
            arrays[j] = arrays[i];
        }
        arrays[i] = pviot;
        return i;
    }


    /**
     *  双指针
     * @param nums
     * @return {@link List<List<Integer>>}
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int start, end, curSum, t;
        // 外层循环先确定一个数，之后双指针扫描数组右边剩下的数，找到两个和为已确定数的相反数的两个数
        for (int i = 0; i < size - 2; i++) {
            start = i + 1;
            end = size - 1;
            curSum = 0 - nums[i];
            // 双指针扫描是否存在两个数等于 -nums[i]
            while (start < end) {
                t = nums[start] + nums[end];
                // 找到一个解
                if (t == curSum) {
                    List<Integer> save = new ArrayList<>();
                    //save.clear();
                    save.add(nums[i]);
                    save.add(nums[start]);
                    save.add(nums[end]);
                    //  System.out.println(save);
                    list.add(save);
                    // System.out.println(list);
                    start++;
                    end--;
                    // 去 start 重复
                    while (start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                    // 去 end 重复
                    while (start < end && nums[end] == nums[end+1]) {
                        end--;
                    }
                } else if (t < curSum) {
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
        return list;
    }



    public static void main(String[] args){
        int[] arrays = {1,-1,-1,0};
        sort(arrays,0,arrays.length-1);
        System.out.println(threeSum(arrays));
    }
}
