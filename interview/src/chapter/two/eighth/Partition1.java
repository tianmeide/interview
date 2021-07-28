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
public class Partition1 {

	public Node listPartition1(Node head,int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0;i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr,pivot);
		for (i = 1;i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}
	
	public void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}
	
	public void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition1 par = new Partition1();
		Node head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);
		int pivot = 3;
		Node node = par.listPartition1(head, pivot);
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

}
