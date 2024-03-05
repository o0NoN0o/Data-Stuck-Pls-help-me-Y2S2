
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		DListIterator bi1 = new DListIterator(i1.currentNode.previousNode);
		DListIterator ai1 = new DListIterator(i1.currentNode.nextNode);
		DListIterator bi2 = new DListIterator(i2.currentNode.previousNode);                   //exact same as hw
		DListIterator ai2 = new DListIterator(i2.currentNode.nextNode);
		
		bi1.currentNode.nextNode = i2.currentNode;
		bi2.currentNode.nextNode = i1.currentNode;
		ai1.currentNode.previousNode = i2.currentNode;
		ai2.currentNode.previousNode = i1.currentNode;
		
		i1.currentNode.previousNode = bi2.currentNode;
		i1.currentNode.nextNode = ai2.currentNode;
		i2.currentNode.previousNode = bi1.currentNode;
		i2.currentNode.nextNode = ai1.currentNode;
		
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if (lst.isEmpty()) {                                                               
			return;
		} 
		                                                                            //create iterator that mark the end of insertion range
		DListIterator ai1 = new DListIterator(i1.currentNode.nextNode);             //i1_______________ai1
		DListIterator hlst = new DListIterator(lst.header);                        
		DListIterator llst = new DListIterator(lst.header);
		hlst.next();                                                                //mark iterator at the first node of the one we want to insert into another
		llst.previous();                                                            //mark the last
		
		i1.currentNode.nextNode = hlst.currentNode;
		ai1.currentNode.previousNode = llst.currentNode;                            //swap pointer
		hlst.currentNode.previousNode = i1.currentNode;
		llst.currentNode.nextNode = ai1.currentNode;
		
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator h = new DListIterator(header);                           //mark point of insert
		DListIterator p = new DListIterator(header);		                   //use to iterate through linked list


		while(p.hasNext()) {                                                   //loop through the whole linked list
			p.next();
			if(p.currentNode.data == null) {
				return;
			}
			String s = ((Student) p.currentNode.data).getSex();                //get the sex of student in linked list
			if(s == g) {                                                       //if s is same sex as g
				insert(p.currentNode.data,h);                                  //insert student at h
				removeAt(p);                                                   //remove student at previous position
				h.next();                                                      //move h so that the next student insert will be after the previous one
			}
		}
		
	}

}
