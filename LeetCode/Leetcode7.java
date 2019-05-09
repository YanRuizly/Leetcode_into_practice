package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode7 {
    public static int reverse(int x) {
        if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE)
            return 0;
        String s = String.valueOf(x);
        char[] strArray;
        boolean flag = true;
        if(s.contains("-")){
            strArray = s.substring(1,s.length()).toCharArray();
            flag = false;
        }
        else {
            strArray = s.toCharArray();
        }
        int start = 0;
        int end = strArray.length-1;
        while (start <= end){
            char temp = strArray[end];
            strArray[end] = strArray[start];
            strArray[start] = temp;
            start++;
            end--;
        }
        int out = 0;
        try{
            out = (flag)?Integer.valueOf(new String(strArray)):(-1)*Integer.valueOf(new String(strArray));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
        return out;
    }

    public static void main(String[] args){
        int x = -121412511;
        int y = 12312412;
        System.out.println(reverse(x));
     //   System.out.println(reverse(x));
        System.out.println(reverse(y));
    }
}
