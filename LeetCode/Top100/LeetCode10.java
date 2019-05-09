package LeetCode.Top100;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean dp[][] = new boolean[slen][plen];
        for (int i=0;i<slen;i++){
            for (int j=0;j<plen;j++){
                dp[i][j] = false;
            }
        }
        return true;
    }

    /** Some examples:
        isMatch("aa","a") → false
        isMatch("aa","aa") → true
        isMatch("aaa","aa") → false
        isMatch("aa", "a*") → true
        isMatch("aa", ".*") → true
        isMatch("ab", ".*") → true
        isMatch("aab", "c*a*b") → true
    **/
    public static void main(String[] args){

    }
}