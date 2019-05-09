package LeetCode.dp;

public class NumArray {
    private int num[];
    public NumArray(int[] nums) {
        this.num = nums;
    }

    public int sumRange(int i, int j) {
        //做减法 f[j]表示0到j的和
        int sum=0;
        for(int k=i;k<=j;k++)
            sum = sum+num[k];
        return sum;
    }

    public static void main(String[] args){
        int nums[] = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.num);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
    }

}
