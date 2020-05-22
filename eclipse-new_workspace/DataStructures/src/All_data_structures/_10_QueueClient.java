package All_data_structures;

public class _10_QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		_6_Queue q = new _6_Queue(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();

		_7_DynamicQueue dq = new _7_DynamicQueue(5);

		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.display();
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.display();

		_8_QueueGeneric<String> gq = new _8_QueueGeneric<String>(5);

		gq.enqueue("a");
		gq.enqueue("b");
		gq.enqueue("c");
		gq.enqueue("d");
		gq.enqueue("e");
		gq.display();
		
		_9_DynamicQueueGeneric<String> dgq = new _9_DynamicQueueGeneric<String>(5);
		
		dgq.enqueue("a");
		dgq.enqueue("b");
		dgq.enqueue("c");
		dgq.enqueue("d");
		dgq.enqueue("e");
		dgq.display();
		dgq.enqueue("a");
		dgq.enqueue("b");
		dgq.enqueue("c");
		dgq.enqueue("d");
		dgq.enqueue("e");
		dgq.display();
		
	}

}
