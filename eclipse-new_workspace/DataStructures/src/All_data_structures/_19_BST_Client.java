package All_data_structures;

public class _19_BST_Client {

	
	public static void main(String[] args) {
		

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };

		_18_BST tree = new _18_BST(arr);
		
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(150);
		tree.add(75);
		tree.add(80);
		tree.add(30);
		tree.display();
		
		
	}
	
	
}
