package nowcoder._8;

import java.util.Currency;

/**
 * @program: practice
 * @description: 二叉树的下一个节点
 *               给定二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 *               树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * provide two params(a tree,a node),based on these node and tree find the next node in inorder traversal
     * @param tree find the next node in the tree
     * @param node the next of the node need to be found
     * @return the node need to be found
     */
    public TreeNode getNext(TreeNode tree, TreeNode node) {
        // because it's inorder traversal,the next can't be in the left subtree
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else if (node.parent != null) { // node.right == null
            TreeNode current = node;
            TreeNode parent = node.parent;
            // in this case,left subtree and parent have been traversed so we need return parent.parent
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
        return null; // in this case,both of the right subtree and parent are null
    }

}
