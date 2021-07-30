package chapter.two.tenth;

import java.util.Stack;

import chapter.two.Node;

/**
 * �������������������
 * ����������ÿһ���ڵ��ֵ����0~9֮�䣬��ô��������Ϳ��Դ���һ��������
 * ���磺9->3->7,���Դ�������937.
 * �����������������ͷ�ڵ�head1��head2�������ɴ��������������ֵ�ý������
 * ���磺����1Ϊ9->3->7,����2Ϊ6->3,��������µý������Ϊ1->0->0->0.
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
