package LeetCode.Top100;

/***
 *     寻找重复数，假设只有一个重复的数字，重复次数>=1
 *     不能更改原来的数组
 *     O(1)空间
 *     O(n^2)复杂度
 */

public class LeetCode287{
    /**
     * 暴力求解 O(n^2)
     */
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    duplicate = nums[i];
                    return duplicate;
                }
            }
        }
        return -1;
    }

    /***
     *  快慢指针找环路
     *   快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
        注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
        因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素, 
        即按照寻找链表环入口的思路来做
     */
    public int findDuplicate2(int[] nums) {
        int length = nums.length;
        if(length > 1){
            // 找到快慢指针相遇的地方
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(fast != slow){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            // 用一个新指针从头开始，知道和慢指针相遇
            fast = 0;
            while(fast != slow){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }



    public static void main(String[] args) {
        LeetCode287 le = new LeetCode287();
        int res = 0;
        int[] nums = new int[]{1,3,4,2,2};
        res = le.findDuplicate(nums);
        System.out.print(res);
    }
}