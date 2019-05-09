package LeetCode.Top100;

/**
 * 搜索旋转排序数组   O(log n)
 * @author YANRUI
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length <=0 ){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (low < high){
            mid = low + (high - low) / 2;
            if (target == nums[mid]){
                return mid;
            }else if (nums[low] <= nums[mid]){
                if (target <= nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else if (nums[mid] <= nums[high]){
                if (target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}