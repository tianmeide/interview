package chapter.two.fifteenth;

/**
 * 将搜索二叉树转换成双向链表
 * @author tmd
 *
 */
public class Conver2 {

	public Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}
	
	public Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left);//左边结束
		Node rightE = process(head.right);//右边结束
		Node leftS = leftE != null ? leftE.right : null; //左边开始
		Node rightS = rightE != null ? rightE.right : null; //右边开始
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
