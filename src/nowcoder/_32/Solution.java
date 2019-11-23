package nowcoder._32;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: practice
 * @description: 从上到下打印二叉树
 *               从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 节点按照从上往下从左往右的顺序入队，优先入队的元素优先打印
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(); // 用于存储打印结果
        ArrayList<TreeNode> queue = new ArrayList<>(); // 模拟队列，存储节点

        if (root != null) queue.add(root);

        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0); // 出队（第一个节点）
            // 入队，先左后右
            if (temp.left != null) {
                queue.add(temp.left); // 左子节点不为空，入队
            }
            if (temp.right != null) {
                queue.add(temp.right); // 右子结点不为空，入队
            }
            // 打印出队元素
            list.add(temp.val);
        }
        return list;
    }

    /**
     * 题目二：分行从上到下打印二叉树
     *         从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
     */

    void Print(TreeNode pRoot) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        int curr = 0; // 当前层未打印的节点数
        int next = 0; // 下一层的节点数
        if (pRoot != null) {
            queue.add(pRoot);
            curr++;
        }
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0); // 出队
            if (temp.left != null) {
                queue.add(temp.left); // 入队
                next++; // 下一层个数加一
            }
            if (temp.right != null) {
                queue.add(temp.right); // 入队
                next++; // 下一层个数加一
            }
            System.out.print(temp.val + "\t"); // 打印出队元素
            curr--; // 当前层个数减一
            if (curr == 0) { // 当前层已全部打印完毕
                if (temp.left != null || temp.right != null) { // 当存在下一行时，才执行换行
                    System.out.println(); // 换行
                }
                curr = next; // 当前层变为下一层
                next = 0; // 下一层个数初始化为0
            }
        }
    }

    /**
     * 题目三：之字形打印二叉树。
     *         请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     *         第二行按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，以此类推。
     */

    void ZPrint(TreeNode pRoot) {
        Stack<TreeNode>[] levels = new Stack[2];
        levels[0] = new Stack<>(); // 入栈从左往右，出栈从右往左
        levels[1] = new Stack<>(); // 入栈从右往左，出栈从左往右
        int curr = 0; // 当前栈
        int next = 1; // 下一栈
        levels[curr].push(pRoot);
        while (!levels[0].empty() || !levels[1].empty()) {
            TreeNode node = levels[curr].pop();
            System.out.print(node.val + "\t");
            if (curr == 0) { // level[0] 先进后出，入栈从左往右，出栈从右往左
                if (node.left != null) {
                    levels[next].push(node.left);
                }
                if (node.right != null) {
                    levels[next].push(node.right);
                }
            } else { // level[1] 先进后出，入栈从右往左，出栈从左往右
                if (node.right != null) {
                    levels[next].push(node.right);
                }
                if (node.left != null) {
                    levels[next].push(node.left);
                }
            }
            if (levels[curr].empty()) { // 当前栈空时
                System.out.println(); // 换行
                curr = 1 - curr; // 交换当前行的打印方式
                next = 1 - next; // 交换下一行的打印方式
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node1 = s.new TreeNode(8);  //       8
        TreeNode node2 = s.new TreeNode(6);  //    /     \
        TreeNode node3 = s.new TreeNode(5);  //   6      10
        TreeNode node4 = s.new TreeNode(7);  //  / \     / \
        TreeNode node5 = s.new TreeNode(10); // 5   7   9   11
        TreeNode node6 = s.new TreeNode(9);
        TreeNode node7 = s.new TreeNode(11);
        node1.left = node2; // 8.left is 6
        node1.right = node5; // 8.right is 10
        node2.left = node3; // 6.left is 5
        node2.right = node4; // 6.right is 7
        node5.left = node6; // 10.left is 9
        node5.right = node7; // 10.right is 11
        s.ZPrint(node1);
    }

}
