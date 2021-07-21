package chapter.two.third;

/**
 * ɾ��������м�ڵ��a/b���Ľڵ�
 * ����Ŀ��
 * ���������ͷ�ڵ�head,ʵ��ɾ��������м�ڵ�ĺ�����
 * ���磺
 * ��ɾ���κνڵ㣻
 * 1->2,ɾ���ڵ�1��
 * 1->2->3,ɾ���ڵ�2��
 * 1->2->3->4,ɾ���ڵ�2��
 * 1->2->3->4->5,ɾ���ڵ�3��
 * ���ף�
 * ���������ͷ�ڵ�head������a��b,ʵ��ɾ��λ��a/b���ڵ�ĺ�����
 * ���磺
 * ����1->2->3->4->5,����a/b��ֵΪr��
 * ���r����0����ɾ���κνڵ㣻
 * ���r������(0,1/5]�ϣ�ɾ���ڵ�1��
 * ���r�����䣨1/5,2/5]�ϣ�ɾ���ڵ�2��
 * ���r�����䣨2/5,3/5]�ϣ�ɾ���ڵ�3��
 * ���r������(3/5,4/5]�ϣ�ɾ���ڵ�4��
 * ���r������(4/5,1]�ϣ�ɾ���ڵ�5��
 * ���r����1����ɾ���κνڵ㡣
 * @author tmd
 *
 */
public class MidNode {

	public Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node pre = head;
		//System.out.println("pre: " + pre.value);
		Node cur = head.next.next;
		//System.out.println("cur: " +cur.value);
		while (cur.next != null && cur.next.next != null) {
			//System.out.println("pre.next: " + pre.next.value);
			pre = pre.next;
			//System.out.println("pre: " +pre.value);
			//System.out.println("cur.next.next: " + cur.next.next.value);
			cur = cur.next.next;
			
			//System.out.println("cur: " + cur.value);
		}
		//System.out.println("pre.next.next: " + pre.next.next.value);
		pre.next = pre.next.next;

		//System.out.println("pre.next: " + pre.next.value);
		//System.out.println("head: " + head.value);
		return head;
	}
	
	public Node removeByRatio(Node head,int a,int b){
		if (a < 1 || a > b) {
			return head;
		}
		int n = 0;
		Node cur = head;
		while (cur != null) {
			n++;
			cur = cur.next;
		}
		n = (int)Math.ceil(((double) (a * n)) / (double) b);
		if (n == 1) {
			head = head.next;
		}
		if (n > 1) {
			cur = head;
			while (--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MidNode mn = new MidNode();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		//head.next.next.next.next = new Node(5);

		System.out.println("ԭ��");
		
		Node cur0 = head;
		while(cur0.next != null) {
			System.out.print(cur0.value +" ");
			cur0 = cur0.next;
		}
		System.out.println(cur0.value +" ");
		
		head = mn.removeMidNode(head);
		//ɾ����Ľ��
		System.out.println("ɾ����Ľ���� ");
		Node cur = head;
		while(cur.next != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.print(cur.value + " ");
	}

}
