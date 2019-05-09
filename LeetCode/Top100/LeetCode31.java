package LeetCode.Top100;

/**
 * 下一个排列
 * @author YANRUI
 */
public class LeetCode31 {
    public static void nextPermutation(int[] nums) {
        int size = nums.length;
        int i = size - 2;
        /*
        *  递减的序列不存在下一个排列
        *  找到那个特殊的值
        * */
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0 ){
            int j = size -1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            /*
            *  交换那个最接近的值
            * */
            swap(nums,i,j);
        }
        revise(nums,i+1,size-1);
    }

    public static void revise(int[] nums,int start,int end){
        int i = start;
        int j = end;
        while (i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){
        int[] nums = {1,1};
        nextPermutation(nums);
        System.out.println(nums);
    }
}
