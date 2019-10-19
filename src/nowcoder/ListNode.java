package nowcoder;

/**
 * @program: practice
 * @description:
 * @author: Koty
 * @create: 2019-09-25 14:58
 **/
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}