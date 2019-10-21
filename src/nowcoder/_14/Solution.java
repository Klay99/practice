package nowcoder._14;

/**
 * @program: practice
 * @description: 剪绳子
 *               给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 *               每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]
 *               可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别
 *               为2、3、3的三段，此时得到的最大乘积是18。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public int cutRope(int target) {
        int max = 0;
        if (target < 2) {
            return 0;
        }
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int[] maxs = new int[target + 1];
        maxs[0] = 0;
        maxs[1] = 1;
        maxs[2] = 2;
        maxs[3] = 3;
        for (int i = 4; i <= target; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) { // 例：f(4)*f(6)==f(6)*f(4)。为避免重复计算应满足：j<=i/2
                int t = maxs[j] * maxs[i - j];
                if (max < t) {
                    max = t;
                }
                maxs[i] = max;
            }
        }
        max = maxs[target];
        return max;
    }

    /**
     * 贪心法
     * 当n>=5时，尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
     */
    public int max(int target) {
        if (target == 0) {
            return 0;
        }
        if (target <= 3) {
            return target - 1;
        }
        int timesOf3 = target / 3; // 长度为3的绳子的段数
        // 当绳子最后的长度为4时，更好的方法是剪成两段长度为2的绳子，2 * 2 > 3 * 1
        if (target - timesOf3 * 3 == 1) {
            --timesOf3;
        }
        int timeOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timeOf2));
    }

}
