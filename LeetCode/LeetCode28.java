package LeetCode;

public class LeetCode28 {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
          //  System.out.println(i);
          //  System.out.println(haystack.substring(i,i+needle.length()));
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        strStr("hello", "ll");
    }
}
