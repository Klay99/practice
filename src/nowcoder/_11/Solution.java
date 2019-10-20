package nowcoder._11;

/**
 * @program: practice
 * @description: 青蛙跳台阶
 *               一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 *               求青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 本质上为斐波那契数列，第一次可以跳1级，剩下(n-1)级，第一次也可以跳2级，剩下(n-2)级，即f(n) = f(n-1) + f(n-2)
    public int JumpFloor(int target) {
        int one = 1, two = 2;
        while (--target > 0) {
            two += one;
            one = two - one;
        }
        return one;
    }
}
