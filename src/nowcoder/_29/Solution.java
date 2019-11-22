package nowcoder._29;

import java.util.ArrayList;

/**
 * @program: practice
 * @description: 顺时针打印矩阵
 *               输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *               例如，如果输入如下4 X 4矩阵： 1    2   3   4
 *                                             5    6   7   8
 *                                             9    10  11  12
 *                                             13   14  15  16
 *               则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0; // 左边界
        int right = matrix[0].length - 1; // 右边界
        int up = 0; // 上边界
        int down = matrix.length - 1; // 下边界
        while (true) {
            // 从左到右打印一行
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            // 向下逼近
            up++;
            if (up > down) {
                break;
            }
            // 从上到下打印一列
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            // 向左逼近
            right--;
            if (right < left) {
                break;
            }
            // 从右到左打印一行
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            // 向上逼近
            down--;
            if (down < up) {
                break;
            }
            // 从下到上打印一列
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            // 向右逼近
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

}
