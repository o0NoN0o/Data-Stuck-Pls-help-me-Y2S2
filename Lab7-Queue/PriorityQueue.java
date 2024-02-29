
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		int size = q.size();
		int check;
		boolean insert = false;
		for(int i = 0;i<size;i++) {
			check = q.removeFirst();
			if(insert == false && x < check) {
				q.insertLast(x);
				insert = true;
			}
			q.insertLast(check);
		}
		if(insert == false) {
			q.insertLast(x);
		}
		


	}

	// implement this.
	public void pop() throws Exception {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		q.removeFirst();
		
		
	}

	// implement this
	public int top() throws Exception {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		return q.front();

	}

}
