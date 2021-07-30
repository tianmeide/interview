package chapter.two.tenth;

import java.util.Stack;

import chapter.two.Node;

/**
 * 两个链表生成相加链表
 * 假设链表中每一个节点的值都再0~9之间，那么链表整体就可以代表一个整数。
 * 例如：9->3->7,可以代表整数937.
 * 给定两个这种链表的头节点head1和head2，请生成代表两个整数相加值得结果链表。
 * 例如：链表1为9->3->7,链表2为6->3,最后生成新得结果链表为1->0->0->0.
 * @author tmd
 *
 */
public class ListAdd1 {

	public Node addLists1(Node head1, Node head2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (head1 != null) {
			s1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			s2.push(head2.value);
			head2 = head2.next;
		}
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node node = null;
		Node pre = null;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListAdd1 lis = new ListAdd1();
		Node head1 = new Node(9);
		head1.next = new Node(3);
		head1.next.next = new Node(7);
		
		Node head2 = new Node(6);
		head2.next = new Node(3);
		Node cur = lis.addLists1(head1, head2);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
