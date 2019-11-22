package nowcoder._27;

/**
 * @program: practice
 * @description: 二叉树的镜像
 *               操作给定的二叉树，将其变换为源二叉树的镜像。
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

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (!(left == null && right == null)) { // 当前节点不是叶子节点时才进行交换
            root.left = right;
            root.right = left;
        }
        if (root.left != null) { // 左子树不为空时，处理左子树
            Mirror(root.left);
        }
        if (root.right != null) { // 右子树不为空时，处理右子树
            Mirror(root.right);
        }
    }

}
