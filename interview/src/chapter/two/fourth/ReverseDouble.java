package chapter.two.fourth;
/**
 * ��ת�����˫������
 * ����Ŀ��
 * �ֱ�ʵ�ַ�ת��������ͷ�ת˫������ĺ���
 * ��Ҫ��
 * ���������ΪN��ʱ�临�Ӷ�Ҫ��ΪO(N),����ռ临�Ӷ�Ҫ��ΪO(I)��
 * @author tmd
 *
 */
public class ReverseDouble {
	public DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseDouble rd = new ReverseDouble();
		DoubleNode head = new DoubleNode(1);
		head.next = new DoubleNode(2);
		head.last = new DoubleNode(3);
		head.next.next = new DoubleNode(4);
		head.last.last = new DoubleNode(5);
		
		System.out.println("ԭ��");
		DoubleNode cur0 = head;
		while (cur0 != null) {
			System.out.print(cur0.value + " ");
			cur0 = cur0.next;
		}
		//System.out.println(cur0.value + " ");
		
		System.out.println("");
		System.out.println("�����Ľ����");
		DoubleNode cur = rd.reverseList(head);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		//System.out.println(cur.value + " ");
	}

}
