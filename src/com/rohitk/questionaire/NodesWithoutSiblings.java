package com.rohitk.questionaire;

//class to print nodes without sibling in a binary tree.
public class NodesWithoutSiblings {

	@SuppressWarnings("unchecked")
	private static void nodesWithoutSiblings(TreeNode<Integer> rootNode) {
		if (rootNode == null)
			return;
		if (rootNode.left == null && rootNode.right != null)
			System.out.print(rootNode.right.data + " ");
		if (rootNode.right == null && rootNode.left != null)
			System.out.print(rootNode.left.data + " ");

		// recurse for left and right subtrees.
		nodesWithoutSiblings(rootNode.left);
		nodesWithoutSiblings(rootNode.right);
	}

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<Integer>(2);
		TreeNode<Integer> n2 = new TreeNode<Integer>(5);
		TreeNode<Integer> n3 = new TreeNode<Integer>(7);
		TreeNode<Integer> n4 = new TreeNode<Integer>(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		nodesWithoutSiblings(n1);
	}
}
