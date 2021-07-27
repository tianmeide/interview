package chapter.two.seventh;

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
 * ����������Ҫջ���������ݽṹ��ֻ�����޼��������������ռ临�Ӷ�ΪO(I),��
 * ������ʱ�临�Ӷ�ΪO(N)��������еĹ��̣�Ҳ����������׵�Ҫ�󡣾���������£�
 * 1.���ȸı������Ұ����Ľṹ��ʹ�����Ұ�����ת�����ָ���м�ڵ㡣
 * ���磺
 * ����1->2->3->2->1,ͨ����һ���������֮��Ľṹ��ͼ2-2��ʾ��
 * ����1->2->3->3->2->1,�������֮��Ľṹ��ͼ2-3��ʾ��
 *           null
 *             ^
 *             |
 *            3
 *         ^        ^
 *        2        2
 *       ^            ^
 *       1           1
 *      ^              ^
 *    left start  right start
 *            ͼ2-2
 *            
 *              null
 *            ^       ^
 *           3        3 
 *           ^           ^
 *          2            2
 *          ^               ^
 *         1                1
 *         ^                  ^
 *        left start  right start
 *                 ͼ2-3
 *                 
 * 2.leftStart �� rightStart ͬʱ���м���ƶ����ƶ�ÿһ�����Ƚ�leftStart��rightStart��
 * ���ֵ�����Ƿ�һ���������һ����˵������Ϊ���Ľṹ�������ǻ��Ľṹ��
 * 3.������󷵻ص���true����false���ڷ���ǰ��Ӧ�ð�����ָ���ԭ�������ӡ�
 * 4.����ָ���ԭ���Ľṹ֮�󣬷��ؼ������
 * �ֿ���������Ȼ����������������Ҳû�ж����Ѷȣ���Ҫ�������޼��������������
 * ���еĲ�������ʵ���ϻ��ǱȽϿ������ʵ�������ġ���������ȫ��������ο����´���
 * �е�isPalindrome3�������÷���ֻ����������Node���͵ı�����
 * @author tmd
 *
 */
public class Palindrome3 {

	public boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while (n2.next != null && n2.next.next != null) { //�����м�ڵ�
			n1 = n1.next;//n1 -> �в�
			n2 = n2.next.next;//n2 -> ��β
		}
		n2 = n1.next;//n2 -> �Ҳ��ֵ�һ���ڵ�
		n1.next = null;//mid.next -> null
		Node n3 = null;
		while (n2 != null) {//�Ұ�����ת
			n3 = n2.next;//n3 -> ������һ���ڵ�
			n2.next = n1;//��һ����ת�ڵ�
			n1 = n2;//n1�ƶ�
			n2 = n3;//n2�ƶ�
		}	
			
		n3 = n1;//n3 ->�������һ���ڵ�
		n2 = head; //n2 -> ��ߵ�һ���ڵ�
		boolean res = true;
		while (n1 != null && n2 != null) {//������
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next;//�����м�
			n2 = n2.next;//���ҵ��м�
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) {//�ָ��б�
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome3 pal = new Palindrome3();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		System.out.println(pal.isPalindrome3(head)); 
	}

}
