package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0 || strs == null)
            return "";
        int maxLen = 0;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o1.length()-o2.length())>=0)?1:-1;
            }
        });
        boolean flag = true;
        for(int i=0;i<strs[0].length();i++){
            char temp = strs[0].charAt(i);
          //  System.out.println(temp);
            for(int j=1;j<strs.length;j++){ // 从第二个元元素开始
            //    System.out.println(strs[j].charAt(i));
                if (strs[j].charAt(i) != temp){
                    flag = false;
                   // return strs[0].substring(0,maxLen);
                    break;
                }
            }
            if(flag == true){
                maxLen++;
               // System.out.println(maxLen);
            }else {
                if(maxLen == 0)
                    return "";
                break;
            }
        }
        /*
        boolean flag = true;
        for(int i=0;i<strs.length;i++){ // {"flower","flow","flight"}
            for(int j=0;j<strs[i].length();j++){  // {"flower"}

            }
        }
        */
        return strs[0].substring(0,maxLen);
    }


    public static void main(String[] args){
        String[]  s = {"flower","flow","flight"};
        String[]  s2 =  {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(s));
        System.out.println(longestCommonPrefix(s2));
    }
}
