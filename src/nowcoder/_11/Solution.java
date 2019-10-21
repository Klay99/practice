package nowcoder._11;

/**
 * @program: practice
 * @description: 旋转数组的最小数字
 *               把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *               输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *               例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *               NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return array[0] < array[1] ? array[0] : array[1];
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[left] < array[right]) {
                return array[left];
            }
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            }
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public int min(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = left;
                break;
            }
            mid = (left + right) / 2;
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

}
