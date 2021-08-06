package chapter.two.fifteenth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������������ת����˫������
 * @author tmd
 *
 */
public class Conver1 {

	public static Node convert1(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}
	
	public static void inOrderToQueue(Node head, Queue<Node> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
	
	public static void printBSTInOrder(Node head) {
		System.out.print("BST in-order:");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}
	
	public static void inOrderPrint(Node head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}
	public static void printDoubleLinkedList(Node head) {
		System.out.print("Double Linked List:");
		Node end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;	
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);
		printBSTInOrder(head);
		head = convert1(head);
		printDoubleLinkedList(head);
	}

	
}
