package LeetCode.Top100;

import java.util.HashMap;
import java.util.Stack;

/**
 * 最长的有效括号
 * @author YANRUI
 */
public class LeetCode32 {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int max = 0;
        for (int i=0;i<len;i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }


    /**
     * 解法二：
     * 动态规划四步走
     * - 确认原问题与子问题: 原问题为求s中最长有效括号，子问题可拆解为前i个中最长有效括号。
     * - 确认状态: 本题的动态规划状态单一，第i个状态即为前i个字符串中最长括号数。
     * - 确认边界状态的值: dp[1]=0，从1开始
     * - 确定状态转移方程: 对于(())适用dp[i] = dp[i - 1] + 2;对于()()适用 dp[i] += dp[i - dp[i]];
     * 两者结合一起判断，防止()()(())这种情况
     * <p>
     * 执行用时 : 4 ms, 在Longest Valid Parentheses的Java提交中击败了98.68% 的用户
     * 内存消耗 : 37.6 MB, 在Longest Valid Parentheses的Java提交中击败了82.01% 的用户
     *
     * @param s
     * @return
     */
    public static int longestValidParenthesesDP(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxlen = 0;
        //当前对于的最大的连续括号数
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                }
                if (i - dp[i] >= 0 && dp[i - dp[i]] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                maxlen = dp[i] > maxlen ? dp[i] : maxlen;
            }
        }
        return maxlen;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("(()))"));
        System.out.println(longestValidParenthesesDP("()()()((()))"));
    }
}
