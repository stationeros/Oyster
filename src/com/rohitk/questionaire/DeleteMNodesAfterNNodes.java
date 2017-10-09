package com.rohitk.questionaire;

public class DeleteMNodesAfterNNodes {
	
	private static LinkedListNode<Integer> skipNodesAndDelete(LinkedListNode start, int m, int n) {
		if (start == null)
			return null;
		if (start.next == null)
			return start;
		LinkedListNode<Integer> temp = start;
		while (temp != null) {
			for (int i = 0; i < n - 1; i++) {
				if (temp != null)
					temp = temp.next;
			}
			LinkedListNode<Integer> end = temp.next;
			for (int i = 0; i < m; i++) {
				if (end != null)
					end = end.next;
			}
			temp.next = end;
			temp = end;
		}
		return start;
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> n1 = new LinkedListNode(1);
		LinkedListNode<Integer> n2 = new LinkedListNode(2);
		LinkedListNode<Integer> n3 = new LinkedListNode(3);
		LinkedListNode<Integer> n4 = new LinkedListNode(4);
		LinkedListNode<Integer> n5 = new LinkedListNode(5);
		LinkedListNode<Integer> n6 = new LinkedListNode(6);
		LinkedListNode<Integer> n7 = new LinkedListNode(7);
		LinkedListNode<Integer> n8 = new LinkedListNode(8);
		LinkedListNode<Integer> n9 = new LinkedListNode(9);
		LinkedListNode<Integer> n10 = new LinkedListNode(10);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		int m=3;
		int n=2;
		LinkedListNode<Integer> result = skipNodesAndDelete(n1, m, n);
		while(result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}
}
