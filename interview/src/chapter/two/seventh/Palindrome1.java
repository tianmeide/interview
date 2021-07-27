package chapter.two.seventh;

import java.util.Stack;

import chapter.two.Node;

/**
 * 判断一个链表是否为回文结构
 * 【题目】
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1,返回true.
 * 1->2->2->1,返回true.
 * 15->6->15,返回true.
 * 1->2->3,返回false
 * 进阶：
 * 如果链表长度为N，时间复杂度达到O(N),额外空间复杂度达到O(1).
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
