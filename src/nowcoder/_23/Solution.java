package nowcoder._23;

/**
 * @program: practice
 * @description: 链表中环的入口节点
 *               给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
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

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        boolean hasLoop = true;
        if (pHead != null && pHead.next != null) {
            ListNode slow = pHead;
            ListNode quick = pHead.next.next;
            while (slow != quick) { // 找到slow和quick第一次相遇的节点
                if (slow == null || quick == null) { // 链表中没有环
                    hasLoop = false;
                    break;
                }
                slow = slow.next;
                quick = quick.next.next;
            }
            if (hasLoop) { // 当链表中有环时
                int length = getLengthOfLoop(slow); // 计算环的长度
                ListNode slow2 = pHead;
                ListNode quick2 = pHead;
                for (int i = 0; i < length; i++) { // quick先移动length次
                    quick2 = quick2.next;
                }
                while (slow2 != quick2) { // slow和quick一起移动，相遇的节点就是环的入口
                    slow2 = slow2.next;
                    quick2 = quick2.next;
                }
                return slow2;
            }
        }
        return null;
    }

    // 计算环的长度，计算第一次相遇到第二次相遇走过的次数
    public int getLengthOfLoop(ListNode firstMeet) {
        ListNode slow = firstMeet;
        ListNode quick = firstMeet.next.next;
        int length = 2; // quick已经移动了两次
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next.next;
            length++;
        }
        return length;
    }

    public boolean hasLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return false;
        }
        ListNode slow = pHead;
        ListNode quick = pHead.next.next;
        while (slow != quick) {
            if (slow == null || quick == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead = s.new ListNode(1);
        ListNode curr = pHead;
        for (int i = 2; i < 7; i++) {
            ListNode temp = s.new ListNode(i);
            curr.next = temp;
            curr = curr.next;
        }
        curr.next = pHead.next.next; // 1 2 3 4 5 6 3
        System.out.println(s.hasLoop(pHead));
        System.out.println(s.getLengthOfLoop(pHead.next.next));
        System.out.println(s.EntryNodeOfLoop(pHead).value);
    }

}
