package chapter.two.first;

/**
 * 打印两个有序链表的公共部分
 * 【题目】
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * 【解答】
 * 本题难度很低，因为是有序链表，所以从两个链表的头开始进行如下判断：
 * 如果head1的值小于head2，则head1往下移动。
 * 如果head2的值小于head1,则head2往下移动。
 * 如果head1的值与head2的值相等，则打印这个值，然后head1与head2都往下移动。
 * head1或head2有任何一个移动到null,整个过程停止。
 * @author tmd
 *
 */
public class CommonPart {
	
	public void printCommonPart(Node head1,Node head2){
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonPart cp = new CommonPart();
		Node head1 = new Node(7);
		head1.next = new Node(1);
		head1.next = new Node(2);
		Node head2 = new Node(7);
		head2.next = new Node(1);
		head2.next = new Node(2);
		cp.printCommonPart(head1, head2);
	}

}
