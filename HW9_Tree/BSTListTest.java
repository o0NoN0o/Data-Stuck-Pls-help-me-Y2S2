import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTListTest {
	BSTList t = new BSTList();
	
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Pairdata> l1 = new ArrayList<Pairdata>();
		l1.add(new Pairdata(7,2));
		l1.add(new Pairdata(7,8));
		l1.add(new Pairdata(7,1));
		
		ArrayList<Pairdata> l2 = new ArrayList<Pairdata>();
		l2.add(new Pairdata(2,5));
		l2.add(new Pairdata(2,3));
		
		ArrayList<Pairdata> l3 = new ArrayList<Pairdata>();
		l3.add(new Pairdata(5,5));
		l3.add(new Pairdata(5,1));
		l3.add(new Pairdata(5,3));
		
		BSTNodeList n1 = new BSTNodeList();
		BSTNodeList n2 = new BSTNodeList();
		BSTNodeList n3 = new BSTNodeList();

		n1.dataList = l1;
		n1.left = n2;
		n2.dataList = l2;
		n2.right = n3;
		n2.parent = n1;
		n3.dataList = l3;
		n3.parent = n2;
		
		t.root = n1;
		t.size= 8;
		
	}
	
	
	@Test
	void testfind1() { // found - 8 mark
		Pairdata p1 = new Pairdata(7, 1);
		Pairdata p2 = new Pairdata(2, 3);
		Pairdata p3 = new Pairdata(5, 1);
		
		BSTNodeList n = t.find(p1);
		assertTrue(n.dataList.contains(p1));
		n = t.find(p2);
		assertTrue(n.dataList.contains(p2));
		n = t.find(p3);
		assertTrue(n.dataList.contains(p3));
	}
	
	@Test
	void testfind2() { // not found in list - 1 mark
		Pairdata p1 = new Pairdata(7, 9);
		Pairdata p2 = new Pairdata(2, 4);
		Pairdata p3 = new Pairdata(5, 2);
		
		BSTNodeList n = t.find(p1);
		assertNull(n);
		n = t.find(p2);
		assertNull(n);
		n = t.find(p3);
		assertNull(n);
	}
	
	@Test
	void testfind3() { // not found node - 1 mark
		Pairdata p1 = new Pairdata(8, 9);
		Pairdata p2 = new Pairdata(1, 4);
		Pairdata p3 = new Pairdata(6, 2);
		
		BSTNodeList n = t.find(p1);
		assertNull(n);
		n = t.find(p2);
		assertNull(n);
		n = t.find(p3);
		assertNull(n);
	}
	
	@Test
	void testinsert1() { // add to existing node = 4 mark
		Pairdata p1 = new Pairdata(5, 8);
		BSTNodeList b = t.insert(p1);
		assertEquals(9,t.size);
		ArrayList<Pairdata> l = t.root.left.right.dataList;
		assertTrue(l.contains(p1));
		assertTrue(b.dataList.contains(p1));
	}
	
	@Test
	void testinsert2() { // add duplicate value - 1 mark
		Pairdata p1 = new Pairdata(5, 5);
		t.insert(p1);
		t.insert(p1);
		t.insert(p1);
		BSTNodeList b = t.insert(p1);
		
		assertEquals(8,t.size);
		ArrayList<Pairdata> l = t.root.left.right.dataList;
		assertTrue(l.contains(p1));
		assertTrue(b.dataList.contains(p1));
		
		int count = 0;
		for (Pairdata pairdata : l) {
			if(pairdata.equals(p1)) count++;
		}
		assertEquals(1,count);
	}
	
	@Test
	void testinsert3() { // add as new node - 5 mark
		Pairdata p1 = new Pairdata(6, 1);
		BSTNodeList b = t.insert(p1);
		assertEquals(9,t.size);
		ArrayList<Pairdata> l = t.root.left.right.right.dataList;
		assertTrue(l.contains(p1));
		assertTrue(b.dataList.contains(p1));
		assertEquals(1,l.size());
		
	}
	
	
	
	
	
	

	
	
	

}
