package chapter.two.first;

/**
 * ��ӡ������������Ĺ�������
 * ����Ŀ��
 * �����������������ͷָ��head1��head2����ӡ��������Ĺ������֡�
 * �����
 * �����ѶȺܵͣ���Ϊ�������������Դ����������ͷ��ʼ���������жϣ�
 * ���head1��ֵС��head2����head1�����ƶ���
 * ���head2��ֵС��head1,��head2�����ƶ���
 * ���head1��ֵ��head2��ֵ��ȣ����ӡ���ֵ��Ȼ��head1��head2�������ƶ���
 * head1��head2���κ�һ���ƶ���null,��������ֹͣ��
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
