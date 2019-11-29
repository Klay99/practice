package nowcoder._43;

/**
 * @program: practice
 * @description: 1～n整数中1出现的次数
 *               求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 *               为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 *               但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 *               可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    private static int invalidInput = -1;

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return ++invalidInput;
        int temp = n;
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        return getNum(n, digits);
    }

    private int getNum(int n, int digits) {
        if (n != 0 && n / 10 == 0 || digits == 1) {
            return 1;
        }
        int maxTens = (int)Math.pow(10, digits - 1); // 保留最高位，其他位变0
        int topDigit = n % maxTens;
        if (topDigit == 1) {

        } else {
            int i = getNum(maxTens - 1, digits - 1);
            int j = n - topDigit * maxTens;
            int k = j % (digits - 1);
            int l = getNum(j, )
            return topDigit * i + maxTens;
        }
        return 0;
    }

    public int z(int n) {
        if (n > 1 && n < 10) {
            return 1;
        }
        int temp = n;
        int digits = 0; // 位数
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        int maxTens = (int)Math.pow(10, digits - 1); // 最高位为1其他位为0的数
        int topDigit = n % maxTens;
        int counts = 1;
        for (int i = 10; i <= n; i *= 10) {

        }
    }

//    思路是分别计算个位、十位、百位........上出现 1 的个数。
//    以  n =216为例：
//    个位上： 1 ，11，21，31，.....211。个位上共出现（216/10）+ 1个 1 。
//    因为除法取整，210~216间个位上的1取不到，所以我们加8进位。你可能说为什么不加9，n=211怎么办，
//    这里把最后取到的个位数为1的单独考虑，先往下看。
//    十位上：10~19，110~119，210~216.   十位上可看成 求（216/10）=21 个位上的1的个数然后乘10。
//    这里再次把最后取到的十位数为1的单独拿出来，即210~216要单独考虑 ，个数为（216%10）+1 .这里加8就避免了判断的过程。
//    后面以此类推。
//    时间复杂度 O(logN)
    public int a(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            count += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }

}
