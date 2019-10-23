package nowcoder._18;

/**
 * @program: practice
 * @description: 删除链表的节点
 * 给定单项链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    class Node {
        private int value;
        private Node next;

        Node() {
        }

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

    /**
     * 题目二：删除链表中重复的节点（所有重复的节点都要删除，不能只保留一个）
     */
    public void deleteDuplication(Node head) {
        Node current = head;
        while (current != null) {
            Node currOfInner = current.next; // the current node of inner loop
            boolean hasDeleted = false; // 是否发生了节点的删除
            while (currOfInner != null) {
                if (currOfInner.value == current.value) {
                    deleteValue(current, current.value); // 从当前节点开始，删除所有与当前节点重复的节点
                    hasDeleted = true;
                    break; // 直接删除掉链表中所有值为value的节点，不用再往后寻找，跳出循环
                }
                currOfInner = currOfInner.next;
            }
            if (!hasDeleted) { // 当没有发生删除时才能后移
                current = current.next;
            }
        }
    }

    // 删除链表中值为value的所有节点
    public void deleteValue(Node head, int value) {
        Node current = head;
        Node previous = head;
        while (current != null) {
            if (current.value == value) {
                if (current.next == null) { // 如果当前节点是尾节点
                    previous.next = null;
                    break;
                } else {
                    //previous.next = current.next.next;
                    current.value = current.next.value;
                    current.next = current.next.next;
                    // 这里删除节点是将下一个节点赋给当前节点，删除一次就相当于current后移一次
                    // 为避免current后移两位，所以删除后当前节点应保持原位，不后移直接开始下轮循环
                    continue;
                }
            }
            previous = current;
            current = current.next;
        }
    }

    public void print(Node head) {
        if (head != null) {
            System.out.print(head.value);
            Node current = head.next;
            while (current != null) {
                System.out.print(" => " + current.value);
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node1 = s.new Node(1);
        Node node2 = s.new Node(4);
        Node node3 = s.new Node(9);
        node1.next = node2;
        node2.next = node3;
        s.print(node1);
        s.deleteNode2(node1, node2);
        s.print(node1);

        Node head = s.new Node(1);
        Node n1 = s.new Node(1);
        Node n2 = s.new Node(2);
        Node n3 = s.new Node(3);
        Node n4 = s.new Node(1);
        Node n5 = s.new Node(3);
        Node n6 = s.new Node(3);
        Node n7 = s.new Node(4);
        Node n8 = s.new Node(2);
        Node n9 = s.new Node(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
//        Node current = head;
//        Node temp1, temp2;
//        for (int i = 1; i < 10; i++) {
//            temp1 = s.new Node(i);
//            temp2 = s.new Node(i);
//            temp1.next = temp2;
//            current.next = temp1;
//            current = current.next.next;
//        }
        s.print(head);
        s.deleteDuplication(head);
        s.print(head);
    }

}
