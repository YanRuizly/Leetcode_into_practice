package LeetCode.stack;

import java.util.Stack;

public class LeetCode394 {
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
            }else if (str[i] ==  '['){
                stringStack.push(res);
                countStack.push(num);
                res = "";
                num = 0;
                i++;
            }else if (str[i] == ']'){
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

    public static void main(String[] args){
        String s = "2[abc3[cd]4[e]]";
        String out = decodeString(decodeString(s));
        String s2 = "2[abc3[c2[a]d]4[e]]";
        String out2 = decodeString(decodeString(s2));
        System.out.println(out);
        System.out.println(out2);
    }
}
