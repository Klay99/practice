package nowcoder._40;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: practice
 * @description: 最小的k个数
 *               输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // 先排序（快排），再求出已排序数组中的最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k < 1 || input.length < k) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + "\t");
        }
        System.out.println(Arrays.toString(input));
        for (int i = 0, j = 0; j < input.length - 1; j++) {
            if (i == k) {
                break;
            }
            if (input[j] != input[j+1]) {
                list.add(input[j]);
                i++;
            }
        }
        if (input.length == k) list.add(input[input.length - 1]);
        return list;
    }

    // 插入排序
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k < 1 || input.length < k) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            int maxIndex = findMax(list);
            System.out.println(maxIndex);
            if (input[i] < list.get(maxIndex)) {
                list.add(input[i]);
                print(list);
                list.remove(maxIndex);
                print(list);
            }
        }
        return list;
    }

    public int findMax(ArrayList<Integer> list) {
        int maxIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {4,5,1,6,2,7,3,8};
        s.GetLeastNumbers_Solution2(a, 4);
    }

}
