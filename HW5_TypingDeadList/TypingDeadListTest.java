import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypingDeadListTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testFindWordNotFound1() throws Exception { //1 marks
		TypingDeadList l = new TypingDeadList("abcdefg");
		l.findWord("org");
		assertNull(l.start);
		assertNull(l.end);
	}
	
	@Test
	void testFindWordNotFound2() throws Exception { //1 marks
		TypingDeadList l = new TypingDeadList("abcdefg");
		l.findWord("fga");
		assertNull(l.start);
		assertNull(l.end);
		
		l = new TypingDeadList("abcdefg");
		l.findWord("bag");
		assertNull(l.start);
		assertNull(l.end);
	}
	
	@Test
	void testFindWordFound() throws Exception { //6 marks
		// find "cab" in "abcabcabcabc"
		// start,end will be at positions as indicated below
		
		//             "abcabcabcabc"
		//                ^ ^
		
		TypingDeadList l = new TypingDeadList("abcabcabcabc");
		l.findWord("cab");
		DListIterator d = new DListIterator(l.header);
		d.next();d.next();d.next();
		assertEquals(l.start.currentNode, d.currentNode);
		d.next();d.next();
		assertEquals(l.end.currentNode, d.currentNode);
	}

	@Test
	void testRemoveStartOrEndAtHeader() throws Exception { //1 mark
		// if start or end is at header, do nothing

		TypingDeadList l = new TypingDeadList("I am Ironman.");

		l.start = new DListIterator(l.header);
		DListIterator d = new DListIterator(l.header);
		d.next();
		d.next();
		l.end = d;

		l.remove(0);
		assertEquals(13, l.size);
		l.start.next();
		l.start.next();

		while (d.currentNode != l.header) {
			d.next();
		}

		l.end = d;
		l.remove(0);
		assertEquals(13, l.size);
	}

	@Test
	void testRemoveOneValue() throws Exception {  //1 mark
		// remove c  -> abdefg 
		
		TypingDeadList l = new TypingDeadList("abcdefg");
		l.start = new DListIterator(l.header);
		l.end = new DListIterator(l.header);
		l.start.next();l.start.next();l.start.next();
		l.end.next();l.end.next();l.end.next();
		
		l.remove(1);
		assertEquals(6, l.size);
		assertEquals("a b d e f g" ,l.printList());
		
	}
	
	@Test
	void testRemoveAllValue() throws Exception {  // 2 marks
		// get an empty list if the interval covers all values.

		TypingDeadList l = new TypingDeadList("I am Ironman.");
		l.start = new DListIterator(l.header);
		l.end = new DListIterator(l.header);
		l.end.previous();
		l.start.next();
		l.remove(13);

		assertEquals(0, l.size);
		DListIterator d = new DListIterator(l.header);
		d.next();
		assertEquals(l.header, d.currentNode);
		d.previous();
		assertEquals(l.header, d.currentNode);
	}

	@Test
	void testRemoveGeneric() throws Exception {  //2 marks
		// I am Ironman.
		//      ^  ^
		// start end

		// result in -> I am man.

		TypingDeadList l = new TypingDeadList("I am Ironman.");
		l.start = new DListIterator(l.header);
		l.end = new DListIterator(l.header);

		for (int i = 1; i <= 6; i++) {
			l.start.next();
		}

		for (int i = 1; i <= 9; i++) {
			l.end.next();
		}

		l.remove(4);
		assertEquals(9, l.size);
		assertEquals("I   a m   m a n ." ,l.printList());
		

	}

}
