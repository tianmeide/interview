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
		
		System.out.println("ԭ��");
		Node cur0 = head;
		while (cur0.next != null){
			System.out.print(cur0.value + " ");
			cur0 = cur0.next;
		}
		System.out.println(cur0.value + " ");
		
		Node cur = rev.reverseList(head);
		System.out.println("�����Ľ���� ");
		while (cur.next != null){
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.print(cur.value + " ");
	}

}
