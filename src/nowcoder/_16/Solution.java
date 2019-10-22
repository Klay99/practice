package nowcoder._16;

/**
 * @program: practice
 * @description: 数值的整数次方
 *               给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 暴力法
    public double Power(double base, int exponent) {
        if (base == 0.0 && exponent == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double pow = base, b = base;
        int e = exponent;
        if (e < 0) {
            pow = 1.0 / base;
            e = -exponent;
            b = 1.0 / base;
        }
        for (int i = 1; i < e; i++) {
            pow = pow * b;
        }

        return pow;
    }

    // 快速幂，每次将指数变为原来的一半，结果为两半结果的积，如果指数为奇数再乘一次底数
    public double a(double base, int exponent) {
        double pow = base;
        if (exponent == 0) {
            pow = 1;
        }
        boolean flag = exponent < 0;
        if (flag) {
            if (base == 0) { // 当底数为0，指数小于0时，会出现除以0的情况，避免报错返回0
                return 0;
            }
            exponent = -exponent;
        }
        while (exponent > 0) {
            if (exponent == 1) { // 当最后指数为1时，结果乘一次底数
                pow = pow * base;
            }
            base *= base;
            exponent >>= 1; // >>1 比 /2 要快
        }
        return flag ? 1 / pow : pow; // 当指数为负数时返回结果的倒数
    }

}
