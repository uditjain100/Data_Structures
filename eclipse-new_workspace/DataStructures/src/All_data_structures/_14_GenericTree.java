package All_data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _14_GenericTree {

	Scanner scn = new Scanner(System.in);

	public class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public _14_GenericTree() {
		this.root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Give the data of parent Node -> ");
		} else {
			System.out.println("Give the data of " + ith + " child " + parent.data + " Node -> ");
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println("Give the Number of children -> ");
		int noc = scn.nextInt();
		for (int i = 0; i < noc; i++) {
			Node child = takeInput(nn, i);
			nn.children.add(child);
		}

		return nn;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node parent) {

		String str = parent.data + " -> ";
		for (Node child : parent.children) {
			str += child.data + " " + ",";
		}

		System.out.println(str);

		for (Node child : parent.children) {
			display(child);
		}
	}

	public int size() {
		return this.size(this.root);
	}

	private int size(Node parent) {

		int ts = 0;
		for (Node child : parent.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node parent) {

		int th = -1;
		for (Node child : parent.children) {
			int ch = height(child);
			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node parent) {

		int tmax = Integer.MIN_VALUE;
		if (parent.data > tmax) {
			tmax = parent.data;
		}

		for (Node child : parent.children) {
			int cmax = max(child);
			if (cmax > tmax) {
				tmax = cmax;
			}
		}

		return tmax;
	}

	public boolean find() {
		int item = scn.nextInt();
		return this.find(this.root, item);
	}

	private boolean find(Node parent, int item) {

		if (parent.data == item) {
			return true;
		}

		for (Node child : parent.children) {
			boolean f = this.find(child, item);
			if (f) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node parent) {

		int left = 0;
		int right = parent.children.size() - 1;

		while (left < right) {
			Node rn = parent.children.get(right);
			Node ln = parent.children.get(left);

			parent.children.set(left, rn);
			parent.children.set(right, ln);

			left++;
			right--;
		}
		for (Node child : parent.children) {
			mirror(child);
		}
	}

	public void greater() {
		int item = scn.nextInt();
		ArrayList<Integer> ans = this.greater(this.root, item);
		System.out.println(ans);
		int min = this.min(ans);
		System.out.println(min);
	}

	private int min(ArrayList<Integer> ans) {
		if (ans.size() == 0) {
			return -1;
		}
		return Collections.min(ans);
	}

	private ArrayList<Integer> greater(Node parent, int item) {

		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (parent.data > item) {
			ans.add(parent.data);
		}

		for (Node child : parent.children) {
			ans = greater(child, item);
			if (child.data > item) {
				ans.add(child.data);
			}
		}

		return ans;
	}

	public void preorder() {
		this.preorder(this.root);
	}

	private void preorder(Node parent) {
		System.out.print(parent.data + " ");
		for (Node child : parent.children) {
			this.preorder(child);
		}
	}

	public void postorder() {
		this.postorder(this.root);
	}

	private void postorder(Node parent) {
		for (Node child : parent.children) {
			this.postorder(child);
		}
		System.out.print(parent.data + " ");
	}

	public void levelorder() {
		this.levelorder(this.root);
	}

	private void levelorder(Node parent) {

		LinkedList<Node> queue = new LinkedList<_14_GenericTree.Node>();
		queue.addLast(parent);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}
	}
	/*
	 * 
	 * public class Heapmover {
	 * 
	 * int size; boolean find; int max = Integer.MIN_VALUE; int ht; Node pred; Node
	 * succ; Node jl;
	 * 
	 * }
	 * 
	 * public void multisolver(int item) {
	 * 
	 * Heapmover mover = new Heapmover(); multisolver(this.root, item, 0, mover);
	 * 
	 * System.out.println("Max : " + mover.max); System.out.println("find : " +
	 * mover.find); System.out.println("size : " + mover.size);
	 * System.out.println("ht : " + mover.ht); System.out.println("Pred :" +
	 * (mover.pred != null && mover.find == true ? mover.pred.data : null));
	 * System.out.println("Succ :" + (mover.succ == null ? null : mover.pred.data));
	 * System.out.println("jl :" + (mover.jl != null ? null : mover.pred.data)); }
	 * 
	 * private void multisolver(Node node, int item, int count, Heapmover mover) {
	 * 
	 * mover.size++;
	 * 
	 * if (node.data > mover.max) { mover.max = node.data; } if (mover.find == true
	 * && mover.succ == null) { mover.succ.data = node.data; }
	 * 
	 * if (node.data == item) { mover.find = true; } if (mover.find == false) {
	 * mover.pred.data = node.data; } if (count > mover.ht) { mover.ht = count; } if
	 * (node.data > item) { if (node.data < mover.jl.data) { mover.jl.data =
	 * node.data; } } for (Node child : node.children) { multisolver(child, item,
	 * count + 1, mover); } }
	 */

}
