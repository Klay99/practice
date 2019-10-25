package nowcoder._25;

/**
 * @program: practice
 * @description: 合并两个排序的链表
 *               输入两个单调递增的链表，输出两个链表合成后的链表，
 *               当然我们需要合成后的链表满足单调不减规则。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode res, currRes;
        if (curr1.val < curr2.val) {
            res = curr1;
            curr1 = curr1.next;
        } else {
            res = curr2;
            curr2 = curr2.next;
        }
        currRes = res;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                currRes.next = curr1;
                curr1 = curr1.next;
            } else {
                currRes.next = curr2;
                curr2 = curr2.next;
            }
            currRes = currRes.next;
        }
        if (curr1 != null) {
            currRes.next = curr1;
        }
        if (curr2 != null) {
            currRes.next = curr2;
        }

        return res;
    }

}
