package All_data_structures;

public class _1_Stack {

	int[] arr;
	int tos;
	int size;

	public _1_Stack(int len) throws Exception {
		if (len < 0) {
			throw new Exception("Illegal length");
		}
		this.arr = new int[len];
		this.tos = -1;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.arr.length;
	}

	public void push(int val) throws Exception {

		if (this.isFull()) {
			throw new Exception("Stack is Full");
		}
		this.tos++;
		this.arr[tos] = val;
		this.size++;
	}

	public int pop() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.arr[tos];
		this.arr[tos--] = 0;
		this.size--;
		return rv;
	}

	public int peek() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.arr[tos];
		return rv;
	}

	public void display() {

		System.out.println("************ : ");
		for (int i = 0; i < this.size; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
		System.out.println("************ : ");

	}

}
