package com.rohitk.questionaire;

public class BinaryTreeToDoublyLinkedListInPlace {

	// Node representing the head of the doubly linked list.
	static TreeNode<Integer> head;

	@SuppressWarnings("unchecked")
	private static void binaryTreeToDLL(TreeNode<Integer> rootNode) {
		if (rootNode == null)
			return;

		// Reverse inorder here.
		binaryTreeToDLL(rootNode.right);

		if (head == null) {
			head = rootNode;
		} else {
			TreeNode<Integer> temp = new TreeNode<Integer>(rootNode.data);
			head.left = temp;
			temp.right = head;
			head = temp;
		}

		binaryTreeToDLL(rootNode.left);
	}

	@SuppressWarnings("unchecked")
	private static void printDLL(TreeNode<Integer> head2) {
		if (head == null)
			return;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<Integer>(10);
		TreeNode<Integer> n2 = new TreeNode<Integer>(12);
		TreeNode<Integer> n3 = new TreeNode<Integer>(15);
		TreeNode<Integer> n4 = new TreeNode<Integer>(25);
		TreeNode<Integer> n5 = new TreeNode<Integer>(30);
		TreeNode<Integer> n6 = new TreeNode<Integer>(36);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		binaryTreeToDLL(n1);
		printDLL(head);
	}

}
