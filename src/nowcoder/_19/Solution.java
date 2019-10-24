package nowcoder._19;

/**
 * @program: practice
 * @description: 正则表达式匹配
 *               请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示
 *               任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *               在本题中，匹配是指字符串的所有字符匹配整个模式。
 *               例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    // str:字符串  pattern:带正则表达式的模式串  判断str是否与pattern匹配
    public boolean match(char[] str, char[] pattern) {
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int s, char[] pattern, int p) {
        // 边界值，串的长度为0或超出串的长度
        if (s == str.length && p == pattern.length) { // 字符串和模式串都为空，或者两串都已比较完
            return true;
        } else if (p == pattern.length) { // 模式串为空（或比较完），且字符串不为空（或没比较完）
            return false;
        }

        // 当next!=*时，只用比较当前字符与当前模式的值，且比较完后都后移一位
        // 当next==*时，比较完后分两种情况：①当前字符不变，当前模式后移两位（跳到*的下一位）
        // ②当前字符后移一位，当前模式不变
        boolean next = (p < pattern.length - 1 && pattern[p + 1] == '*'); // 模式串下一个字符是'*'
        if (next) { // next == '*'
            if (s < str.length && (pattern[p] == '.' || str[s] == pattern[p])) { // 要保证s<str.length，否则越界
                return matchCore(str, s, pattern, p + 2) || matchCore(str, s + 1, pattern, p);
            } else { // (s >= str.length) || (pattern[p] != '.' && str[s] != pattern[p])
                return matchCore(str, s, pattern, p + 2); // 当前位置没有匹配上，p后移两位（这里*的值为0）
            }
        } else { // next != '*'
            if (s < str.length && (pattern[p] == '.' || str[s] == pattern[p])) {
                return matchCore(str, s + 1, pattern, p + 1);
            } else {
                return false;
            }
        }
    }

}
