import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetQueueArrayEmptyQueue() { //0.5
		MyQueue q = new QueueArray();
		boolean throwException = false;
		try {
			q.get(0);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	@Test
	void testGetQueueArrayNegPos() throws Exception { //0.5
		MyQueue q = new QueueArray();
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		boolean throwException = false; 
		try {
			q.get(-1);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	@Test
	void testGetQueueArrayTooLargePos() throws Exception { //0.5
		MyQueue q = new QueueArray();
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		boolean throwException = false; 
		try {
			q.get(3);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	
	@Test
	void testGetQueueArrayOK() throws Exception { //2.5
		MyQueue q = new QueueArray();

		q.insertLast(1);
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		q.insertLast(9);
		q.insertLast(11);
		q.insertLast(13);
		q.insertLast(15);
		q.insertLast(17);
		q.insertLast(19);
		q.removeFirst();
		q.removeFirst();
		q.removeFirst();
		q.insertLast(21);
		q.insertLast(23);
		
		assertEquals(7,q.get(0));
		assertEquals(9,q.get(1));
		assertEquals(17,q.get(5));
		assertEquals(21,q.get(7));
		assertEquals(23,q.get(8));
		
	}
	
	@Test
	void testGetQueueListEmptyQueue() { //0.5
		MyQueue q = new QueueLinkedList();
		boolean throwException = false;
		try {
			q.get(0);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	@Test
	void testGetQueueListNegPos() throws Exception { //0.5
		MyQueue q = new QueueLinkedList();
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		
		boolean throwException = false; 
		try {
			q.get(-1);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	@Test
	void testGetQueueListTooLargePos() throws Exception { //0.5
		MyQueue q = new QueueLinkedList();
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		q.insertLast(8);
		boolean throwException = false; 
		try {
			q.get(4);
		} catch (Exception e) {
			throwException = true;
		}
		assertTrue(throwException);
	}
	
	@Test
	void testGetQueueListOK() throws Exception { //2.5
		MyQueue q = new QueueLinkedList();
		q.insertLast(1);
		q.insertLast(3);
		q.insertLast(5);
		q.insertLast(7);
		q.insertLast(9);
		q.insertLast(11);
		q.insertLast(13);
		q.insertLast(15);
		q.insertLast(17);
		q.insertLast(19);
		q.removeFirst();
		q.removeFirst();
		q.removeFirst();
		q.insertLast(21);
		q.insertLast(23);
		
		assertEquals(7,q.get(0));
		assertEquals(9,q.get(1));
		assertEquals(17,q.get(5));
		assertEquals(21,q.get(7));
		assertEquals(23,q.get(8));
	}
	
	

}
