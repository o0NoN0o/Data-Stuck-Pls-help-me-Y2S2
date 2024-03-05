

public class QueueArray implements MyQueue {
	protected int[] theArray;
	protected int size; // number of currently stored data.
	protected int front; // index of the first data

	static final int DEFAULT_CAPACITY = 10;

	public QueueArray() {
		this(DEFAULT_CAPACITY);
	}

	public QueueArray(int capacity) {
		theArray = new int[capacity];
		size = 0;
		front = -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == theArray.length;
	}

	public void makeEmpty() {
		size = 0;
		front = -1;
	}

	public int size() {
		return size;
	}

	public int front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[front];
	}

	public int back() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[(front + size - 1) % theArray.length];
	}

	/*
	 * return an item at the front of the queue, delete that item. Throw
	 * exception if the queue is empty.
	 */
	public int removeFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		size--;

		int frontItem = theArray[front];
		front = (front + 1) % theArray.length;
		return frontItem;
	}

	public void doubleCapacity() { // resize array to twice the original size
		int[] temp = new int[theArray.length * 2];
		
		//cannot use arraycopy because we have to go round the array
		for (int i = 0; i < size; i++) {
			temp[i] = theArray[(front+i)%theArray.length];
		}
		theArray = temp;
		front =0;
	}

	public void insertLast(int data) {
		if (isFull())
			doubleCapacity();
		if(isEmpty())
			front=0;
		theArray[(front + size) % theArray.length] = data;
		size++;
	}
	
	public int get(int pos) throws Exception {
		//TODO
		//FILL CODE
		if(pos > this.size()-1 || pos < 0) {            //if pos too large or neg throw exception
			throw new Exception();
		}
		if(this.size() == 0) {                         //if q empty throw exception
			throw new EmptyQueueException();
		}
		
		int size = this.size();
		int posi = 0;
		int ans = 0;
		for(int i = 0;i < size;i++) {                 //loop q a whole cycle
			if(posi == pos) {                         //check if position of first element is the same
				ans = this.front();                  //!!need to check before first loop
			}
			this.insertLast(this.front());             
			this.removeFirst();
			posi++;                                  //add position after loop
			
		}
		return ans;
		}
		
		
	
	public static void main(String[] args) {
		int d = (0)%5;
		System.out.println(d);
	}

}
