package nowcoder._26;

/**
 * @program: practice
 * @description: 树的子结构
 *               输入两棵二叉树A，B，判断B是不是A的子结构。
 *               （ps：我们约定空树不是任意一个树的子结构）
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) { // 如果当前节点对应上，以该节点为起点判断是否存在
                result = doesTree1HaveTree2(root1, root2);
            }
            // 如果找不到，再从root1的左子树开始找
            if (!result) {
                result = doesTree1HaveTree2(root1.left, root2);
            }
            // 如果找不到，再从root1的右子树开始找
            if (!result) {
                result = doesTree1HaveTree2(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        // 如果node2已遍历完，表明都已对应上
        if (node2 == null) {
            return true;
        }
        // 如果node1已遍历完，表明没有对应上
        if (node1 == null) {
            return false;
        }
        // 只要有一个节点没有对应上，就返回false
        if (node1.val != node2.val) {
            return false;
        }
        // 如果当前节点对应上了，再对其左右子节点进行匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
