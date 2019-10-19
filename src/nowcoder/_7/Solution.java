package nowcoder._7;

/**
 * @program: practice
 * @description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        build(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }

    public void build(TreeNode root, int[] pre, int pleft, int pright, int[] in, int ileft, int iright) {
        int i; // the index of root
        for (i = ileft; i < iright; i++) { // find the index of root in in
            if (in[i] == root.val) {
                break;
            }
        }
        // divide left subtree and right subtree

        int l = i - ileft; // the length of left subtree
        int r = iright - i - 1; // the length of right subtree
        // execute recursive to build the tree
        // end recursive while the length of pre and in is 0
        if (l > 0) {
            root.left = new TreeNode(pre[pleft+1]);
            // build left subtree
            build(root.left, pre, pleft + 1, pleft + 1 + l, in, ileft, i);
        }
        if (r > 0) {
            root.right = new TreeNode(pre[pleft + 1 + l]);
            build(root.right, pre, pleft + 1 + l, pright, in, i + 1, iright);
        }
    }

}
