package LeetCode.Top100;

import static java.lang.System.getenv;
import static java.lang.System.in;
import static java.lang.System.out;

public class LeetCode5 {

    /**
     *  找到最长的回文字符串
     * @param s
     * @return {@link String}
     */

    /*
       * 1、常规暴力解法   超时O(n^2logn)
       * */
    public static String longestPalindrome(String s) {
        String maxStr = "";
        if (s == null || s.length() <= 0) {
            return maxStr;
        }
        int max = Integer.MIN_VALUE;
        int len = s.length();
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                String tmp = s.substring(i,j+1);
                if (judgeHw(tmp) && tmp.length() >max){
                    max = tmp.length();
                    maxStr = tmp;
                }
            }
        }
        return maxStr;
    }

    public static Boolean judgeHw(String s){
        int start = 0;
        int end = s.length()-1;
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }



    /*
   * 2、动态规划 dp[i][j]为回文 那么 dp[i-1][j-1]必定为回文
   * */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        int max = Integer.MIN_VALUE;
        int len = s.length();
        int left = 0;
        boolean dp[][] = new boolean[len][len];
        char[] str = s.toCharArray();
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(i-j<2) {
                    dp[i][j] = (str[i] == str[j]);
                }
                else {
                    dp[i][j] = (str[i] == str[j] && dp[i - 1][j + 1] );
                }
                if(dp[i][j]&&max<i-j+1)
                {
                    max=i-j+1;
                    left=j;
                }
            }
        }
        return s.substring(left,left+max);
    }


    public static void main(String[] args){
        System.out.println(longestPalindrome2("abcdbbfcba"));
    }
}
