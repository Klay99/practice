package nowcoder._28;

/**
 * @program: practice
 * @description: 对称的二叉树
 *               请实现一个函数，用来判断一颗二叉树是不是对称的。
 *               注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        } else {
            return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
        }
    }

}
