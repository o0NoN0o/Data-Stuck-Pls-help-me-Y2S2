class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}
//

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception{
		MyListIterator p = new MyListIterator(header);
		int num = 0;
		while(p.hasNext()) {                                       //run through the whole linked list and add 1 to size for each node
			p.next();
			num ++;
		}
		return num;

	}
	
	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception{
		MyListIterator p = new MyListIterator(header);            //run through the whole linked list and print each node data
		while(p.hasNext()) {
			p.next();
			System.out.println(p.currentNode.data);
		}

	}

	//Return iterator pointing to value that stores a given name, or null otherwise.
	//To be completed by students.
	public Iterator findPosition(String name) throws Exception{  
		MyListIterator p = new MyListIterator(header);           
		Contact c = new Contact();                               //create a new contact to store the 
		c.name = name;                                           //(equal to method can only compare 2 contact)
		while(p.hasNext()) {
			p.next();                                            //run through each node and compare the name of 2 contact
			if(p.currentNode.data.equals(c)) {
				return p;
			}
		}
		return null;
	}
	
	//add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.	
	public void add(Object c) throws Exception{                                                        
		MyListIterator p = new MyListIterator(header);                   
		while(p.hasNext()) {                                                                              //run through the whole linked list
			p.next();
			if(((Contact)p.currentNode.data).name.compareToIgnoreCase(((Contact)c).name) > 0) {           //compare the name of the node by compareToIgnoreCase
				p = (MyListIterator)findPrevious(p.currentNode.data);
				break;
			}
		}
		insert((Object) c,p);                                                                            //if come before(>0) add it to front
	}
	
	//Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact. 
	//If the removed contact is the last one, return the iterator pointing to the first contact 
	//   (if there is no first contact, make the iterator point to header). 
	//If i is marking an illegal position that cannot be removed, just return null. 
	//To be completed by students.
	public Iterator removeAt(Iterator i) throws Exception{
		MyListIterator p = new MyListIterator(header);
		MyListIterator h = new MyListIterator(header);
		MyListIterator c = (MyListIterator) i;
		if(c == null||c.currentNode == null||c.currentNode.data == null) {
			return null;
		}
		p = (MyListIterator) findPrevious(((MyListIterator)i).currentNode.data);
		remove(p);
		if(p.hasNext()) {
			p.next();
		} else if(h.hasNext()){
			h.next();
			return h;
		}		
		return p;
	}
	

}