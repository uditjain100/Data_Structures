package All_data_structures;

public class _11_LinkedList {

	class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;
	Node tail;
	int size;

	public int size() {
		return this.size;
	}

	public void addLast(int data) {

		Node nn = new Node(data);

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size = 1;
		} else {
			this.tail.next = nn;
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int data) {

		Node nn = new Node(data);

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size = 1;
		} else {
			nn.next = this.head;
			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int idx, int data) throws Exception {

		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid Index");
		}

		Node nn = new Node(data);

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node prev = this.getNodeAt(idx);
			Node nexxt = prev.next;

			prev.next = nn;
			nn.next = nexxt;
			this.size++;
		}
	}

	public int getFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		return this.head.data;

	}

	public Node getNodeFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		return this.head;

	}

	public int getLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;

	}

	public Node getNodeLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		return this.tail;

	}

	public int getAt(int idx) throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return this.getFirst();
		} else if (idx == this.size()) {
			return this.getLast();
		} else {
			Node temp = this.head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp.data;
		}

	}

	public Node getNodeAt(int idx) throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return this.getNodeFirst();
		} else if (idx == this.size()) {
			return this.getNodeLast();
		} else {
			Node temp = this.head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	public int removeFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		int rv = this.head.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	public int removeLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		int rv = this.tail.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node lastNode = this.getNodeAt(this.size - 2);
			this.tail = lastNode;
			lastNode.next = null;
			this.size--;
		}

		return rv;
	}

	public int removeAt(int idx) throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size()) {
			return this.removeLast();
		} else {
			Node prev = this.getNodeAt(idx - 1);
			int rv = prev.next.data;
			Node nexxt = prev.next.next;

			prev.next = nexxt;
			this.size--;
			return rv;
		}
	}

	public void display() {
		System.out.println("************* : ");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();
		System.out.println("************* : ");
	}
}
