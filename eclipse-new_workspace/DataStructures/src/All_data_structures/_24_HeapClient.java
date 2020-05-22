package All_data_structures;

public class _24_HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_22_Heap tree = new _22_Heap();

		tree.add(4);
		tree.add(10);
		tree.add(7);
		tree.add(26);
		tree.add(78);
		tree.add(40);
		tree.add(54);
		tree.display();

		_23_HeapGeneric<Integer> ttree = new _23_HeapGeneric<Integer>();
		
		ttree.add(4);
		ttree.add(10);
		ttree.add(7);
		ttree.add(26);
		ttree.add(78);
		ttree.add(40);
		ttree.add(54);
		ttree.display();
		
	}

}
