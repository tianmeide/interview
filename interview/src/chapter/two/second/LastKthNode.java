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
public class LastKthNode {

	public Node removeLastKthNode(Node head,int lastKth) {
		if (head == null || lastKth < 1 ) {
			return head;
		}
		Node cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		System.out.println(head.value);
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastKthNode ln = new LastKthNode();
		Node head = new Node(1);
		head.next = new Node(2);
		int lastKth = 1;
		ln.removeLastKthNode(head, lastKth);
	}

}
