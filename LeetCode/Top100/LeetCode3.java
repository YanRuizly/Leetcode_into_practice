package LeetCode.Top100;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while ( i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(i++);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s =  "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
