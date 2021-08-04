package chapter.two.thirteenth;

import java.util.HashSet;

import chapter.two.Node;

/**
 * 删除无序单链表中值重复出现的节点
 * @author tmd
 *
 */
public class RemoveRe1 {

	public void removeRep1(Node head) {
		if (head == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while (cur != null) {
			System.out.print(cur.value + " ");
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			} else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
			
		}
		System.out.println();
		System.out.println(set);
		//遍历
		for (Integer i : set) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveRe1 rem = new RemoveRe1();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		rem.removeRep1(head);
	}

}
