package nowcoder._10;

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

}
