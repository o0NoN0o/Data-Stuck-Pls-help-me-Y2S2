import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class BSTTest {

	@Test
	void testAddEmptySubTree() { // 1 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.addLeftSubTreeToNode(t1,t0.root);
		assertEquals(null, t0.root);
		assertEquals(0, t0.size);
		
		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);

		t0.addLeftSubTreeToNode(t1,t0.root.left.right);
		assertEquals(7, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);
		assertNull(t0.root.left.left.left);
		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.left);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);
		
	}

	@Test
	void testAddToEmptyTree() { // 1 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t1.insert(2);
		t1.insert(0);
		t1.insert(5);

		t0.addLeftSubTreeToNode(t1,t0.root);
		assertEquals(3, t0.size);
		assertEquals(2, t0.root.data);
		assertEquals(0, t0.root.left.data);
		assertEquals(5, t0.root.right.data);

	}

	@Test
	void testAddToLeftMostSuccess() { // 1 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(1);
		t1.insert(0);
		t1.insert(4);
		t1.insert(3);

		t0.addLeftSubTreeToNode(t1,t0.root.left.left);
		assertEquals(11, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);

		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.left);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);
		
		assertEquals(1, t0.root.left.left.left.data);
		assertEquals(0, t0.root.left.left.left.left.data);
		assertEquals(4, t0.root.left.left.left.right.data);
		assertEquals(3, t0.root.left.left.left.right.left.data);
		assertEquals(t0.root.left.left,t0.root.left.left.left.parent);

	}

	@Test
	void testAddToLeftMostFail() { // 1 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(1);
		t1.insert(0);
		t1.insert(6);
		t1.insert(3);

		t0.addLeftSubTreeToNode(t1,t0.root.left.left);
		assertEquals(7, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);
		assertNull(t0.root.left.left.left);
		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.left);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);

	}
	
	@Test
	void testAddToMiddleSuccess() { // 3 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(23);
		t1.insert(24);
		t1.insert(21);
		t1.insert(22);

		t0.addLeftSubTreeToNode(t1,t0.root.right.left);
		assertEquals(11, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);
		assertNull(t0.root.left.left.left);
		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);
		
		assertEquals(23, t0.root.right.left.left.data);
		assertEquals(21, t0.root.right.left.left.left.data);
		assertEquals(24, t0.root.right.left.left.right.data);
		assertEquals(22, t0.root.right.left.left.left.right.data);
		assertEquals(t0.root.right.left,t0.root.right.left.left.parent);

	}
	
	@Test
	void testAddToMiddleFail01() { // 2 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(23);
		t1.insert(24);
		t1.insert(16);
		t1.insert(22);

		t0.addLeftSubTreeToNode(t1,t0.root.right.left);
		assertEquals(7, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);
		assertNull(t0.root.left.left.left);
		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.left);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);

	}
	
	@Test
	void testAddToMiddleFail02() { // 1 mark
		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(23);
		t1.insert(31);
		t1.insert(21);
		t1.insert(22);

		t0.addLeftSubTreeToNode(t1,t0.root.right.left);
		assertEquals(7, t0.size);
		assertEquals(20, t0.root.data);
		assertEquals(10, t0.root.left.data);
		assertEquals(30, t0.root.right.data);
		assertEquals(5, t0.root.left.left.data);
		assertEquals(15, t0.root.left.right.data);
		assertEquals(25, t0.root.right.left.data);
		assertEquals(35, t0.root.right.right.data);
		assertNull(t0.root.left.left.left);
		assertNull(t0.root.left.left.right);
		assertNull(t0.root.left.right.left);
		assertNull(t0.root.left.right.right);
		assertNull(t0.root.right.left.left);
		assertNull(t0.root.right.left.right);
		assertNull(t0.root.right.right.left);
		assertNull(t0.root.right.right.right);

	}
	
	

}
