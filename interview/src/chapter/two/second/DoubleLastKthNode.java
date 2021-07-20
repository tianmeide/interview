package chapter.two.second;

/**
 * �ڵ������˫������ɾ��������K���ڵ�
 * ����Ŀ��
 * �ֱ�ʵ������������һ������ɾ���������е�����K���ڵ㣬��һ������ɾ��˫�����е�����K���ڵ㡣
 * ��Ҫ��
 * ���������ΪN,ʱ�临�ӶȴﵽO(N),����ռ临�ӶȴﵽO��I��.
 * @author tmd
 *
 */
public class DoubleLastKthNode {
	
	public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		DoubleNode cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
			head.last = null;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if (newNext != null) {
				newNext.last = cur;
			}
		}
		System.out.println(head.value);
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLastKthNode dln = new DoubleLastKthNode();
		DoubleNode head = new DoubleNode(7);
		head.next = new DoubleNode(9);
		head.last = new DoubleNode(11);
		int lastKth = 1;
		dln.removeLastKthNode(head, lastKth);
	}

}
