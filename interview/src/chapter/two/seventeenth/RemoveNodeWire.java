package chapter.two.seventeenth;

import chapter.two.Node;

/**
 * һ�ֹ���Ľڵ�ɾ����ʽ
 * @author tmd
 *
 */
public class RemoveNodeWire {
	
	public static void removeNodeWired(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			throw new RuntimeException("can not remove last node.");
		}
		node.value = next.value;
		node.next = next.next;
	}
	public static void printLinkedList(Node head) {
		System.out.print("Linked list:");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node node = head.next;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		node = head.next;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);
		
	}

}
