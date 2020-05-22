package All_data_structures;

public class _13_LinkedListClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_11_LinkedList list = new _11_LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.display();

		_12_LinkedListGeneric<String> glist = new _12_LinkedListGeneric<String>();

		glist.addLast("a");
		glist.addLast("b");
		glist.addLast("c");
		glist.addLast("d");
		glist.addLast("e");
		glist.addLast("f");
		glist.display();
		
	}

}
