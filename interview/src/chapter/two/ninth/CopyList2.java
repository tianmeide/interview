package chapter.two.ninth;

/**
 * 复制含有随机指针节点的链表
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
		//复制并链接每一个节点
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node curCopy = null;
		//设置复制节点的rand指针
		while (cur != null) {
			next =cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		//拆分
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
