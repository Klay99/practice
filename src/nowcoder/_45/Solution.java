package nowcoder._45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: practice
 * @description: 把数组排成最小的数
 *               输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *               例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 1) {
            return numbers[0] + "";
        }
        String res = "";
        int[] a = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            a[i] = getTopDigit(numbers[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }

    }

    public int getTopDigit(int num) {
        if (num < 0) return -1;
        if (num < 10) return num;
        int i = 10;
        while (i <= num) {
            i *= 10;
        }
        return num % (i / 10);
    }

    public String printMinNumber2(int [] numbers) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i : numbers){
            arrayList.add( i + "" );
        }

        Collections.sort(arrayList, new Comparator<String>() {

            public int compare(String o1, String o2) {
                int i = 0, j = 0;
                while(i < o1.length() || j < o2.length()){
                    if(j==o2.length()) j-=o2.length();
                    if(i==o1.length()) i-=o1.length();
                    if(o1.charAt(i) < o2.charAt(j)){
                        return -1;
                    }else if(o1.charAt(i) > o2.charAt(j)){
                        return 1;
                    }
                    i++; j++;
                }
                return 0;
            }
        });

        StringBuilder stringBuilder2 = new StringBuilder();
        for(String s : arrayList){
            stringBuilder2.append(s);
        }
        return stringBuilder2.toString();
    }

    // todo other solutions

}
