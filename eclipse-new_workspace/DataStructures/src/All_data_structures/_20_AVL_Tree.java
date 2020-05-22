package All_data_structures;

import java.util.Scanner;

public class _20_AVL_Tree {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;

		public Node(int item) {
			this.data = item;
			this.height = 1;
		}
	}

	private Node root;

	public void insert(int item) {
		this.root = this.insert(this.root, item);
	}

	private Node insert(Node parent, int item) {

		if (parent == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (parent.data > item) {
			parent.left = this.insert(parent.left, item);
		} else {
			parent.right = this.insert(parent.right, item);
		}

		parent.height = this.height(parent);
		int bal_fac = this.bf(parent);

		// LL
		if (bal_fac > 1 && item < parent.left.data) {
			return this.rightRotate(parent);
		}

		// RR
		if (bal_fac < -1 && item > parent.right.data) {
			return this.leftRotate(parent);
		}

		// LR
		if (bal_fac > 1 && item > parent.left.data) {
			parent.left = this.leftRotate(parent.left);
			return this.rightRotate(parent);
		}

		// RL
		if (bal_fac < -1 && item < parent.right.data) {
			parent.right = this.rightRotate(parent.right);
			return this.leftRotate(parent);
		}

		return parent;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = " ";
		if (node.left == null) {
			str += " ." + " -> ";
		} else {
			str += node.left.data + " -> ";
		}

		str += node.data;

		if (node.right == null) {
			str += " <- " + ". ";
		} else {
			str += " <- " + node.right.data;
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node parent) {

		if (parent == null) {
			return 0;
		}

		return Math.max(this.height(parent.left), this.height(parent.right)) + 1;

	}

	private int bf(Node parent) {

		if (parent == null) {
			return 0;
		}

		return this.height(parent.left) - this.height(parent.right);
	}

	private Node rightRotate(Node c) {

		Node b = c.left;
		Node T3 = b.right;

		b.right = c;
		c.left = T3;

		c.height = this.height(c);
		b.height = this.height(b);

		return b;
	}

	private Node leftRotate(Node c) {

		Node b = c.right;
		Node T3 = b.left;

		b.left = c;
		c.right = T3;

		c.height = this.height(c);
		b.height = this.height(b);

		return b;

	}

}
