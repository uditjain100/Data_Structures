package All_data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _16_BinaryTree {

	Scanner scn = new Scanner(System.in);

	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public _16_BinaryTree() {
		this.root = takeInput(null, false);
	}

	public Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Give the data of parent Node -> ");
		} else {
			if (ilc) {
				System.out.println("Give the data of right node of " + parent.data + " node ->");
			} else {
				System.out.println("Give the data of left node of " + parent.data + " node ->");
			}
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println("Is their any left child ? ");
		boolean isleftchild = scn.nextBoolean();
		if (isleftchild) {
			nn.left = this.takeInput(nn, false);
		}

		System.out.println("Is their any right child ? ");
		boolean isrightchild = scn.nextBoolean();
		if (isrightchild) {
			nn.right = this.takeInput(nn, true);
		}

		return nn;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node parent) {

		if (parent == null) {
			return;
		}

		String str = " ";
		if (parent.left != null) {
			str += parent.left.data + " -> ";
		} else {
			str += " . " + " -> ";
		}

		str += parent.data;

		if (parent.right != null) {
			str += " -> " + parent.right.data;
		} else {
			str += " . " + " -> ";
		}

		System.out.println(str);

		display(parent.left);
		display(parent.right);

	}

	public int size() {
		return this.size(this.root);
	}

	private int size(Node parent) {

		int ts = 0;
		if (parent == null) {
			return 0;
		}
		int ls = this.size(parent.left);
		int rs = this.size(parent.right);

		return ls + rs + 1;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node parent) {

		if (parent == null) {
			return 0;
		}

		int lh = height(parent.left);
		int rh = height(parent.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean find() {
		int item = scn.nextInt();
		return this.find(this.root, item);
	}

	private boolean find(Node parent, int item) {

		if (parent == null) {
			return false;
		}

		boolean leftitem = find(parent.left, item);
		boolean rightitem = find(parent.right, item);

		return leftitem || rightitem;

	}

	public int max() {
		return this.max(this.root);
	}

	public int max(Node parent) {

		int tmax = parent.data;
		if (parent == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = this.max(parent.left);
		if (lmax < tmax) {
			lmax = tmax;
		}
		int rmax = this.max(parent.right);
		if (rmax < lmax) {
			rmax = lmax;
		}
		return rmax;
	}

	public int Diameter() {
		return this.Diameter(this.root);
	}

	private int Diameter(Node parent) {

		if (parent == null) {
			return 0;
		}

		int ld = this.Diameter(parent.left);
		int rd = this.Diameter(parent.right);
		int sw = height(parent.left) + height(parent.right) + 2;

		return Math.max(sw, Math.max(ld, rd));
	}

	public void preorder() {
		this.preorder(this.root);
	}

	private void preorder(Node parent) {

		if (parent == null) {
			return;
		}

		System.out.print(parent.data + " ");
		preorder(parent.left);
		preorder(parent.right);

	}

	public void postorder() {
		this.postorder(this.root);
	}

	private void postorder(Node parent) {

		if (parent == null) {
			return;
		}

		postorder(parent.left);
		postorder(parent.right);
		System.out.print(parent.data + " ");

	}

	public void inorder() {
		this.inorder(this.root);
	}

	private void inorder(Node parent) {

		if (parent == null) {
			return;
		}

		inorder(parent.left);
		System.out.print(parent.data + " ");
		inorder(parent.right);

	}

	public void levelorder() {
		this.levelorder(this.root);
	}

	private void levelorder(Node parent) {

		LinkedList<Node> queue = new LinkedList<_16_BinaryTree.Node>();
		queue.add(parent);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			this.levelorder(rn.left);
			this.levelorder(rn.right);
		}

	}

	public void greater() {
		int item = scn.nextInt();
		ArrayList<Integer> ans = this.greater(this.root, item);
		System.out.println(ans);
		int min = this.min(ans);
		System.out.println(min);
	}

	private int min(ArrayList<Integer> list) {

		if (list.size() == 0) {
			return -1;
		}

		return Collections.min(list);
	}

	private ArrayList<Integer> greater(Node parent, int item) {

		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (parent.data > item) {
			ans.add(parent.data);
		}

		if (parent.left != null) {
			ans = greater(parent.left, item);
			if (parent.left.data > item) {
				ans.add(parent.left.data);
			}
		}

		if (parent.right != null) {
			ans = greater(parent.right, item);
			if (parent.right.data > item) {
				ans.add(parent.right.data);
			}
		}

		return ans;

	}

	public class Diapair {
		int dia = 0;
		int ht = -1;

	}

	public int Dia2() {
		return Dia2(root).dia;
	}

	private Diapair Dia2(Node node) {

		if (node == null) {
			Diapair dp = new Diapair();
			return dp;
		}
		Diapair np = new Diapair();

		Diapair ldp = Dia2(node.left);
		Diapair rdp = Dia2(node.right);

		int height = Math.max(ldp.ht, rdp.ht) + 1;

		int ld = ldp.dia;
		int rd = rdp.dia;
		int sw = ldp.ht + rdp.ht + 2;

		np.ht = height;
		np.dia = Math.max(sw, Math.max(ld, rd));
		return np;

	}

	public class BalPair {
		boolean isBal = true;
		int ht = -1;

	}

	public boolean isBalanced() {
		return isBalanced(root).isBal;
	}

	private BalPair isBalanced(Node node) {

		if (node == null) {
			BalPair dp = new BalPair();
			return dp;
		}
		BalPair np = new BalPair();

		BalPair ldp = isBalanced(node.left);
		BalPair rdp = isBalanced(node.right);

		int height = Math.max(ldp.ht, rdp.ht) + 1;

		np.ht = height;
		boolean ld = ldp.isBal;
		boolean rd = rdp.isBal;
		int sw = Math.abs(ldp.ht - rdp.ht);

		np.isBal = ld && rd && sw <= 1;
		return np;
	}

	public class Pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderI() {

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.node = this.root;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tp.selfdone == false) {
				System.out.println(tp.node.data + " ");
				tp.selfdone = true;

			} else if (tp.leftdone == false) {
				Pair np = new Pair();
				np.node = tp.node.left;
				stack.addFirst(np);
				tp.leftdone = true;

			} else if (tp.rightdone == false) {
				Pair np = new Pair();
				np.node = tp.node.right;
				stack.addFirst(np);
				tp.rightdone = true;

			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);
		return nn;
	}

}
