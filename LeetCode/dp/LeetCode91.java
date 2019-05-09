package LeetCode.dp;

public class LeetCode91 {
    public static int numDecodings(String s) {
        if (s.charAt(0) == '0'|| s == null ) return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        //初始状态
        //0没有解码
        dp[0] = isValid(s.charAt(0)) ? 1 : 0;
        //20的情况只有一种解码
        dp[1] = isValid(s.charAt(0),s.charAt(1)) ? 2 : 1;
        for(int i = 2; i < s.length() ; i++){
            if(isValid(s.charAt(i)) && isValid(s.charAt(i-1),s.charAt(i))){
                dp[i] = dp[i-2] + dp[i-1];
            }
            else if(isValid(s.charAt(i))){
                dp[i] = dp[i-1];
            }
            else if (!isValid(s.charAt(i-1),s.charAt(i)) && !isValid(s.charAt(i))) {
                return 0;
            }
        }
        System.out.println(dp[1]);
        return dp[s.length()-1];
    }

    public static Boolean isValid(char a){
        if(a == '0'){
            return false;
        }else return true;
    }

    public static Boolean isValid(char a, char b){
        int sum = (a-'0') * 10 + (b-'0');
        if((sum > 10 && sum <= 26)){
            if(sum != 20)
                return true;
            else return false;
        }else return false;
    }

    public static void main(String[] args){
       // System.out.println(numDecodings("226"));
//        System.out.println(numDecodings("12"));
//        System.out.println(numDecodings("2222"));
        System.out.println(numDecodings("110"));
    }
}
