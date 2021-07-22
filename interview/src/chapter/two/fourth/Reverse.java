package chapter.two.fourth;

/**
 * 反转单向和双向链表
 * 【题目】
 * 分别实现反转单向链表和反转双向链表的函数
 * 【要求】
 * 如果链表长度为N，时间复杂度要求为O(N),额外空间复杂度要求为O(I)。
 * @author tmd
 *
 */
public class Reverse {
	public Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse rev = new Reverse();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		
		System.out.println("原：");
		Node cur0 = head;
		while (cur0.next != null){
			System.out.print(cur0.value + " ");
			cur0 = cur0.next;
		}
		System.out.println(cur0.value + " ");
		
		Node cur = rev.reverseList(head);
		System.out.println("处理后的结果： ");
		while (cur.next != null){
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.print(cur.value + " ");
	}

}
