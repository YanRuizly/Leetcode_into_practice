package LeetCode.stack;

import java.util.Stack;

public class LeetCode394_2 {
    public static String decodeString(String s){
        char[] str = s.toCharArray();
        int i = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int num = 0;
        String res = "";
        while (i<s.length()){
            if (Character.isDigit(str[i])){
                while (Character.isDigit(str[i])){
                    num = num*10 + (str[i]-'0');
                    i++;
                }
            }else if(Character.isLetter(str[i])){
                res += str[i];
                i++;
            }else if (str[i] ==  '[' || str[i] ==  '{' || str[i] ==  '('){
                stringStack.push(res);
                countStack.push(num);
                res = "";
                num = 0;
                i++;
            }else if (str[i] == ']' || str[i] ==  '}' || str[i] ==  ')'){
                int con = countStack.pop();
                String temp = res; //保存当前的cd
                for (int j=0;j<con-1;j++){
                    res += temp;  // 3[cd]  ->  cdcdcd
                }
                res = stringStack.peek() + res;
                stringStack.pop();
                i++;
            }
        }
        return res;
    }

    public static String revise(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] chars = s.toCharArray();
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }


    public static void main(String[] args){
        String s1 = "2{abc3[c2(a)d]4[e]}";
        String out1 = decodeString(decodeString(s1));
        System.out.println(revise(out1));
        String s2 = "abc3(A)";
        String out2 = decodeString(decodeString(s2));
        System.out.println(revise(out2));
    }
}
