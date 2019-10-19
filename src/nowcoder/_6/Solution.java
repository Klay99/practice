package nowcoder._6;

import java.util.ArrayList;

/**
 * @program: practice
 * @description: 从头到尾打印链表, 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        // ①递归实现从尾到头遍历
//        if (listNode != null) {
//            printListFromTailToHead(listNode.next);
//            res.add(listNode.val);
//        }

        // ②用栈实现FILO（先进后出）
        while (listNode != null) {
            res.add(0,listNode.val); // 每次从0的位置加，自动后移，结果跟栈类似
            listNode = listNode.next;
        }
        return res;
    }

}
