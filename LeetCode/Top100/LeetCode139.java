package LeetCode.Top100;

import java.util.List;

/**
 * 单词拆分
 * 1、完全背包
 * 2、动态规划
 */
public class LeetCode139 {
    /*
    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示：字典中的单词，能否组成s[0：i-1]
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1;i<=s.length();i++){
            for (String dict_str:wordDict){
                int len = dict_str.length();
                if(i>=len && dict_str.equals(s.substring(i-len,i)))
                    dp[i] = dp[i] || dp[i-len];
            }
        }
    }
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比背包问题
        int n = s.length();
        // dp[i] 表示 s 中以 i-1 结尾的字符串是否可以被wordDict拆分
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        /* 遍历 每个 字符之后作为中断点的情况*/
        for (int i = 1;i <= n;i++){
            // 找到中断位置之后，判断前面的一个字符串是否能拆分出在字典中出现过的串
            for (int j = 0;j < i;j++){
                // 一个子串，先判断整个子串是否在字典中，不在的话把子串看成两个串组成
                // 前面一段看dp是否可以被拆分，后一段在字典中找
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args){

    }
}
