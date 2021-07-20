package chapter.two.second;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * 【题目】
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表中倒数第K个节点。
 * 【要求】
 * 如果链表长度为N,时间复杂度达到O(N),额外空间复杂度达到O（I）.
 * @author tmd
 *
 */
public class DoubleLastKthNode {
	
	public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		DoubleNode cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
			head.last = null;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if (newNext != null) {
				newNext.last = cur;
			}
		}
		System.out.println(head.value);
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLastKthNode dln = new DoubleLastKthNode();
		DoubleNode head = new DoubleNode(7);
		head.next = new DoubleNode(9);
		head.last = new DoubleNode(11);
		int lastKth = 1;
		dln.removeLastKthNode(head, lastKth);
	}

}
