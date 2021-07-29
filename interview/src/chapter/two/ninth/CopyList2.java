package chapter.two.ninth;

/**
 * ���ƺ������ָ��ڵ������
 * @author tmd
 *
 */
public class CopyList2 {

	public Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;
		//���Ʋ�����ÿһ���ڵ�
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node curCopy = null;
		//���ø��ƽڵ��randָ��
		while (cur != null) {
			next =cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		//���
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyList2 cl = new CopyList2();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		
		Node cur = cl.copyListWithRand2(head);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
