package nowcoder._36;

import java.util.Stack;

/**
 * @program: practice
 * @description: 二叉搜索树与双向链表
 *               输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *               要求不能创建任何新的结点，只能调整树中结点指针的指向。
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

    // 将BST转换成有序的双向链表，将BST的中序遍历变成双向有序链表即可，将left指向小的将right指向大的，实现有序（升序）

    // 循环实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode head = null; // 双向有序链表的头节点
        TreeNode current = pRootOfTree; // 循环的当前节点
        TreeNode pre = null; // 循环的前一个节点
        boolean isHead = true; // 标记是否为头节点
        Stack<TreeNode> stack = new Stack<>(); // 用于存储已遍历过的节点的栈
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current); // 入栈
                current = current.left; // 中序遍历，先走左边
            }

            // 中序遍历，处理根节点
            current = stack.pop(); // 出栈，当前节点为最左节点（最小），即为链表头节点
            if (isHead) { // 修改头节点
                head = current;
                pre = current;
                isHead = false;
            } else { // 如果已找到头节点，修改指向
                pre.right = current; // 小的right指向大的
                current.left = pre; // 大的left指向小的
                pre = current; // 更新上一个节点
            }

            current = current.right; // 中序遍历，最后走右边
        }

        return head;
    }

    // 递归实现
    TreeNode pre = null; // 上一个节点
    TreeNode head = null; // 链表头节点
    public TreeNode Convert2(TreeNode pRootOfTree){
        change(pRootOfTree);
        return head;
    }

    private void change(TreeNode current) {
        if (current == null) {
            return;
        }
        // 左
        change(current.left);
        // 根
        if (pre == null) { // 链表为空时，设置头节点
            head = current;
            pre = current;
        } else { // 链表不为空时，改变指针指向
            pre.right = current;
            current.left = pre;
            pre = current;
        }
        // 右
        change(current.right);
    }

}
