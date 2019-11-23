package nowcoder._33;

/**
 * @program: practice
 * @description: 二叉搜索树的后序遍历序列
 *               输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *               如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 左边都比根节点小，右边都比根节点大，根节点在最后
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    public boolean isBST(int [] sequence, int left, int right) {
        if (left > right) return false;
        if (right - left <= 1) return true; // 当少于两个元素时，返回true
        int root = sequence[right]; // 根节点为最后一个元素
        int partition = -1; // 右子树的起始索引
        // 划分左右子树
        for (int i = left; i < right; i++) {
            if (sequence[i] > root) { // 找到比根节点大的数的索引
                partition = i; // 该索引为右子树的起始索引
                break;
            }
        }
        if (partition >= 0) { // 如果前面有比根节点大的数，从该处索引开始即为根节点的右子树
            for (int i = partition; i < right; i++) {
                if (sequence[i] < root) { // 如果右子树中存在比根节点小的数，则该序列不可能为BST的后序遍历序列
                    return false;
                }
                if (i == right - 1 && sequence[i] > root) return true; // 如果右子树当中不存在比根节点小的数，返回true
            }
        } else { // 如果前面没有比根节点大的数，前面的所有都为根节点的左子树，返回true
            return true;
        }
        // 找到区分点后，分别对左子树和右子树再进行确认
        return isBST(sequence, left, partition - 1) && isBST(sequence, partition, right - 1);
    }

}
