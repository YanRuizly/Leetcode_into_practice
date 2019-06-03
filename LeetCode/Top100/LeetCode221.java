package LeetCode.Top100;

/**
 *  最大正方形
 */
public class LeetCode221 {
    /****
     * dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长
     * dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
     * 左边，左上角，上边 不能有0，取三者交集
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m < 1){
            return 0;
        }
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
 