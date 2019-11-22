package nowcoder._31;

import java.util.Stack;

/**
 * @program: practice
 * @description: 栈的压入、弹出序列
 *               输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *               假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 *               序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *               （注意：这两个序列的长度是相等的）
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    Stack<Integer> s = new Stack<>();

    // 如果弹出的数刚好为栈顶元素，直接弹出；
    // 如果弹出的数不在栈顶，把还没入栈的元素压入栈，直到栈顶成为要弹出的元素
    // 如果所有数都入栈后仍没有要弹出的数，则该序列不可能是弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int popIndex = 0; // 弹出序列索引
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]); // 入栈
            // 当栈不为空且栈顶元素的值为当前弹出序列的值时，弹出栈顶元素，弹出序列索引后移
            while (!s.empty() && s.peek() == popA[popIndex]) {
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }

}
