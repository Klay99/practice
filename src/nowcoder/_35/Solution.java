package nowcoder._35;

/**
 * @program: practice
 * @description: 复杂链表的复制
 *               输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 *               另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 *               （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: Koty
 * @create: 2019-10-16 16:09
 **/
public class Solution {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        return clone(pHead);
    }

    public RandomListNode clone(RandomListNode target) {
        if (target == null) {
            return null;
        }
        RandomListNode node = new RandomListNode(target.label);
        node.random = random(target.random);
        node.next = clone(target.next);
        return node;
    }

    private RandomListNode random(RandomListNode random) {
        if (random == null) {
            return null;
        }
        RandomListNode node = new RandomListNode(random.label);
        node.next = random.next;
        node.random = random.random;
        return node;
    }

    // 在每个节点后面添加该节点的复制
    public RandomListNode copy(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode current = pHead;
        // 插入当前节点的复制
        while (current != null) {
            RandomListNode nextTemp = new RandomListNode(current.label);
            nextTemp.next = current.next;
            current.next = nextTemp;
            current = current.next.next;
        }
        current = pHead;
        // 插入当前节点的random的复制
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }
        RandomListNode res = pHead.next;
        current = pHead;
        // 将链表拆分成两个
        while (current != null) {
            RandomListNode resCurr = current.next;
            current.next = current.next.next;
            resCurr.next = resCurr.next == null ? null : resCurr.next.next;
            current = current.next;
        }
        return res;
    }

}
