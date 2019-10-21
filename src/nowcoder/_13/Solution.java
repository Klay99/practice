package nowcoder._13;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 机器人的运动范围
 *               地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 *               每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标
 *               和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够
 *               进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 *               因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        boolean[] visited = new boolean[rows * cols];
        Arrays.fill(visited, false);
        count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    // 判断是否已全部走完
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && check(threshold, row, col) && !visited[row * cols + col]) {
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row, col - 1,visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    // 检查当前格子是否满足要求，数位和小于等于临界值时满足
    private boolean check(int threshold, int row, int col) {
        int r = row, c = col, sum = 0;
        while (r > 0) {
            sum += r % 10;
            r /= 10;
        }
        while (c > 0) {
            sum += c % 10;
            c /= 10;
        }
        return sum <= threshold;
    }

}
