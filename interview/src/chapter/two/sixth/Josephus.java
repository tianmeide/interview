package chapter.two.sixth;

import chapter.two.Node;

/**
 * ���ε������Լɪ������
 * ����Ŀ��
 * ��˵������̫��ʷѧ��Josephus�й�һ�¹��£���������ռ���������غ�39����̫
 * ����Josephus���������Ѷ㵽һ�����У�39����̫�˾�����Ը��Ҳ��Ҫ������ץ��������
 * ������һ����ɱ��ʽ��41�����ų�һ��ԲȦ���ɵ�1���˿�ʼ������������3���˾���ɱ��
 * Ȼ��������һ�������±�1��������3��������ɱ������������ȥ��ֱ��ʣ�����һ����
 * ʱ���Ǹ��˿�������ѡ���Լ������ˡ������������Լɪ�����⡣�������õ���������
 * �����ýṹ������������ɱ���̡�
 * ���룺һ�����ε��������ͷ�ڵ�head�ͱ�����ֵm��
 * ���أ�������������Ľڵ㣬������ڵ��Լ���ɻ��ε������������ڵ㶼ɾ����
 * ���ף�
 * �������ڵ���λN������ʱ�临�Ӷ�λO��N��ʱ���ԭ�����Ҫ�󣬸���ôʵ�֣�
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
		System.out.println("���룺");
		/*while (cur != null) {
			System.out.print(cur.value +" ");
			cur = cur.next;
		}*/
		System.out.println("");
		head = jos.josephusKill(head, m);
		
		//================================
	    cur = head;
		System.out.println("�����" + head.value);
		/*while (cur != null) {
			System.out.print(cur.value +" ");
			cur = cur.next;
		}*/
		System.out.println("");
		
	}

}
