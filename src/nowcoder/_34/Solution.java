package nowcoder._34;

import java.util.ArrayList;

/**
 * @program: practice
 * @description: 二叉树中和为某一值的路径
 *               输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *               路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *               (注意: 在返回值的list中，数组长度大的数组靠前)
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

    ArrayList<ArrayList<Integer>> res = new ArrayList<>(); // 结果，保存所有符合的路径
    ArrayList<Integer> path = new ArrayList<>(); // 当前路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        target -= root.val; // 目标值减去当前值
        path.add(root.val); // 当前节点添加到路径
        print(path);
        // 题目要求的路径应为：所有路径以根节点开始，以叶子节点结束
        if (target == 0 && root.left == null && root.right == null) { // 当目标值减到0且当前节点为叶子节点，当前路径符合条件
            res.add(new ArrayList<>(path));
            pPrint(res);
        }
        if (root.left != null) { // left不为空时继续往下执行，此处也可不用判断，开头处有空值处理
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
        path.remove(path.size() - 1); // 无论当前路径是否符合，返回到上一节点时，都应在当前路径中删掉当前节点
        return res;
    }

    void print(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "\t");
        }
        System.out.println();
    }

    void pPrint(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            print(arr.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node1 = s.new TreeNode(10);  //       10
        TreeNode node2 = s.new TreeNode(5);   //    /     \
        TreeNode node3 = s.new TreeNode(12);  //   5      12
        TreeNode node4 = s.new TreeNode(4);   //  / \
        TreeNode node5 = s.new TreeNode(7);   // 4   7
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        s.FindPath(node1, 22);
    }

}
