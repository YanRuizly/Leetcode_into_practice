package LeetCode.Top100;

/***
 *     回文子串
 *     给定一个字符串，计算这个字符串有多少个回文子串
 *     1、暴力求解 超时
 *     2、中心扩展法
 *     3、动态规划
 *     4、马拉车
 */

public class LeetCode647{
    /***
     * DP
     * @param s
     * @return
     */
    public int countSubstrings(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(j) == s.charAt(i) &&
                (i-j <= 2 || dp[i-1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }


     // 中心扩展法
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            /* 奇数长度 */
            sum += expandAroundCenter(i, i, s);
            /* 偶数长度 */
            sum += expandAroundCenter(i, i + 1, s);
        }
        return sum;
    }
    
    private int expandAroundCenter(int left, int right, String s) {
        int l = left, r = right, count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}