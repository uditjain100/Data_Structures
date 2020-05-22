package All_data_structures;

public class _6_Queue {

	int[] arr;
	int front;
	int size;

	public _6_Queue(int len) throws Exception {

		if (len < 0) {
			throw new Exception("Illegal length");
		}

		this.arr = new int[len];
		this.front = 0;
		this.size = 0;

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.arr.length;
	}

	public void enqueue(int val) throws Exception {

		if (this.isFull()) {
			throw new Exception("Queue is Full");
		}

		int index = (this.front + this.size) % this.arr.length;
		this.arr[index] = val;
		this.size++;

	}

	public int dequeue() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int rv = this.arr[this.front];
		this.arr[this.front] = 0;
		this.front = (this.front + 1) % this.arr.length;
		this.size--;
		return rv;

	}

	public int getFront() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}

		int rv = this.arr[this.front];
		return rv;

	}

	public void display() {

		System.out.println("************* : ");
		for (int i = 0; i < this.size; i++) {
			int index = (this.front + i) % this.arr.length;
			System.out.print(this.arr[index] + " ");
		}
		System.out.println();
		System.out.println("************* : ");
	}

}
