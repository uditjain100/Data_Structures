package All_data_structures;

import java.lang.reflect.Array;

public class _4_DynamicStackGeneric<T> extends _3_StackGeneric<T> {

	public _4_DynamicStackGeneric(int len) throws Exception {
		super(len);
	}

	// Unchecked declaration : In this we do not know that which type of data is to
	// be stored in
	// Stack so, we dynamically declare the array with datatype as Object.
	@Override
	public void push(T val) throws Exception {
		if (this.isFull()) {
			T[] na = (T[]) new Object[this.arr.length * 2];
			for (int i = 0; i < this.arr.length; i++) {
				na[i] = this.arr[i];
			}
			this.arr = (T[]) na;
		}
		super.push(val);
	}

}
