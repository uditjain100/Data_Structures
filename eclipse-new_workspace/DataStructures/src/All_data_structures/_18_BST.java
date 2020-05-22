package All_data_structures;

public class _18_BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public _18_BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}
		int mid = (ilo + ihi) / 2;
		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);
		return nn;

	}

	public void display() {
		display(this.root);
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

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}
		return max(node.right);

	}

	public boolean find(int item) {
		return find(this.root, 0);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}
		if (node.data > item) {
			return find(node.right, item);
		} else if (node.data < item) {
			return find(node.left, item);
		} else {
			return true;
		}
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}
		int hl = ht(node.left);
		int hr = ht(node.right);

		int a = Math.max(hl, hr);
		return a + 1;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public void printdec() {
		printdec(root);
	}

	private void printdec(Node node) {
		if (node == null) {
			return;
		}

		printdec(node.right);
		System.out.print(node.data + " ");
		printdec(node.left);

	}

	public void PrintInRange(int lo, int hi) {
		PrintInRange(root, lo, hi);
	}

	private void PrintInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}
		if (node.data < lo) {
			PrintInRange(node.right, lo, hi);
		}
		if (node.data > hi) {
			PrintInRange(node.left, lo, hi);
		}
		if (node.data >= lo && node.data <= hi) {

			PrintInRange(node.left, lo, hi);
			System.out.print(node.data + " ");
			PrintInRange(node.right, lo, hi);
		}

	}

	public class Heapmover {
		int sum = 0;
	}

	public void ReplaceWithSumLarger() {
		ReplaceWithSumLarger(root, new Heapmover());
	}

	private void ReplaceWithSumLarger(Node node, Heapmover mover) {
		if (node == null)
			return;

		ReplaceWithSumLarger(node.right, mover);
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		ReplaceWithSumLarger(node.left, mover);

	}

	public void add(int item) {
		add(root, item);
	}

	private void add(Node node, int item) {

		if (node.data >= item) {
			if (node.left != null) {
				add(node.left, item);
			} else {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			}
		} else {
			if (node.right != null) {
				add(node.right, item);
			} else {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			}
		}
	}

	public void remove(int item) {
		remove(root, null, item);
	}

	private void remove(Node node, Node parent, int item) {

		if (node.data > item) {
			remove(node.left, node, item);
		} else if (node.data < item) {
			remove(node.right, node, item);
		} else {

			if (node.left == null && node.right == null) {
				if (node.data > parent.data) {
					parent.right = null;
				} else {
					parent.left = null;
				}
			} else if (node.left != null && node.right == null) {
				if (node.data < parent.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.left == null && node.right != null) {
				if (node.data < parent.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				remove(node.left, node, lmax);
			}

		}

	}

}
