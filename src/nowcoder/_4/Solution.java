package nowcoder._4;


/**
 * @program: practice
 * @description: 二维数组中的查找
 * @author: Koty
 * @create: 2019-10-16 16:08
 **/
public class Solution {

    public boolean Find(int target, int[][] array) {

        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int up = array.length - 1;
        int right = 0;
        while (up >= 0 && right <= array[0].length - 1) {
            if (target == array[up][right]) {
                return true;
            }
            if (target < array[up][right]) {
                up--;
                continue;
            }
            if (target > array[up][right]) {
                right++;
            }
        }

        return false;
    }


}
