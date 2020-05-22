package All_data_structures;

public class _9_DynamicQueueGeneric<T> extends _8_QueueGeneric<T> {

	public _9_DynamicQueueGeneric(int len) throws Exception {
		super(len);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(T val) throws Exception {
		if (this.isFull()) {
			Object[] na = (T[]) new Object[2 * this.arr.length];
			for (int i = 0; i < this.arr.length; i++) {
				int index = (this.front + i) % this.arr.length;
				na[i] = this.arr[index];
			}
			this.arr = (T[]) na;
			this.front = 0;
		}
		super.enqueue(val);

	}

}
