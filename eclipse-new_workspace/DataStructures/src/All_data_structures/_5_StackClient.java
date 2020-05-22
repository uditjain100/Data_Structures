package All_data_structures;

public class _5_StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		_1_Stack s = new _1_Stack(5);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();

		_2_DynamicStack ds = new _2_DynamicStack(5);

		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.display();

		ds.push(60);
		ds.push(70);
		ds.display();

		_3_StackGeneric<String> gs = new _3_StackGeneric<String>(5);

		gs.push("a");
		gs.push("b");
		gs.push("c");
		gs.push("d");
		gs.push("e");
		gs.display();

		_4_DynamicStackGeneric<String> dgs = new _4_DynamicStackGeneric<String>(5);

		dgs.push("a");
		dgs.push("b");
		dgs.push("c");
		dgs.push("d");
		dgs.push("e");
		dgs.display();
		dgs.push("f");
		dgs.push("g");
		dgs.display();
	}

}
