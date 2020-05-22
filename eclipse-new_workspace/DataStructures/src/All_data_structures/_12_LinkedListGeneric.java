package All_data_structures;

import All_data_structures._11_LinkedList.Node;

public class _12_LinkedListGeneric<T> {

	class Node {
		T data;
		Node next;

		public Node() {
			this.data = null;
			this.next = null;
		}

		public Node(T data) {
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

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addLast(T data) {

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

	public void addFirst(T data) {

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

	public void addAt(int idx, T data) throws Exception {

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

	public T getFirst() throws Exception {

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

	public T getLast() throws Exception {

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

	public T getAt(int idx) throws Exception {

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

	public T removeFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		T rv = this.head.data;
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

	public T removeLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("List is Empty");
		}

		T rv = this.tail.data;
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

	public T removeAt(int idx) throws Exception {

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
			T rv = prev.next.data;
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

	public int find(T data) {

		int idx = 0;
		Node temp = this.head;
		while (temp != null) {
			if (temp.data.equals(data)) {
				return idx;
			}
			idx++;
			temp = temp.next;
		}
		return -1;
	}
}
