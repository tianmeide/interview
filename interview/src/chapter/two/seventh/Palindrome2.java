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
 * 
 * 方法二：
 * 方法二对方法一进行了优化，虽然也是利用栈结构，但其实并不需要将所有的节点都
 * 压入栈中，只用压入一半的节点即可。首先假设链表的长度为N，如果N是偶数，前N/2
 * 的节点叫作左半区，后N/2的节点叫作右半区。如果N是奇数，忽略处于最中间的节点，
 * 还是前N/2的节点叫作左半区，后N/2的节点叫作右半区。
 * 例如：
 * 链表1->2->2->1,左半区为：1，2；右半区为：2，1.
 * 链表1->2->3->2->1,左半区为：1，2；右半区为：2，1.
 * 方法二就是把整个链表的右半部分压入栈中，压入完成后，再检查栈顶到栈底值出现
 * 的顺序是否和链表左半部分的值相对应。
 * 例如：
 * 链表1->2->2->1,链表的右半部分压入栈中后，从栈顶到栈底为1，2.链表的左半部
 * 分也是1，2.所以这个链表是回文结构。
 * 链表1->2->3->2->1,链表的右半部分压入栈中后，从栈顶到栈底为1，2.链表的左半
 * 部分也是1，2。锁业这个链表是回文结构。
 * 链表1->2->3->3->1,链表的右半部分压入栈中后，从栈顶到栈底为1，3。链表的左半
 * 部分也是1，2.所以这个链表不是回文结构。
 * 方法二可以直观地理解为链表的右半部分“折过去”，然后让它和左半部分比较，如图2-1所示。
 * 左半区  |  右半区--->
 *                 |
 * 右半区逆序     折过去     |
 *     |<----------v 
 *     图2-1  
 * @author tmd
 *
 */
public class Palindrome2 {
	public boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next !=null) {
			right =right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome2 pal = new Palindrome2();
		Node head = new Node(1);
		head.next = new Node(2);
		//head.next.next = new Node(1);
		head.next.next = new Node(2);
		System.out.println(pal.isPalindrome2(head));
	}

}
