package pair;

import java.util.ArrayList;
import java.util.List;

public class SearchTree {
	private Node root;

	public Node getNewNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public Node insert(int key) {
		Node newNode = this.getNewNode(key);
		Node current_parent = null;
		if (this.root == null) {
			this.root = newNode;
			current_parent = this.root;
		} else {
			Node tempNode = this.root;
			// Finding parent of newly created node.
			while (tempNode != null) {
				current_parent = tempNode;
				if (key < tempNode.key) {
					tempNode = tempNode.left;
				} else if (key > tempNode.key) {
					tempNode = tempNode.right;
				} else {
					System.out.println("Given Value Already Exists.");
					return newNode;
				}
			}
		}
		if (key < current_parent.key) {
			current_parent.left = newNode;
		}
		if (key > current_parent.key) {
			current_parent.right = newNode;
		}
		return current_parent;
	}

	public void inOrderTraversal() {
		if (this.root == null) {
			System.out.println("Binary Search Tree is empty.");
			return;
		} else {
			this.inOrderPrint(this.root);
		}
	}

	private void inOrderPrint(Node root) {
		if (root == null) {
			return;
		}
		this.inOrderPrint(root.left);
		System.out.print(root.key + " ");
		this.inOrderPrint(root.right);
	}

	public boolean findPairForGivenSum(int sum) {
		List<Integer> list = new ArrayList<>();
		return this.findPairInTree(root, sum, list);
	}

	private boolean findPairInTree(Node root, int sum, List<Integer> list) {
		if (root == null) {
			return false;
		}
		if (findPairInTree(root.left, sum, list)) {
			return true;
		}
		if (list.contains(sum - root.key)) {
			System.out.println("Pair found for given sum " + sum + " in Tree. Pair := " + "(" + (sum - root.key) + ","
					+ root.key + ")");
			return true;
		} else {
			list.add(root.key);
		}
		return findPairInTree(root.right, sum, list);
	}
}
