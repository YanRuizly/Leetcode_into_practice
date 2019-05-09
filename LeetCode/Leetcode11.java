package LeetCode;

public class Leetcode11 {
    public static int maxArea(int[] height) {
         if(height.length <= 0)
             return 0;
         int start = 0;
         int end = height.length-1;
         int max = 0;
         while (start<=end){
             int temp = Math.min(height[start],height[end])* (end-start);
             if(temp > max)
                 max = temp;
             if(height[start] < height[end]){
                 start++;
             }else {
                 end--;
             }
         }
         return max;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
