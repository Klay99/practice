package nowcoder._38;

import java.util.*;

/**
 * @program: practice
 * @description: 字符串的排列
 *               输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *               例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 1.将第一个字符与其后面的所有字符交换位置
    // 2.求第一个字符后面所有字符的排列
    // 重复1、2
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        Permutation(str.toCharArray(), 0, list);
        Collections.sort(list); // 最后对结果的所有排列组合进行（字母）排序
        return list;
    }

    void Permutation(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) { // 当i指向最后一个字符时直接添加，此时的数组为最原始的状态，只会被记录一次
            list.add(String.valueOf(chars)); // 等同于 list.add(new String(chars));
        } else { // 当i不为最后一个字符时，i依次与其后面的所有字符交换位置
            for (int j = i; j < chars.length; j++) { // 1.将第一个字符与其后面的所有字符交换位置
                swap(chars, i, j); // 先交换
                if (chars[i] != chars[j] || i == j) { // 当交换的字符不为同一个字符时，递归执行下一个
                    Permutation(chars, i+1, list); // 2.求第一个字符后面所有字符的排列
                }
                swap(chars, i, j); // 交换并求出排列后，还原为原来的位置，再求下一个字符
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
