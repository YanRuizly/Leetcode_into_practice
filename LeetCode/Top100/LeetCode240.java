package LeetCode.Top100;

/***
 *      搜素二维矩阵Ⅱ
 *      每行的元素从左到右升序排列。
 *      每列的元素从上到下升序排列。
 */

public class LeetCode240{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length-1;
        /* 从右上角开始查找 */
        int col = cols;
        int row = 0;
        while(row < rows && col >= 0){
                if(matrix[row][col] == target){
                    return true;
                }else if (matrix[row][col] < target) {
                    row++;
                } else {
                    col--;
                }
        }
        return false;
    }
}