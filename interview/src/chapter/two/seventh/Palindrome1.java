package chapter.two.seventh;

import java.util.Stack;

import chapter.two.Node;

/**
 * �ж�һ�������Ƿ�Ϊ���Ľṹ
 * ����Ŀ��
 * ����һ�������ͷ�ڵ�head�����жϸ������Ƿ�Ϊ���Ľṹ��
 * ���磺
 * 1->2->1,����true.
 * 1->2->2->1,����true.
 * 15->6->15,����true.
 * 1->2->3,����false
 * ���ף�
 * ���������ΪN��ʱ�临�ӶȴﵽO(N),����ռ临�ӶȴﵽO(1).
 * @author tmd
 *
 */
public class Palindrome1 {

	public boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome1 pal = new Palindrome1();
		Node head = new Node(1);
		head.next = new Node(2);
		//head.next.next = new Node(3);
		head.next.next = new Node(2);
		//head.next.next.next =new Node(4);
		head.next.next.next =new Node(1);
		System.out.println(pal.isPalindrome1(head));
	}

}
