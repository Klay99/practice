package nowcoder._5;

/**
 * @program: practice
 * @description: 替换空格
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public String replaceSpace(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res += "%20";
            } else {
                res += str.charAt(i);
            }
        }

        return res;
    }

}
