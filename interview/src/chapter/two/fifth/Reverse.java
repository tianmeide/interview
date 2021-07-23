package chapter.two.fifth;

/**
 * 反转部分单向链表
 * 【题目】
 * 给定一个单向链表的头节点head，以及两个整数from和to,在单向链表上把第from个节点到第to个节点这一部分进行反转。
 * 例如：
 * 1->2->3->4->5->null,from = 2,to=4
 * 调整结果为：1->4->->3->2->5->null
 * 再如：
 * 1->2->3->null,from=1,to=3
 * 调整结果为：3->2->1->null
 * 【要求】
 * 1、如果链表长度为N,时间复杂度要求为O(N),额外空间复杂度要求为O（I）.
 * 2、如果不满足1<=from<=to<=N,则不用调整。
 * @author tmd
 *
 */
public class Reverse {
	public Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len) {
			return head;
		}
		node1 = fPre == null ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while (node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse rev = new Reverse();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		System.out.println("处理前：");
		printNode(head);
		
		int from = 2;
		int to = 3;
		
		System.out.println("处理后：");
		printNode(rev.reversePart(head, from, to));
		
	}
	public static void printNode(Node head) {

		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
}
