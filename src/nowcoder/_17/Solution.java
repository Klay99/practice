package nowcoder._17;

/**
 * @program: practice
 * @description: 打印从1到最大的n位数
 *               输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，
 *               则打印出1、2、3一直到最大的3位数999。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public void print1ToMaxOfNDigits1(int n) {
        if (n > 1) { // 打印从1到最大dn位数，所以n要大于1
            String s = "1"; // s为要打印的数，从1开始，且用字符串保存
            int numOfDigits = 1; // 当前数的位数
            System.out.print(s);
            while (numOfDigits <= n) { // 当前数的位数要<=n时满足条件
                String temp = add(s);
                if (temp.length() > n) { // 当加1后的字符串长度大于n时跳出循环
                    break;
                }
                if (temp.length() > s.length()) {
                    numOfDigits++;
                }
                s = temp;
                System.out.print("、" + s);
            }
        }
    }

    /**
     * 将数以字符串的形式加一
     * @param str 要加一的数
     * @return 加一后的结果
     */
    public String add(String str) {
        String temp = ""; // 从右到左反向存储str加1后的结果
        boolean hasCarry = false; // 是否发生进位
        int i = str.length() - 1;
        for (; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '9') { // 如果当前字符为9时，出现进位，当前字符变为0
                temp += "0";
                hasCarry = true;
            } else { // 如果没有发生进位时，加一，跳出循环
                temp += (int) c - 47; // '1'的ASCII码为49，c - 48为正确的int值，将正确的int值加一
                hasCarry = false;
                break;
            }
        }
        for (int j = i - 1; j >= 0; j--) { // 将没有添加上的数添加上去
            temp += str.charAt(j);
        }
        if (hasCarry) temp += '1'; // 如果加1循环结束后，还存在进位的话，加一
        String res = "";
        for (int j = temp.length() - 1; j >= 0; j--) { // 反转temp得到正确结果
            res += temp.charAt(j);
        }

        return res;
    }

    public void print1ToMaxOfNDigits2(int n) {

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.print1ToMaxOfNDigits1(2);
    }

}
