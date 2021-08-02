package chapter.two.eleventh;

import chapter.two.Node;
import chapter.two.eleventh.BothLoop3;

/**
 * 两个单链表相交的一系列问题
 * @author tmd
 *
 */
public class IntersectNode {

	public Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = new LoopNode().getLoopNode(head1);
		Node loop2 = new LoopNode().getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return new NoLoop2().noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return new BothLoop3().bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectNode inte = new IntersectNode();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		Node head2 = new Node(1);
		head2.next = new Node(2);
		
		Node cur = inte.getIntersectNode(head1, head2);
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}

}
