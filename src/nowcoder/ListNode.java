package nowcoder;

/**
 * @program: practice
 * @description:
 * @author: Koty
 * @create: 2019-09-25 14:58
 **/
public class ListNode {
    private int val;
    private ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}