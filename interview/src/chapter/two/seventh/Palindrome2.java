package chapter.two.seventh;

import java.util.Stack;

import chapter.two.Node;
/**
 * �ж�һ�������Ƿ�Ϊ���Ľṹ
 * ����Ŀ��
 * ����һ�������ͷ�ڵ�head�����жϸ������Ƿ�Ϊ���Ľṹ��
 * ���磺
 * 1->2->1,����true.
 * 1->2->2->1,����true.
 * 15->6->15,����true.
 * 1->2->3,����false
 * ���ף�
 * ���������ΪN��ʱ�临�ӶȴﵽO(N),����ռ临�ӶȴﵽO(1).
 * 
 * ��������
 * �������Է���һ�������Ż�����ȻҲ������ջ�ṹ������ʵ������Ҫ�����еĽڵ㶼
 * ѹ��ջ�У�ֻ��ѹ��һ��Ľڵ㼴�ɡ����ȼ�������ĳ���ΪN�����N��ż����ǰN/2
 * �Ľڵ�������������N/2�Ľڵ�����Ұ��������N�����������Դ������м�Ľڵ㣬
 * ����ǰN/2�Ľڵ�������������N/2�Ľڵ�����Ұ�����
 * ���磺
 * ����1->2->2->1,�����Ϊ��1��2���Ұ���Ϊ��2��1.
 * ����1->2->3->2->1,�����Ϊ��1��2���Ұ���Ϊ��2��1.
 * ���������ǰ�����������Ұ벿��ѹ��ջ�У�ѹ����ɺ��ټ��ջ����ջ��ֵ����
 * ��˳���Ƿ��������벿�ֵ�ֵ���Ӧ��
 * ���磺
 * ����1->2->2->1,������Ұ벿��ѹ��ջ�к󣬴�ջ����ջ��Ϊ1��2.�������벿
 * ��Ҳ��1��2.������������ǻ��Ľṹ��
 * ����1->2->3->2->1,������Ұ벿��ѹ��ջ�к󣬴�ջ����ջ��Ϊ1��2.��������
 * ����Ҳ��1��2����ҵ��������ǻ��Ľṹ��
 * ����1->2->3->3->1,������Ұ벿��ѹ��ջ�к󣬴�ջ����ջ��Ϊ1��3����������
 * ����Ҳ��1��2.������������ǻ��Ľṹ��
 * ����������ֱ�۵����Ϊ������Ұ벿�֡��۹�ȥ����Ȼ����������벿�ֱȽϣ���ͼ2-1��ʾ��
 * �����  |  �Ұ���--->
 *                 |
 * �Ұ�������     �۹�ȥ     |
 *     |<----------v 
 *     ͼ2-1  
 * @author tmd
 *
 */
public class Palindrome2 {
	public boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next !=null) {
			right =right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome2 pal = new Palindrome2();
		Node head = new Node(1);
		head.next = new Node(2);
		//head.next.next = new Node(1);
		head.next.next = new Node(2);
		System.out.println(pal.isPalindrome2(head));
	}

}
