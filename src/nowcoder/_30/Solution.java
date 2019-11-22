package nowcoder._30;

import java.util.Stack;

/**
 * @program: practice
 * @description: 包含min函数的栈
 *               定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>(); // 该栈用于存储上一个入栈(stack1)的最小值
    int min = top();

    public void push(int node) {
        if (node < min) { // 如果入栈值小于当前最小值
            stack2.push(min); // stack2存入上一个最小值
            min = node; // 更新最小值
        }
        stack1.push(node);
    }

    public void pop() {
        int temp = stack1.pop();
        if (temp == min) {
            min = stack2.pop();
        }
    }

    public int top() {
        return stack1.size() == 0 ? Integer.MAX_VALUE : stack1.peek();
    }

    public int min() {
        return min;
    }

}
