package LeetCode.Top100;

/**
 *  编辑距离 动态规划
 */
public class LeetCode72 {
    /**
     * @param word1
     * @param word2
     * @return
     * DP[i][j]，表示word1的i个字母与word2的第j个字母相同 需要的操作步骤数
     * word1插入一个字符 DP[i-1][j] + 1 -> DP[i][j]
     * word1删除一个字符 = word2插入一个字符 DP[i][j-1] + 1 -> DP[i][j]
     * word1替换一个字符 = word1 word2 都替换一个字符 DP[i-1][j-1] + 1 -> DP[i][j]
     *  DP[i][j]  A、 word1 的 i 个字母 与 word2 的 第 j 个字母 相同
     *  DP[i][j] =  DP[i-1][j-1]  #不操作
     *  B、不相同,需要进行 插入 删除 或者 替换操作
     *  DP[i][j]  =  min(DP[i-1][j] + 1,DP[i][j-1] + 1,DP[i-1][j-1]+1)
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        /* 从 1 到len */
        int [][] dp = new int[len1+1][len2+1];
        // 从有到无 删除
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        //从无到有 添加
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i<=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Integer.min(Integer.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
