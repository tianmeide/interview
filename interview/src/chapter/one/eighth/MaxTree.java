package chapter.one.eighth;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 * 【题目】
 * 定义二叉树节点如下：
 * public class Node{
 * 	   public int value;
 *     public Node left;
 *     public Node right;
 *     
 *     public Node(int data){
 *     		this.value = data;
 *     }
 *     一个数组的MaxTree定义如下。
 *     数组必须没有重复元素。
 *     MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
 *     包括MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头。
 *     
 *     给定一个没有重复元素的数组arr,写出生成这个数组的MaxTree的函数，要求如果数组长度为N,则时间复杂度为O(N)、额外空间复杂度为O(N)。
 *     
 * }
 * @author tmd
 *
 */
public class MaxTree {
	public Node getMaxTree(int[] arr){
		Node[] nArr = new Node[arr.length];
		for(int i = 0;i != arr.length; i++){
			nArr[i] = new Node(arr[i]);
		}
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node,Node> lBigMap = new HashMap<Node,Node>();
		HashMap<Node,Node> rBigMap = new HashMap<Node,Node>();
		for(int i = 0;i!=nArr.length;i++){
			Node curNode = nArr[i];
			while((!stack.isEmpty()) && stack.peek().value <curNode.value){
				popStackSetMap(stack,lBigMap);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()){
			popStackSetMap(stack,lBigMap);
		}
		for (int i = nArr.length - 1;i!=-1;i--){
			Node curNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value){
				popStackSetMap(stack,rBigMap);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()){
			popStackSetMap(stack,rBigMap);
		}
		Node head = null;
		for (int i = 0;i!= nArr.length; i++){
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			if (left == null && right == null){
				head = curNode;
			} else if(left == null){
				if( right.left == null){
					right.left = curNode;
				} else{
					right.right = curNode;
				}
			}else if(right == null){
				if(left.left == null){
					left.left = curNode;
				}else{
					left.right = curNode;
				}
			}else{
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null){
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		//test
		System.out.println(head.value);
		return head;
	}
	
	public void popStackSetMap(Stack<Node> stack,HashMap<Node,Node> map){
		Node popNode = stack.pop();
		if (stack.isEmpty()){
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxTree mt = new MaxTree();
		int[] arr = {3,4,5,1,2};
		mt.getMaxTree(arr);
	}

}
