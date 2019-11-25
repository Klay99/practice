package nowcoder._39;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 数组中出现次数超过一半的数字
 *               数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *               例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 *               超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 直接挨个查
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            int half = array.length / 2;
            int num = 0;
            for (int j = i; j < array.length; j++) {
                if (array[j] == array[i]) {
                    num++;
                }
                if (num + array.length - 1 - j < half) {
                    break; // 假设j后面的都是该数，且总个数还是小于一半的话，跳出循环
                }
            }
            if (num > half) return array[i];
        }

        return 0;
    }

    // 先排序
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null || array.length < 2) {
            return array == null ? 0 : array[0];
        }
        int half = array.length / 2;
        Arrays.sort(array);
        int num = array[half];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        return count > half ? num : 0;
    }

    // 解法三：一个数出现的次数超过数组的一半，则它出现的次数比其他所有数出现的次数和要大
    // 1.当一个数与下一个数相同时，个数加一，否则减一，当个数为0时，记录下一个数出现的次数，
    // 且将个数设为1，最后使个数变为1的数就是数组中出现次数最多的数。在验证该次数是否为数组的一半
    public int MoreThanHalfNum_Solution3(int[] array) {
        if (array == null || array.length < 2) {
            return array == null ? 0 : array[0];
        }
        int half = array.length / 2;
        int count = 1;
        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                previous = array[i];
                count = 1;
            }
            if (previous == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == previous) {
                count++;
            }
        }
        return count > half ? previous : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,2,4,2,5,2,3};
    }

}
