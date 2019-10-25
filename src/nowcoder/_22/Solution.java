package nowcoder._22;

/**
 * @program: practice
 * @description: 链表中倒数第K个节点
 *               输入一个链表，输出该链表中倒数第k个结点。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class ListNode{
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    // 先遍历链表求长度，再得到倒数第K个节点，所以需要遍历两遍
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        if (k > count) {
            return null;
        }
        int i = 1;
        current = head;
        while (current != null) {
            if (i == (count - k + 1)) {
                return current;
            }
            current = current.next;
            i++;
        }

        return null;
    }

    // 只循环一遍，用两个节点，一个先走K步走完后第二个再开始走，
    // 当第一个走到链表尾时，第二个节点就是倒数第K个节点
    public ListNode FindKthToTail2(ListNode head, int k) {
        ListNode first, second;
        first = second = head;
        int count = 0; // 已遍历节点个数
        while (first != null) {
            if (count >= k) { // 当已遍历了K个时，第二个节点开始
                second = second.next;
            }
            first = first.next;
            count++;
        }
        return count < k ? null : second;
    }

}
