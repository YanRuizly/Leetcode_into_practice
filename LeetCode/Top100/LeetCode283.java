package LeetCode.Top100;

/***
 *     移动零
 *     双指针法
 */

public class LeetCode283{
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int p=0,q=0;
        /***
         * p 每次找到下一个为0的数字
         * q 每次找到下一个不为0的数字
         * q < p 
         *  */
        while(p  != nums.length-1 && q != nums.length-1){
            /* 找到下一个0 */
            while(nums[q] != 0  && q != nums.length-1){
                q++;
            }
            while((nums[p] == 0 || p < q) && p != nums.length-1){
                p++;
            }
            /* 交换二者 */
            swap(nums,p,q);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        LeetCode283 le= new LeetCode283();
        //int[] nums = new int[]{0,1,0,3,12};
        int[] nums = new int[]{1,0,0,23,0,1,0,3,12,000};
        //int[] nums = new int[]{0};
        le.moveZeroes(nums);
        for (int num:nums){
            System.out.print(num);
        }
    }
}