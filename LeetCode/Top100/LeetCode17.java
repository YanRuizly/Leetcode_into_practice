package LeetCode.Top100;

import java.util.ArrayList;
import java.util.List;

/**
 *  回溯法
 */
public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty())
            return list;
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(list,"",0,digits,letters);
        return list;
    }

    public static void backtrack(List<String> list, String s,int index, String digits,String[] letters){
        if (index == digits.length()){
            if (s.length() != 0 )
                list.add(s);
            return ;
        }
        String temp = letters[digits.charAt(index) - '0'];
        for (int i=0;i<temp.length();i++){
            String next = s + temp.charAt(i);
            /* 进入下一层 **/
            backtrack(list,next,index+1,digits,letters);
        }
    }


    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
