package nowcoder;


import java.util.*;

/**
 * @program: practice
 * @description:
 * @author: Koty
 * @create: 2019-09-23 16:12
 **/
public class Solution {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 1 && matrix[0].length == 1) {
            res.add(matrix[0][0]);
        }
        int right = matrix[0].length - 1; // 右边数的个数
        int left = 0; // 左边数的个数
        int up = 0; // 上边数的个数
        int down = matrix.length - 1; // 下边数的个数

        while (true) { // 当上下左右都没有数时，结束循环
            // 最上面一行
            for (int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
            // 向下逼近
            up++;
            if (up > down) {
                break;
            }
            // 最右边一列
            for (int i = up; i <= down; i++){
                res.add(matrix[i][right]);
            }
            // 向左逼近
            right--;
            if (right < left){
                break;
            }
            // 最下边一行
            for (int i = right; i >= left; i--){
                res.add(matrix[down][i]);
            }
            // 向上逼近
            down--;
            if (down < up){
                break;
            }
            // 最左边一列
            for (int i = down; i >= up; i--){
                res.add(matrix[i][left]);
            }
            // 向右逼近
            left++;
            if (left > right){
                break;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(a).toString());

    }
}
