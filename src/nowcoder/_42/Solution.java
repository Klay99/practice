package nowcoder._42;

/**
 * @program: practice
 * @description: 连续子数组的最大和
 *               HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 *               他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 *               当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 *               是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *               例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *               给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    private int invalidInput = -1; // 用于区分非法输入与合法输入且最大和为0的情况

    // 1.计算所有子数组的和，找出最大和。
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1) {
            return ++invalidInput;
        }
        int[] sums = new int[array.length * (array.length + 1) / 2]; // 对于长度为n的数组，子数组个数为：n(n+1)/2
        for (int i = 0, k = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                sums[k++] = sum;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] >= max) {
                max = sums[i];
            }
        }
        return max;
    }

    // 2.如果前面的和为负数，舍弃掉重新开始计算，否则加上当前值
    // 如果当前和大于最大和，更新最大和
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length < 1) {
            return ++invalidInput;
        }
        int maxSum = Integer.MIN_VALUE; // 最大和
        int currSum = 0; // 当前和
        for (int i = 0; i < array.length; i++) {
            if (currSum <= 0) { // 之前的和为负数
                currSum = array[i]; // 从i开始重新计算
            } else { // 之前的和为正数
                currSum += array[i];
            }
            if (currSum > maxSum) { // 当前和大于最大和，更新最大和
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    // 3.动态规划          { array[i]           i == 0 || f(i-1) <= 0
    //              f(i) = { f(i-1) + array[i]  i != 0 && f(i-1) > 0
    // 这里f(i)即为2中的currSum，当前面和小于0时，重新计算，否则加上当前值
    // 可以循环（上面的2）或递归实现，区分2，以下用递归实现
    public int FindGreatestSumOfSubArray3(int[] array) {
        if (array == null || array.length < 1) {
            return ++invalidInput;
        }
        return find(array, array.length - 1)[1];
    }

    private int[] find(int[] array, int i) {
        int[] res = {0,Integer.MIN_VALUE}; // res[0] : currSum, res[1] : maxSum
        if (i < 0) return res; // 递归结束条件
        res = find(array, i - 1);
        int preSum = res[0];
        // 前面的和为负数时，舍弃前面所有值从i开始重新计算，否则加上当前值
        res[0] = preSum <= 0 ? array[i] : preSum + array[i];
        if (res[0] > res[1]) { // currSum > maxSum
            res[1] = res[0];
        }
        System.out.println("currSum: " + res[0] + "\t\tmaxSum: " + res[1]);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,-2,3,10,-4,7,2,-5};
        s.FindGreatestSumOfSubArray3(array);
    }

}
