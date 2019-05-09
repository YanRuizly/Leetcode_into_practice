package LeetCode;

import java.util.Stack;

public class LeetCode9 {
    public static boolean isPalindrome(int x) {
       if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        char[] ch = String.valueOf(x).toCharArray();
        for(int i=0;i<ch.length;i++){
            stack.add((int)ch[i]);
        }
        for(int j=0;j<ch.length;j++){
            if(ch[j] != stack.pop()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(-12321));
    }
}
