package nowcoder._10;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 求斐波那契数列的第n项
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 递归（自上而下），重复计算数量过多，且计算量会随n的增大而急剧增大，时间复杂度以n的指数方式递增
//    public int Fibonacci(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
//    }

    // 循环（自下而上），先计算下（f(0),f(1)）再由下的结果计算上（f(2) = f(0) + f(1)），时间复杂度：O(n)
    public int Fibonacci(int n) {
        if(n <= 1) return n;
        int one = 0;
        int two = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

    /**
     * 题目二：青蛙跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     * 求青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    // 本质上为斐波那契数列，第一次可以跳1级，剩下(n-1)级，第一次也可以跳2级，剩下(n-2)级，即f(n) = f(n-1) + f(n-2)
    public int JumpFloor(int target) {
        int one = 1, two = 2;
        while (--target > 0) {
            two += one;
            one = two - one;
        }
        return one;
    }

    /**
     * 题目三：变态跳台阶 todo
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    // f(n) = f(n-1) + f(n-2) + ... + f(1)
//    public int JumpFloorII(int target) {
//        if (target <= 2) {
//            return target;
//        }
//        int[] dp = new int[target+1];
//        Arrays.fill(dp, 1);
//        dp[0] = 0;
//        for (int i = 2; i <= target; i++) {
//            for (int j = i - 1; j > 0; j--){
//                dp[i] += dp[j];
//            }
//        }
//        return dp[target];
//    }

    // ① f(n) = f(n-1) + f(n-2) + ... + f(1)
    // ② f(n-1) = f(n-2) + f(n-3) + ... + f(1)
    // ① - ②: f(n) - f(n-1) = f(n-1) - f(n-1) + f(n-1) - ... - f(1) + f(1) => f(n) = 2f(n-1)
    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] res = new int[target + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= target; i++) {
            res[i] = 2 * res[i - 1];
        }
        return res[target];
    }

    /**
     * 题目四：矩形覆盖
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    // 设2*n的覆盖方法记为f(n)，当第一个矩形横放时还剩下2*(n-1)的区域及f(n-1)
    // 当第一个矩形竖放时，旁边必须还得竖放一个矩形，此时还剩下2*(n-2)的区域及f(n-2)
    // f(n) = f(n-1) + f(n-2)
    // 同斐波那契解法

}
