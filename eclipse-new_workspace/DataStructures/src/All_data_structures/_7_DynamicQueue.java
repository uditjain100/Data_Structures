package All_data_structures;

public class _7_DynamicQueue extends _6_Queue {

	public _7_DynamicQueue(int len) throws Exception {
		super(len);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enqueue(int val) throws Exception {
		if (this.isFull()) {
			int[] na = new int[2 * this.arr.length];
			for (int i = 0; i < this.size; i++) {
				int index = (this.front + i) % this.arr.length;
				na[i] = this.arr[index];
			}
			this.arr = na;
			this.front = 0;
		}
		super.enqueue(val);
	}

}
