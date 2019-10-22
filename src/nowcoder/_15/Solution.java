package nowcoder._15;

/**
 * @program: practice
 * @description: 二进制中1的个数
 *               输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public int NumberOf1(int n) {
        int[] binary = new int[100];
        int t = n, i = 0, sum = 0;
        if (n < 0) {
            t = -t;
        }
        while (t > 0) { // 转二进制
            binary[i] = t % 2;
            t = t >> 1;
            i++;
        }
        if (n < 0) {
            for (int j = 0; j < 31; j++) { // n<0取取反
                binary[j] = binary[j] ^ 1; // 异或取反
            }
            for (int j = 0; j < 31; j++) { // 求补码，取反后加1
                if (binary[j] == 0) {
                    binary[j] = 1;
                    break;
                } else if (binary[j] == 1){
                    binary[j] = 0;
                }
            }
            sum++; // 负数的符号位为1，因此比正数1的个数要多1个
        }
        for (int j = 0; j < 31; j++) {
            if (binary[j] == 1) {
                sum++;
            }
        }
        return sum;
    }

    // 先对低位与1，再左移1位，依次比较所有位
    // 当n为负数时，n左移时，最高位会补上1（符号位），到最后所有位都为1，出现死循环
    public int a(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) { // 直接对n的最低位进行与运算，为1时个数加一
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // 对a的改进，换个思路，a是对数进行左移并判断最低位是否为1                   n:  1010101010  (n & flag)
    // 这里将flag右移，n不变，flag右移依次与n的相应位进行与运算统计1的个数    flag:       <= 10  (右移左边补上0)
    // 此解法的循环次数取决于整数的二进制位数，32位的整数需要循环32次
    public int b(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) { // flag为int类型，当flag到达最大值时，右移后变为了0
            if ((n & flag) != 0) count++; // 因为flag是右移，与运算的结果可能是>1，所以判断条件为：!=0
            flag <<= 1;
        }
        return count;
    }

    // 改进b，当整数中有几个1就循环几次，当n-1时n最左边的1会变成0且该位左边的所有数全部变成1
    //                  n:  1101 1000
    //              n - 1:  1101 0111
    //        (n - 1) & n:  1101 0000
    // 当n-1时，从最左边的1开始，后面的所有数都与原来相反，当(n-1)&n时，从原最左边的1开始全部变为0
    public int c(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
