package chapter.two.fourteenth;

import java.util.Stack;

import chapter.two.Node;

/**
 * 在单链表中删除指定值的节点
 * @author tmd
 *
 */
public class RemoveVal1 {

	public Node removeValue1(Node head, int num) {
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			if (head.value != num) {
				stack.push(head);
			}
			head = head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveVal1 rem = new RemoveVal1();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		int num = 3;
		head = rem.removeValue1(head, num);
		while (head != null) {
			System.out.print(head.value +" ");
			head = head.next;
		}
	}

}
