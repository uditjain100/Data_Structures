package All_data_structures;

//It has 2n-1 number of Nodes.
//It is always a full binary tree.

public class _25_SegmentTree {

	private class Node {
		int data;
		int startInterval;
		int endinterval;
		Node left;
		Node right;
	}

	private Node root;

	public _25_SegmentTree(int[] arr) {
		this.root = this.construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int si, int ei) {

		if (si == ei) {
			Node leafNode = new Node();
			leafNode.startInterval = si;
			leafNode.endinterval = ei;
			leafNode.data = arr[si];
			return leafNode;
		}

		Node nn = new Node();
		nn.startInterval = si;
		nn.endinterval = ei;

		int mid = (si + ei) / 2;
		nn.left = this.construct(arr, si, mid);
		nn.right = this.construct(arr, mid + 1, ei);

		nn.data = nn.left.data + nn.right.data;

		return nn;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node parent) {

		String str = " ";
		if (parent.left != null) {
			str += "Interval => [ " + parent.left.startInterval + " - " + parent.left.endinterval + " ] and Data => "
					+ parent.left.data + " => ";
		} else {
			str += "No Left Child => ";
		}

		str += "Interval => [ " + parent.startInterval + " - " + parent.endinterval + " ] and Data => " + parent.data;

		if (parent.right != null) {
			str += " <= data is = " + parent.right.data + " and Interval = [ " + parent.right.startInterval + "-"
					+ parent.right.endinterval + "]";
		} else {
			str += " <= No right Child ";
		}

		System.out.println(str);

		if (parent.left != null) {
			this.display(parent.left);
		}

		if (parent.right != null) {
			this.display(parent.right);
		}

	}

	public int query(int qsi, int qei) {
		return this.query(this.root, qsi, qei);
	}

	private int query(Node parent, int qsi, int qei) {

		if (qsi >= parent.startInterval && qei <= parent.endinterval) {
			return parent.data;
		} else if (qsi < parent.startInterval || qei > parent.endinterval) {
			return 0;
		} else {
			int leftAns = this.query(parent.left, qsi, qei);
			int rightAns = this.query(parent.right, qsi, qei);
			return leftAns + rightAns;
		}

	}

	public int update(int index, int newValue) {
		return this.update(this.root, index, newValue);
	}

	private int update(Node parent, int index, int newValue) {

		if (index >= parent.startInterval && index <= parent.endinterval) {
			if (index == parent.startInterval && index == parent.endinterval) {
				parent.data = newValue;
			} else {
				int leftAns = this.update(parent.left, index, newValue);
				int rightAns = this.update(parent.right, index, newValue);
				parent.data = leftAns + rightAns;
			}
		}

		return parent.data;

	}

}
