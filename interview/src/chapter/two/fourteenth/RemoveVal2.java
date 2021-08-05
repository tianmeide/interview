package chapter.two.fourteenth;

import chapter.two.Node;

/**
 * 在单链表中删除指定值的节点
 * @author tmd
 *
 */
public class RemoveVal2 {

	public Node removeValue2(Node head, int num) {
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveVal2 rem = new RemoveVal2();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		int num = 3;
		head = rem.removeValue2(head, num);
		while (head != null) {
			System.out.print(head.value +" ");
			head = head.next;
		}
	}

}
