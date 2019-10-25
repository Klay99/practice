package nowcoder._20;

/**
 * @program: practice
 * @description: 表示数值的字符串
 *               请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *               例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *               但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    /**
     * +、-：     不能连着出现；不能出现在小数部分的前面及小数点的后面；可以出现在（e|E）的后面
     *            不能出现在字符串末尾；当整数部分不为空时，+、-不能出现在.的前面
     * 小数点：   字符串中最多只能有一个小数点；出现在字符串末尾时前面必须为数字；小数点后面必须且只能为数字；
     * （e|E）：  前面必须要有数字；不能出现在字符串末尾；后面不能出现小数
     */

    // 暴力穷举法
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        if (str.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i < str.length - 1) { // 不是最后一个字符
                    if ((str[i] == '+' && str[i + 1] == '-') || (str[i] == '-' && str[i + 1] == '+')) {
                        return false;
                    } else if (i > 0 && str[i + 1] == '.') { // 当i前面有字符，且i的下一个字符为.
                        return false; // 当整数部分不为空时，+、-不能出现在.的前面
                    }
                } else { // 不能以+、-结尾
                    return false;
                }
                if (i > 0) {
                    if ((str[i - 1] == '.') || (str[i - 1] != 'e' && str[i - 1] != 'E')) { // 如果+、-前面是.的话
                        return false; // 小数部分前面不能是+、-，且+、-只能出现在（e|E）的后面
                    }
                }
            }
            else if (str[i] == '.') {
                if (i < str.length - 1) { // .不是最后一个字符
                    for (int j = i + 1; j < str.length; j++) {
                        if (str[j] == '.') { // .的后面不能再出现.
                            return false;
                        }
                    }
                    if (str[i + 1] - '0' < 0 || str[i + 1] - '0' > 9) {
                        return false; // .后面只能为数字
                    }
                } else { // .为最后一个字符
                    if (i > 0) { // .前面还有字符
                        if (str[i - 1] - '0' < 0 || str[i - 1] - '0' > 9) {
                            return false; // .的前面不是数字
                        }
                    } else { // 字符串中只有一个字符（.）
                        return false;
                    }
                }
            }
            else if (str[i] == 'e' || str[i] == 'E') {
                // （e|E）前面必须要有数字
                if (i <= 0) {
                    return false;
                } else {
                    if (str[i - 1] - '0' < 0 || str[i - 1] - '0' > 9) {
                        return false;
                    }
                }
                if (i < str.length - 1) {
                    for (int j = i + 1; j < str.length; j++) {
                        if (str[j] == '.') { // （e|E）的后面不能出现小数
                            return false;
                        }
                    }
                } else { // （e|E）不能是最后一个元素
                    return false;
                }
            } else {
                // 不是（+、-、0-9、e、E、.）中的任何一个
                if (str[i] - '0' < 0 || str[i] - '0' > 9) return false;
            }
        }
        return true;
    }

    public boolean isNumeric2(char[] str) {
        boolean point = false, exp = false; // 标志小数点和指数
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')) { // +-号后面必定为数字 或 后面为.（-.123 = -0.123）
                    return false;
                }
                if (!(i == 0 || str[i-1] == 'e' || str[i-1] == 'E')) { // +-号只出现在第一位或eE的后一位
                    return false;
                }
            } else if (str[i] == '.') {
                if (point || exp || !(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '9')) { // .后面必定为数字 或为最后一位（233. = 233.0）
                    return false;
                }
                point = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (exp || i + 1 == str.length || !(str[i] >= '0' && str[i + 1] <= '9' || str[i + 1] == '+' || str[i + 1] == '-')) { // eE后面必定为数字或+-号
                    return false;
                }
                exp = true;
            } else {
                if (str[i] < '0' || str[i] > '9') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "1a3.14";
        s.isNumeric2(str.toCharArray());
    }

}
