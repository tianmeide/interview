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
 */
public class Josephus2 {
	
	public Node josephusKill2(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;//tmp -> list size
		while (cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);//tmp -> service node position
		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}
	
	public int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1,m) +m - 1) % i + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Josephus2 jos = new Josephus2();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = head;
		int m =3;
		head = jos.josephusKill2(head, m);
		System.out.println(head.value);
	}

}
