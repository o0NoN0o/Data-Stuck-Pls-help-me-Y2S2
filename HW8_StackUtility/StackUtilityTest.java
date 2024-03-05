import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackUtilityTest {
	MyStack s1;
	MyStack s2;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new StackLinkedList();
		s2 = new StackArray();
	}

	@Test
	void testWordSimpleAdd() throws Exception{ // 1 mark
		s1.push(4);
		s1.push(5);
		
		s2.push(0);
		assertEquals("j",StackUtility.operate(s1, s2));
	}
	
	@Test
	void testWordSimpleSubtract() throws Exception{ // 1 mark
		s1.push(4);
		s1.push(9);
		
		s2.push(-11);
		assertEquals("f",StackUtility.operate(s1, s2));
	}
	
	@Test
	void testWordSimpleSequence() throws Exception{ // 1 mark
		s1.push(3);
		s1.push(8);
		s1.push(2);
		s1.push(11);
		
		s2.push(4);
		s2.push(-7);
		assertEquals("lj",StackUtility.operate(s1, s2));
	}

	@Test
	void testWord01() throws Exception { //3 marks 
		s1.push(4);
		s1.push(2);
		s1.push(4);
		s1.push(0);
		s1.push(0);
		s1.push(1);
		s1.push(20);
		
		s2.push(7);
		s2.push(-8);
		s2.push(-4);
		s2.push(-2);
		s2.push(5);
		s2.push(-4);
	

		assertEquals("cat",StackUtility.operate(s1, s2));

	}
	
	@Test
	void testWord02() throws Exception {  //3 marks
		s1.push(7);
		s1.push(8);
		s1.push(4);
		s1.push(0);
		s1.push(14);
		s1.push(4);
		s1.push(25);	
		s1.push(3);
		s1.push(1);
	
		s2.push(0);
		s2.push(-5);
		s2.push(-8);
		s2.push(1);
		
		assertEquals("move",StackUtility.operate(s1, s2));
		
	}

	@Test
	void testWord03() throws Exception {  //3 marks
		s1.push(8);
		s1.push(30);
		s1.push(8);
		s1.push(8);
		s1.push(10);
		s1.push(9);
		s1.push(1);
		s1.push(1);
		s1.push(3);
		s1.push(4);

		s2.push(8);
		s2.push(-1);
		s2.push(-1);
		s2.push(-1);
		s2.push(0);
		s2.push(0);
		s2.push(1);
		assertEquals("watch",StackUtility.operate(s1, s2));
		
	}
	


}
