package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list,"",n,n);
        return list;
    }

    public void generateParenthesis(List<String> list,String str,int left,int right) {
        if(left > right) {
            //list.add(str);
            return;
        }
        if(left ==0 && right==0)
            list.add(str);
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
        LeetCode22 leetCode22 = new LeetCode22();
        List<String> list = leetCode22.generateParenthesis(3);
        System.out.println(list);
    }
}
