package com.rohitk.questionaire;

// Class to print all the nodes which are at k distance from root node in a
// binary tree.
public class NodesKDistanceFromRoot {

	private static void printTreeNodesKDistanceFromRoot(TreeNode rootTreeNode, int k) {
		if (rootTreeNode == null)
			return;
		if (k == 0)
			System.out.print(rootTreeNode.data + " ");
		if (k > 0) {
			printTreeNodesKDistanceFromRoot(rootTreeNode.left, k - 1);
			printTreeNodesKDistanceFromRoot(rootTreeNode.right, k - 1);
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> node1 = new TreeNode(9);
		TreeNode<Integer> node2 = new TreeNode(7);
		TreeNode<Integer> node3 = new TreeNode(10);
		TreeNode<Integer> node4 = new TreeNode(11);
		TreeNode<Integer> node5 = new TreeNode(12);
		TreeNode<Integer> node6 = new TreeNode(13);
		TreeNode<Integer> node7 = new TreeNode(14);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		printTreeNodesKDistanceFromRoot(node1, 2);
	}

}
