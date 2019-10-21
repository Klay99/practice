package nowcoder._12;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 矩阵中的路径
 *               请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *               路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 *               向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 *               则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条
 *               字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b
 *               占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    /**
     * 判断矩阵中是否存在所给路径
     * @param matrix 提供的矩阵，遍历该矩阵并查找正确路径
     * @param rows 矩阵的行数
     * @param cols 矩阵的列数
     * @param str 需要查找的路径
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || rows < 1 || cols < 1) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols]; // 用于保存元素是否被访问过
        Arrays.fill(visited, false); // 初始默认所有元素都没有被访问过

        // 遍历matrix，对matrix中的所有元素进行配对
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 匹配上时返回true
                if (hasPathCore(matrix, rows, cols, row, col, 0, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归判断当前字符所有的下一个字符是否匹配，匹配时路径长度加一继续往下判断，不匹配时回溯到上一个字符
     * @param matrix 提供的矩阵
     * @param rows 矩阵的行数
     * @param cols 矩阵的列数
     * @param row 递归记录到的行数
     * @param col 递归记录到的列数
     * @param pathLength 所给字符串已匹配的长度
     * @param str 所给字符串
     * @param visited 记录已走过路径的字符数组
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, int pathLength, char[] str, boolean[] visited) {
        // 当已匹配上的路径长度等于要匹配的路径长度时，返回true
        if (pathLength == str.length) {
            return true;
        }
        // 判断当前字符是否匹配，初始默认不匹配
        boolean hasPath = false;

        // row >= 0 && row < rows && col >= 0 && col < cols     递归结束的条件
        // matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]    匹配字符的条件
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            pathLength++; // 当满足条件时已匹配长度加一
            visited[row * cols + col] = true; // 当前字符设为“已走过”

            // 递归对当前字符的下四个字符进行匹配
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, pathLength, str,visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, pathLength, str, visited);

            // 当没有匹配上时，回溯到上一个字符
            if (!hasPath) {
                --pathLength; // todo pathLength--(the value changed at 'pathLength--' is never used but '--pathLength' is right)
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

}
