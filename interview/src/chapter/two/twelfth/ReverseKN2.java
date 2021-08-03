package chapter.two.twelfth;

import chapter.two.Node;

/**
 * 将单链表的每K个节点之间逆序
 * @author tmd
 *
 */
public class ReverseKN2 {

	public Node reverseKNodes2(Node head, int K) {
		if (K < 2) {
			return head;
		}
		Node cur = head;
		Node start = null;
		Node pre = null;
		Node next = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			if (count == K) {
				start = pre == null ? head : pre.next;
				head = pre == null ? cur : head;
				resign2(pre, start, cur, next);
				pre =start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
	}
	
	public void resign2(Node left, Node start, Node end, Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while (cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if (left != null) {
			left.next = end;
		}
		start.next = right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseKN2 rev = new ReverseKN2();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next =new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next =new Node(8);
		int K = 3;
		Node cur = rev.reverseKNodes2(head, K);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
