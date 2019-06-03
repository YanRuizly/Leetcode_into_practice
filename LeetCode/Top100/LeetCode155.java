package LeetCode.Top100;

import java.util.Stack;

/**
 *  最小栈
 */
public class LeetCode155 {
    /**
     *  一个栈来实现
     */
    class MinStack {
        Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(x);
                stack.push(x);
            }else {
                int tmp = stack.peek();
                stack.push(x);
                if (tmp < x){
                    stack.push(tmp);
                }else {
                    stack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size()-2);
        }

        /**
         * 常数时间内检索到最小元素
         * @return
         */
        public int getMin() {
            return stack.peek();
        }
    }


    /**
     *  两个栈来实现
     */
    class MinStack2 {
        Stack<Integer> data;
        Stack<Integer> minstack;
        /** initialize your data structure here. */
        public MinStack2() {
            data = new Stack<Integer>();
            minstack = new Stack<Integer>();
        }

        public void push(int x) {
            data.push(x);
            if (minstack.empty() || x <= minstack.peek()){
                minstack.push(x);
            }
        }

        public void pop() {
            if(data.peek() == minstack.peek()){
                minstack.pop();
            }
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        /**
         * 常数时间内检索到最小元素
         * @return
         */
        public int getMin() {
            return minstack.peek();
        }
    }

    public static void main(String[] args){

    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
