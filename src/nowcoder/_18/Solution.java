package nowcoder._18;

/**
 * @program: practice
 * @description: 删除链表的节点
 *               给定单项链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public void deleteNode(Node head, Node node) {
        Node current = head;
        Node previous = head;
        while (current != node) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
    }

    public void deleteNode2(Node head, Node node) {
        if (node.next == null) { // 目标节点为尾结点时
            if (node == head) { // 目标节点也是头结点
                head = null;
            }
            node = null;
        } else { // 不是尾节点时，将下一个节点的内容和指向都赋给当前节点
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

}
