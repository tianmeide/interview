package chapter.two.eighth;

import chapter.two.Node;

/**
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 * ����Ŀ��
 * ����һ�����������ͷ�ڵ�head,�ڵ��ֵ���������ͣ��ٸ���һ������pivot.ʵ��
 * һ����������ĺ��������������Ϊ�󲿷ֶ���ֵС��pivot�Ľڵ㣬�м䲿�ֶ���ֵ����
 * pivot�Ľڵ㣬�Ҳ��ֶ���ֵ����pivot�Ľڵ㡣�����Ҫ���⣬�Ե�����Ľڵ�˳��û��
 * �����Ҫ��
 * ���磺����9->0->4->5->1,pivot=3.
 * ���������������1->0->4->9->5,Ҳ������0->1->9->5->4.��֮�������󲿷ֶ���
 * С��3�Ľڵ㣬�м䲿�ֶ��ǵ���3�Ľڵ㣨�������������Ϊ�գ����Ҳ��ֶ��Ǵ���3��
 * �ڵ㼴�ɡ���ĳ�����ڲ��Ľڵ�˳����Ҫ��
 * ���ף�
 * ��ԭ�����Ҫ��֮����������������Ҫ��
 * �����С����������ֵ��ڲ�Ҳ��˳��Ҫ��Ҫ��ÿ������Ľڵ�����ҵ�˳
 * ����ԭ�����нڵ���Ⱥ����һ�¡�
 * ���磺����9->0->4->5->1,pivot=3.�������������1->1->9->4->5.������ԭ����
 * Ҫ���ͬʱ���󲿷ֽڵ������Ϊ0��1.��Ԫ������Ҳ���ȳ���0�������1���м䲿
 * ���ڱ�����Ϊ�գ��������ۣ��Ҳ��ֽڵ������Ϊ9��4��5.��ԭ������Ҳ���ȳ���9��Ȼ�����4��������5.
 * ���������ΪN,ʱ�临�Ӷ���ﵽO��N��,����ռ临�Ӷ���ﵽO��1��.
 * @author tmd
 *
 */
public class Partition2 {

	public static Node listPartition2(Node head,int pivot) {
		Node sH = null;//С��ͷ
		Node sT = null;//С��β
		Node eH = null;//��ȵ�ͷ
		Node eT = null;//��ȵ�β
		Node bH = null;//���ͷ
		Node bT = null;//���β
		Node next = null;//������һ���ڵ�
		//���еĽڵ�ֽ�����������
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH ==null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		//С�ĺ���ȵ���������
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		//������������
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition2 par = new Partition2();
		Node head = new Node(7);
		head.next = new Node(9);
		head.next.next = new Node(1);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next =new Node(2);
		head.next.next.next.next.next.next =new Node(5);
		int pivot = 5;
		Node node = par.listPartition2(head, pivot);
		while (node != null) {
			System.out.print( node.value +" ");
			node = node.next;
		}
		System.out.println();
	}

}
