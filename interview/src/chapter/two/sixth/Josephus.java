package chapter.two.sixth;

import chapter.two.Node;

/**
 * 环形单链表的约瑟夫问题
 * 【题目】
 * 据说著名犹太历史学家Josephus有过一下故事：在罗马人占领乔塔帕特后，39个犹太
 * 人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，于是
 * 决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，报数到3的人就自杀，
 * 然后再由下一个人重新报1，报数到3的人再自杀，这样依次下去，直到剩下最后一个人
 * 时，那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。现在请用单向环形链表
 * 描述该结构并呈现整个自杀过程。
 * 输入：一个环形单向链表的头节点head和报数的值m。
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删除。
 * 进阶：
 * 如果链表节点数位N，想在时间复杂度位O（N）时完成原问题的要求，该怎么实现？
 * @author tmd
 *
 */
public class Josephus {
	
	public Node josephusKill(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == m) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Josephus jos = new Josephus();
		Node head = new	Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next =new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next =head;
		int m = 3;
		Node cur = head;
		System.out.println("输入：");
		/*while (cur != null) {
			System.out.print(cur.value +" ");
			cur = cur.next;
		}*/
		System.out.println("");
		head = jos.josephusKill(head, m);
		
		//================================
	    cur = head;
		System.out.println("输出：" + head.value);
		/*while (cur != null) {
			System.out.print(cur.value +" ");
			cur = cur.next;
		}*/
		System.out.println("");
		
	}

}
