package LeetCode;

public class leetcode5 {
    public static boolean judgeHuiwen(String s,int start,int end){
        char[] strArray = s.toCharArray();
        int middle = (end -start)/2;
        for (int i=0;i<=middle;i++){
            if(strArray[i] != strArray[end-i]){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if(s.length() <= 0 || s==null)
            return null;
        int maxLen = Integer.MIN_VALUE;
        String LongestStr = null;
        for (int i=0;i<s.length()-1;i++){
            for (int j=i+1;j<s.length();j++){
                String temp  = s.substring(i,j+1);
              //  System.out.println(temp);
                if(judgeHuiwen(temp,0,temp.length()-1) && temp.length() > maxLen ){
                    maxLen = temp.length();
                    LongestStr = temp;
                   // System.out.println(maxLen);
                  //  System.out.println(LongestStr);
                }
            }
        }
        return  LongestStr;
    }


    public static void main(String[] args){
        String s = "babad";
        String s2 = "aba";
        String s3 = "aaaaabbbbbbccccccbbbbbb";
     //   System.out.println(judgeHuiwen(s,0,s.length()-1));
     //   System.out.println(judgeHuiwen(s,0,s2.length()-1));
     //   System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s3));
        System.out.println("");
        System.out.println(judgeHuiwen("bbccccccbb",0,9));
        System.out.println(s2.substring(0,1));
    }
}