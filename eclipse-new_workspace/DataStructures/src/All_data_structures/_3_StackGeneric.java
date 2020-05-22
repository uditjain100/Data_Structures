package All_data_structures;

import java.lang.reflect.Array;

public class _3_StackGeneric<T> {

	T arr[];
	int tos;
	int size;

	// Checked declaration : In this we know that c is the type of data which is
	// going to be stored in Stack.
	//this.arr = (T[])Array.newInstance(c , len) ;
	public _3_StackGeneric(int len) throws Exception {
		if (len < 0) {
			throw new Exception("Illegal length");
		}
		this.arr = (T[]) new Object[len];
		this.tos = -1;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.arr.length;
	}

	public void push(T val) throws Exception {

		if (this.isFull()) {
			throw new Exception("Stack is Full");
		}
		this.tos++;
		this.arr[tos] = val;
		this.size++;
	}

	public T pop() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		T rv = this.arr[tos];
		this.arr[tos--] = null;
		this.size--;
		return rv;
	}

	public T peek() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		T rv = this.arr[tos];
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
