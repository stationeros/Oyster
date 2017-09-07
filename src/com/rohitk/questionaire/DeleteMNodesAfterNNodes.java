package com.rohitk.questionaire;

class Node<T> {
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
	}
}

public class DeleteMNodesAfterNNodes {
	
	private static Node skipNodesAndDelete(Node start, int m, int n) {
		if (start == null)
			return null;
		if (start.next == null)
			return start;
		Node temp = start;
		while (temp != null) {
			for (int i = 0; i < n - 1; i++) {
				if (temp != null)
					temp = temp.next;
			}
			Node end = temp.next;
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
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
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
		Node result = skipNodesAndDelete(n1, m, n);
		while(result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}
}
