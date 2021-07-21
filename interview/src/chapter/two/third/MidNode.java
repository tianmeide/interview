package chapter.two.third;

/**
 * 删除链表的中间节点和a/b处的节点
 * 【题目】
 * 给定链表的头节点head,实现删除链表的中间节点的函数。
 * 例如：
 * 不删除任何节点；
 * 1->2,删除节点1；
 * 1->2->3,删除节点2；
 * 1->2->3->4,删除节点2；
 * 1->2->3->4->5,删除节点3；
 * 进阶：
 * 给定链表的头节点head、整数a和b,实现删除位于a/b处节点的函数。
 * 例如：
 * 链表：1->2->3->4->5,假设a/b的值为r。
 * 如果r等于0，不删除任何节点；
 * 如果r在区间(0,1/5]上，删除节点1；
 * 如果r在区间（1/5,2/5]上，删除节点2；
 * 如果r在区间（2/5,3/5]上，删除节点3；
 * 如果r在区间(3/5,4/5]上，删除节点4；
 * 如果r在区间(4/5,1]上，删除节点5；
 * 如果r大于1，不删除任何节点。
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

		System.out.println("原：");
		
		Node cur0 = head;
		while(cur0.next != null) {
			System.out.print(cur0.value +" ");
			cur0 = cur0.next;
		}
		System.out.println(cur0.value +" ");
		
		head = mn.removeMidNode(head);
		//删除后的结果
		System.out.println("删除后的结果： ");
		Node cur = head;
		while(cur.next != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.print(cur.value + " ");
	}

}
