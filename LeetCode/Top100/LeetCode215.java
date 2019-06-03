package LeetCode.Top100;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
*  数组中的第K个最大元素
*/

public class LeetCode215{
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];   
    }

    /*
    *   小顶堆
    * */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int val : nums){
            queue.add(val);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    /***
     * 快速选择变形
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        int begin = 0;
        int end = nums.length-1;
        int pos = 0;
        while(begin <= end){
            pos = partition(nums, begin, end);
            if(pos == k-1){
                return nums[pos];
            }else if(pos < k-1){
                begin = pos+1;
            }else{
                end = pos-1;
            }
        }
        return -1;
    }

    public int partition(int[]nums,int begin,int end){
        int key = nums[end];
        int last = end;
        while (begin < end)
        {
            //1.左边找到小于基准值的元素
            while ((begin < end) && (nums[begin] >= key))
                begin++;
            //2.右边找到大于基准值的元素
            while ((begin < end) && (nums[end] <= key))
                end--;
            //3.交换两个值
            swap(nums,begin, end);
        }
        //两个下标走到一块的时候，把基准值交换过来
        swap(nums,begin, last);
        //返回基准值的位置
        return begin;
    }


    private int Partition(int[] arrays,int i,int j){
        int start = i;
        int end = j;
        int temp = arrays[start];
        while (start < end){
            while (start < end && arrays[end] >= temp){
                end--;
            }
            arrays[start]  = arrays[end];
            while (start < end && arrays[start] <= temp){
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = temp;
        return start;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        LeetCode215 le = new LeetCode215();
        int nums[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int ret = le.findKthLargest3(nums,k);
        System.out.println(ret);
    }
}