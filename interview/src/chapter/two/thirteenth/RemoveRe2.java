package chapter.two.thirteenth;

import chapter.two.Node;

/**
 * 删除无序单链表中值重复出现的节点
 * @author tmd
 *
 */
public class RemoveRe2 {

	public void removeRep2(Node head) {
		Node cur = head;
		Node pre = null;
		Node next = null;
		
		while (cur != null) {
			pre = cur;
			next = cur.next;
			while (next != null) {
				if (cur.value == next.value) {
					pre.next = next.next;
				} else {
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveRe2 rem = new RemoveRe2();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		
		rem.removeRep2(head);
	}

}
