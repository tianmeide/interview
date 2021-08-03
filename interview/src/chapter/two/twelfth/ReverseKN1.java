package chapter.two.twelfth;

import java.util.Stack;

import chapter.two.Node;

/**
 * 将单链表的每K个节点之间逆序
 * @author tmd
 *
 */
public class ReverseKN1 {

	public Node reverseKNodes1(Node head, int K) {
		if (K < 2 ) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == K) {
				pre = resign1(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	
	public Node resign1(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty() ) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseKN1 rev = new ReverseKN1();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next =new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next =new Node(8);
		int K = 3;
		Node cur = rev.reverseKNodes1(head, K);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
