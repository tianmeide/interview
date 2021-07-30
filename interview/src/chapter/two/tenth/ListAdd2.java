package chapter.two.tenth;

import chapter.two.Node;

/**
 * 两个单链表生成相加链表
 * 假设链表中每一个节点的值都再0~9之间，那么链表整体就可以代表一个整数。
 * 例如：9->3->7,可以代表整数937.
 * 给定两个这种链表的头节点head1和head2，请生成代表两个整数相加值得结果链表。
 * 例如：链表1为9->3->7,链表2为6->3,最后生成新得结果链表为1->0->0->0.
 * @author tmd
 *
 */
public class ListAdd2 {
	
	public Node addLists2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int ca = 0;
		int n1 = 0;
		int n2 =0;
		int n = 0;
		Node c1 = head1;
		Node c2 = head2;
		Node node = null;
		Node pre = null;
		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.value : 0;
			n2 = c2 != null ? c2.value : 0;
			n = n1 + n2 +ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverseList(head1);
		reverseList(head2);
		return node;
	}
	
	public Node  reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next =pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListAdd2 lis = new ListAdd2();
		Node head1 = new Node(9);
		head1.next = new Node(3);
		head1.next.next = new Node(7);
		
		Node head2 = new Node(6);
		head2.next = new Node(3);
		Node cur = lis.addLists2(head1, head2);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
