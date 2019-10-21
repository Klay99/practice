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
        max = maxs[target - 1];
        return max;
    }


}
