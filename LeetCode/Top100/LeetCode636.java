package LeetCode.Top100;

import java.util.List;
import java.util.Stack;

/**
 *  函数的独占时间
 *  @author YANRUI
 *  输入:
 *  n = 2
 *  logs =
 *  ["0:start:0",
 *  "1:start:2",
 *  "1:end:5",
 *  "0:end:6"]
 *  输出:[3, 4]
 *
 */
public class LeetCode636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs){
            String[] str = log.split(":");
            int id = Integer.valueOf(str[0]);
            int timestamp = Integer.valueOf(str[2]);
            String op = str[1];
            if (op.equals("start")){
                stack.push(new int[]{id,timestamp});
            }else {
                int[] pop = stack.pop();
                int runtime = timestamp - pop[1] + 1; //计算栈顶元素
                result[id] += runtime;
                /*  如果此时栈还不为空，则说明当前栈顶函数里面嵌套了当前函数id，需要减去当前函数运行的时间 */
                if (!stack.isEmpty()){
                    int[] top = stack.peek();
                    result[top[0]] -= runtime;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){

    }

}
