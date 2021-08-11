package chapter.two.seventeenth;

import chapter.two.Node;

/**
 * 一种怪异的节点删除方式
 * @author tmd
 *
 */
public class RemoveNodeWire {
	
	public static void removeNodeWired(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			throw new RuntimeException("can not remove last node.");
		}
		node.value = next.value;
		node.next = next.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		removeNodeWired(node);
	}

}
