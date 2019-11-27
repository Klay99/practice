package nowcoder._41;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: practice
 * @description: 数据流中的中位数
 *               如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 *               那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 *               那么中位数就是所有数值排序之后中间两个数的平均值。
 *               我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    ArrayList<Integer> list = new ArrayList<>();

    // 读取数据流
    public void Insert(Integer num) {
        if (num == 0) {
            list.add(num);
        }
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
    }

    // 获取中位数
    public Double GetMedian() {
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        int len = nums.length;
        if ((len & 1) == 0) { // even
            return (nums[len/2] + nums[len/2-1]) / 2.0;
        } else { // odd
            return nums[len/2] * 1.0;
        }
    }

    // todo 其他方法

}
