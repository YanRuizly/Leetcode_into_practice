package LeetCode.Top100;

public class LeetCode11 {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = Integer.MIN_VALUE;
        while (start < end){
            int ht = Math.min(height[start],height[end]);
            if (ht * (end - start) > max) {
                max = ht * (end - start);
            }
            if (height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int output = maxArea(height);
        System.out.println(output);
    }
}
