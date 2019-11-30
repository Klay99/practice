package nowcoder._44;

/**
 * @program: practice
 * @description: 数字序列中某一位的数字
 *               数字以 0123456789101112131415...的格式序列化到一个字符序列中。
 *               在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 *               请写出一个函数，求任意第n位对应的数字
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    private int invalidInput = -1;

    public int digitAtN(int n) {
        if (n < 0) return invalidInput;
        int digits = 1;
        while (true) {
            int num = countOfIntegers(digits);
            if (n < num * digits) return digitAtN(n, digits);
            n -= digits * num;
            digits++;
        }
    }

    private int digitAtN(int n, int digits) {
        int num = beginNumber(digits) + n / digits;
        int indexFromRight = digits - n / digits;
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }
        return num % 10;
    }

    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int)Math.pow(10, digits - 1);
    }

    private int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int)Math.pow(10, digits - 1);
        return 9 * count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.digitAtN(5));
        System.out.println(s.digitAtN(13));
        System.out.println(s.digitAtN(19));
        System.out.println(s.digitAtN(1001));
        System.out.println(s.digitAtN(190+2700));
    }

    // todo comments

}
