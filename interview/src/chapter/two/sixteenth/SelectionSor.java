package chapter.two.sixteenth;

import chapter.two.Node;

/**
 * �������ѡ������
 * @author tmd
 *
 */
public class SelectionSor {

	public static Node selectionSort(Node head) {
		Node tail = null; //���򲿷�β��
		Node cur = head;//δ���򲿷�ͷ��
		Node smallPre = null;//��С�ڵ��ǰһ���ڵ�
		Node small = null;//��С�Ľڵ�
		while (cur != null) {
			small = cur;
			smallPre = getSmallestPreNode(cur);
			if (smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small ? cur.next : cur;
			if (tail == null) {
				head = small;
			} else {
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}
	
	public static Node getSmallestPreNode(Node head) {
		Node smallPre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		while (cur != null) {
			if (cur.value < small.value) {
				smallPre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(2);
		head.next = new Node(1);
		head.next.next = new Node(3);
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.print(" | ");
		Node headNew = selectionSort(head);
		while (headNew != null) {
			System.out.print(headNew.value + " ");
			headNew = headNew.next;
		}
	}

}
