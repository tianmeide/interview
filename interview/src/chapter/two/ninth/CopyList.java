package chapter.two.ninth;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 * @author tmd
 *
 */
public class CopyList {

	public Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyList cl = new CopyList();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		
		Node cur = cl.copyListWithRand1(head);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
