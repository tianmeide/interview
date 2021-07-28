package chapter.two.eighth;

import chapter.two.Node;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】
 * 给定一个单向链表的头节点head,节点的值类型是整型，再给定一个整数pivot.实现
 * 一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于
 * pivot的节点，右部分都是值大于pivot的节点。除这个要求外，对调整后的节点顺序没有
 * 更多的要求。
 * 例如：链表9->0->4->5->1,pivot=3.
 * 调整后链表可以是1->0->4->9->5,也可以是0->1->9->5->4.总之，满足左部分都是
 * 小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的
 * 节点即可。对某部分内部的节点顺序不做要求。
 * 进阶：
 * 在原问题的要求之上再增加如下两个要求。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺
 * 序与原链表中节点的先后次序一致。
 * 例如：链表9->0->4->5->1,pivot=3.调整后的链表是1->1->9->4->5.在满足原问题
 * 要求的同时，左部分节点从左到右为0、1.在元链表中也是先出现0，后出现1；中间部
 * 分在本例中为空，不再讨论；右部分节点从左到右为9、4、5.在原链表中也是先出现9，然后出现4，最后出现5.
 * 如果链表长度为N,时间复杂度请达到O（N）,额外空间复杂度请达到O（1）.
 * @author tmd
 *
 */
public class Partition2 {

	public static Node listPartition2(Node head,int pivot) {
		Node sH = null;//小的头
		Node sT = null;//小的尾
		Node eH = null;//相等的头
		Node eT = null;//相等的尾
		Node bH = null;//大的头
		Node bT = null;//大的尾
		Node next = null;//保存下一个节点
		//所有的节点分进三个链表中
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH ==null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		//小的和相等的重新连接
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		//所有重新连接
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition2 par = new Partition2();
		Node head = new Node(7);
		head.next = new Node(9);
		head.next.next = new Node(1);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next =new Node(2);
		head.next.next.next.next.next.next =new Node(5);
		int pivot = 5;
		Node node = par.listPartition2(head, pivot);
		while (node != null) {
			System.out.print( node.value +" ");
			node = node.next;
		}
		System.out.println();
	}

}
