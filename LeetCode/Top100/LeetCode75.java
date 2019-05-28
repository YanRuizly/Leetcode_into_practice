package LeetCode.Top100;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0;i <= right; i++){
            if (nums[i] == 0){
                swap(nums,left,i);
                left++;
            }else if(nums[i] == 2){
                swap(nums,right,i);
                right--;
                // 交换过来的不知道是什么，要重新判断
                i-- ;
            }
        }
    }

    public void swap(int[] nums,int start,int i){
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
