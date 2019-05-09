package LeetCode.Top100;

import java.util.HashMap;
import java.util.Stack;

/**
 *  有效的括号，应该用stack来做
 * @author YANRU
 */
public class LeetCode20 {
    public static boolean isValid(String s) {
        if (s.isEmpty())
            return false;
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (map.keySet().contains(s.charAt(i))){ //包含左括号
                stack.push(s.charAt(i));
            }else if (map.values().contains(s.charAt(i))){ //值包含右括号
                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)){
                    return false;
                }else {
                    stack.pop();
                }
            }
           // System.out.println(stack);
        }
        return true;
    }

    public static void main(String[] args){
        String s = "{[()]}";
        String s1 = "{}[()]}";
        String s2 = "{[)]}";
        String s3 = "([)]";
        String s4 = "";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }
}
