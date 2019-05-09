package LeetCode.Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author YANRUI
 */
public class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list,"",n,n);
        return list;
    }

    /**
     * @param list
     * @param str
     * @param left  表示剩余左括号的数目
     * @param right 表示剩余右括号的数目
     */
    public static void generateParenthesis(List<String> list,String str,int left,int right) {
        /*  退出条件 */
        if (left > right){
            return;
        }
        if (left == 0 && right == 0){
            list.add(str);
        }
        else {
            if (left > 0 ) {
                generateParenthesis(list, str + "(", left - 1, right);
            }
            if (right > 0 ) {
                generateParenthesis(list, str + ")", left, right - 1);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
