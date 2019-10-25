package nowcoder._24;

/**
 * @program: practice
 * @description: 反转链表
 *               输入一个链表，反转链表后，输出新链表的表头。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }

    // 当改变指针指向时，就会失去原来的指向，所以需要一个中间节点用来保存原指向
    // 遍历时先保存原指向然后改变指向
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next; // 中间节点，用来保存原指向（下一个节点）
        ListNode pre = null; // 前一个节点
        ListNode current = head; // 当前节点
        while (current != null) {
            next = current.next; // 保存原指向
            current.next = pre; // 将当前节点指向前一个节点
            pre = current; // 前一个节点后移
            current = next; // 当前节点移到原指向
        }
        return pre; // 返回链表的头节点为原链表的尾结点，当前节点为空，前一个节点为原尾结点
    }

}
