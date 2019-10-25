package nowcoder._21;

/**
 * @program: practice
 * @description: 调整数组顺序使奇数位于偶数前面
 *               输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *               使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *               并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public void reOrderArray(int [] array) {
        int[] res = new int[array.length];
        int j = 0; // index of res
        for (int i = 0; i < array.length; i++) { // odd
            if ((array[i] & 1) == 1) {
                res[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) { // even
            if ((array[i] & 1) == 0) {
                res[j++] = array[i];
            }
        }
        for (int i = 0; i < res.length; i++) {
            array[i] = res[i];
        }
    }

    public void reOrderArray2(int[] array) {
        int right = array.length - 1; // 原数组的末尾元素索引
        int left = 0; // 原数组的起始元素索引
        while (left <= right){
            if ((array[left] & 1) == 0) { // 当“左边”出现偶数时，后面的所有元素前移
                int temp = array[left];
                for (int j = left; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp; // 将该偶数放在最后
                right--; // 前移后，末尾元素索引也进行了前移
            }else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,4,5,6,7};
        s.reOrderArray(a);
    }

}
