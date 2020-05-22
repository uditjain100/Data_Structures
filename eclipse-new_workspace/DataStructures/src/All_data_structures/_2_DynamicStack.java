package All_data_structures;

public class _2_DynamicStack extends _1_Stack {

	public _2_DynamicStack(int len) throws Exception {
		super(len);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void push(int val) throws Exception {
		if (this.isFull()) {
			int[] na = new int[this.arr.length * 2];
			for (int i = 0; i < this.arr.length; i++) {
				na[i] = this.arr[i];
			}
			this.arr = na;
		}
		super.push(val);
	}

}
