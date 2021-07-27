package chapter.two.seventh;

import chapter.two.Node;

/**
 * 判断一个链表是否为回文结构
 * 【题目】
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1,返回true.
 * 1->2->2->1,返回true.
 * 15->6->15,返回true.
 * 1->2->3,返回false
 * 进阶：
 * 如果链表长度为N，时间复杂度达到O(N),额外空间复杂度达到O(1).
 * 
 * 方法三：
 * 方法三不需要栈和其他数据结构，只用有限几个变量，其额外空间复杂度为O(I),就
 * 可以在时间复杂度为O(N)内完成所有的过程，也就是满足进阶的要求。具体过程如下：
 * 1.首先改变链表右半区的结构，使整个右半区反转，最后指向中间节点。
 * 例如：
 * 链表1->2->3->2->1,通过这一步将其调整之后的结构如图2-2所示。
 * 链表1->2->3->3->2->1,将其调整之后的结构如图2-3所示。
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
 *            图2-2
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
 *                 图2-3
 *                 
 * 2.leftStart 和 rightStart 同时向中间点移动，移动每一步都比较leftStart和rightStart节
 * 点的值，看是否一样。如果都一样，说明链表为回文结构，否则不是回文结构。
 * 3.不管最后返回的是true还是false，在返回前都应该把链表恢复成原来的样子。
 * 4.链表恢复成原来的结构之后，返回检查结果。
 * 粗看起来，虽然方法三的整个过程也没有多少难度，但要想用有限几个变量完成以上
 * 所有的操作，在实现上还是比较考查代码实现能力的。方法三的全部过程请参看如下代码
 * 中的isPalindrome3方法，该方法只申请了三个Node类型的变量。
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
		while (n2.next != null && n2.next.next != null) { //查找中间节点
			n1 = n1.next;//n1 -> 中部
			n2 = n2.next.next;//n2 -> 结尾
		}
		n2 = n1.next;//n2 -> 右部分第一个节点
		n1.next = null;//mid.next -> null
		Node n3 = null;
		while (n2 != null) {//右半区反转
			n3 = n2.next;//n3 -> 保存下一个节点
			n2.next = n1;//下一个反转节点
			n1 = n2;//n1移动
			n2 = n3;//n2移动
		}	
			
		n3 = n1;//n3 ->保存最后一个节点
		n2 = head; //n2 -> 左边第一个节点
		boolean res = true;
		while (n1 != null && n2 != null) {//检查回文
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next;//从左到中间
			n2 = n2.next;//从右到中间
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) {//恢复列表
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
