package nowcoder._37;

/**
 * @program: practice
 * @description: 序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序
 * 的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示
 * 空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
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

    String Serialize(TreeNode root) {
        // 前序遍历，前序遍历的第一个元素一定是根节点的值
        String s = "";
        if (root == null) {
            s += "#!";
            return s;
        }
        s += root.val + "!";
        s += Serialize(root.left);
        s += Serialize(root.right);
        return s;
    }

    int index = -1; // 字符串分割后，指向值的索引
    TreeNode Deserialize(String str) {
        index++;
        if (index >= str.length()) { // 递归结束条件，当索引超过字符串长度时
            return null;
        }
        String[] strings = str.split("!"); // 通过！分割序列化的字符串
        TreeNode node = null; // 默认当前节点为空节点
        if (!strings[index].equals("#")) { // 如果不为空，对非空节点进行赋值
            node = new TreeNode(Integer.parseInt(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
