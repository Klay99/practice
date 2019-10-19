package nowcoder._3;

/**
 * @program: practice
 * @description:
 * 数组中重复的数字
 *
 * @author: Koty
 * @create: 2019-10-16 16:07
 **/
public class Solution {

    public boolean DuplicationArray(int[] arr, int res){

        for (int i = 0; i < arr.length; i++) {

        }

        return false;
    }

    public void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]+"]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2,1,3,0,2,5,3};
        s.DuplicationArray(a,2);
        s.print(a);
    }

}
