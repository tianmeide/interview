package chapter.two.fifth;

/**
 * ��ת���ֵ�������
 * ����Ŀ��
 * ����һ�����������ͷ�ڵ�head���Լ���������from��to,�ڵ��������ϰѵ�from���ڵ㵽��to���ڵ���һ���ֽ��з�ת��
 * ���磺
 * 1->2->3->4->5->null,from = 2,to=4
 * �������Ϊ��1->4->->3->2->5->null
 * ���磺
 * 1->2->3->null,from=1,to=3
 * �������Ϊ��3->2->1->null
 * ��Ҫ��
 * 1�����������ΪN,ʱ�临�Ӷ�Ҫ��ΪO(N),����ռ临�Ӷ�Ҫ��ΪO��I��.
 * 2�����������1<=from<=to<=N,���õ�����
 * @author tmd
 *
 */
public class Reverse {
	public Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len) {
			return head;
		}
		node1 = fPre == null ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while (node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse rev = new Reverse();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		System.out.println("����ǰ��");
		printNode(head);
		
		int from = 2;
		int to = 3;
		
		System.out.println("�����");
		printNode(rev.reversePart(head, from, to));
		
	}
	public static void printNode(Node head) {

		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
}
