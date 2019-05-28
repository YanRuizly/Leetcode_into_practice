package LeetCode.Top100;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  最长连续序列
 *  要求时间复杂度为O（n）
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums){
            set.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (set.remove(num)){
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (set.remove(current - 1)){
                    current--;
                }
                currentLongest += (num-current);
                // 向当前元素的右边搜素,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while (set.remove(current + 1)){
                    current++;
                }
                currentLongest += (current-num);
                longest = Math.max(longest,currentLongest);
            }
        }
        return longest;
    }
}
