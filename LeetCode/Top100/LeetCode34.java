package LeetCode.Top100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置   O(log n) 级别
 * @author YANRUI
 */
public class LeetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int findex=0,lindex=0;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (target == nums[mid]){
                findex = mid;
                lindex = mid;
                while (findex-1 >= low && target == nums[findex-1]){
                    findex--;
                }
                while (lindex+1 <= high && target == nums[lindex+1]){
                    lindex++;
                }
                return new int[]{findex,lindex};
            }else if (target > nums[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] out = searchRange(new int[]{5,7,7,8,8,10},6);
        System.out.println(out[0]);
        System.out.println(out[1]);
    }
}
