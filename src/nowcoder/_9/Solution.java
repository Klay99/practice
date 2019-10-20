package nowcoder._9;

import java.util.Stack;

/**
 * @program: practice
 * @description: 用两个栈实现队列
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
