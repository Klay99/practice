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
        if (root1.val == root2.val) {
            HasSubtree(root1.left, root2);
        } else {
            HasSubtree(root1.left, root2);
        }
        return false;
    }

}
