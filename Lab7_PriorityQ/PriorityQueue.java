
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (q.isEmpty()) {                                   //if there is nothing in q yet add it in
			q.insertLast(x);
			return;
		}
		int size = q.size();
		int check;
		boolean insert = false;                              //boolean to check if already insert to q
		for(int i = 0;i<size;i++) {                          //for loop with the number of time as the q size
			check = q.removeFirst();                         //loop the first value to the back
			if(insert == false && x < check) {               //if not insert yet and if x is less than the front value
				q.insertLast(x);                             //insert x before adding the first value to the back
				insert = true;
			}
			q.insertLast(check);                            
		}
		if(insert == false) {                                //if looped through all element in q and is all less than x insert x last
			q.insertLast(x);
		}
		


	}

	// implement this.
	public void pop() throws Exception {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		q.removeFirst();                                      //since the lowest is always at the front remove front
		
		
	}

	// implement this
	public int top() throws Exception {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		return q.front();                                     //since the lowest is always at the front return front

	}

}
